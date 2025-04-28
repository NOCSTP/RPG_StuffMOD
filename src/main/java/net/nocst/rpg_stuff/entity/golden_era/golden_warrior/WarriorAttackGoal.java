package net.nocst.rpg_stuff.entity.golden_era.golden_warrior;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;
import net.nocst.rpg_stuff.entity.basic.BasicEntity;

import java.util.EnumSet;

public class WarriorAttackGoal extends MeleeAttackGoal {
    private final BasicEntity entity;
    private int attackDelay = 10;
    private double speedModifier;
    private int ticksUntilNextAttack = 10;
    private boolean shouldCountTillNExtAttack = false;
    private  boolean followingTargetEventIfNotSeen;
    private Path path;
    private double pathedTargetX;
    private double pathedTargetY;
    private double pathedTargetZ;
    private int ticksUntilNextPathRecalculation;
    private final int attackInterval = 20;
    private long lastCanUseCheck;
    private static final long COOLDOWN_BETWEEN_CAN_USE_CHECKS = 20L;
    private int failedPathFindingPenalty = 0;
    private boolean canPenalize = false;

    public WarriorAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargettEventIfNotSeen){
        super(pMob, pSpeedModifier, pFollowingTargettEventIfNotSeen);
        this.entity = ((BasicEntity) pMob);
        this.followingTargetEventIfNotSeen = pFollowingTargettEventIfNotSeen;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        this.speedModifier = pSpeedModifier;

    }


    @Override
    public void tick() {
//        super.tick();

        LivingEntity target = this.mob.getTarget();
        if (target != null) {
            this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
            double distanceSq = this.mob.getPerceivedTargetDistanceSquareForMeleeAttack(target);
            this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
            if ((this.followingTargetEventIfNotSeen || this.mob.getSensing().hasLineOfSight(target)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D || target.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.mob.getRandom().nextFloat() < 0.05F)) {
                this.pathedTargetX = target.getX();
                this.pathedTargetY = target.getY();
                this.pathedTargetZ = target.getZ();
                this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);

                if (this.canPenalize) {
                    this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                    if (this.mob.getNavigation().getPath() != null) {
                        net.minecraft.world.level.pathfinder.Node finalPathPoint = this.mob.getNavigation().getPath().getEndNode();
                        if (finalPathPoint != null && target.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
                            failedPathFindingPenalty = 0;
                        else
                            failedPathFindingPenalty += 10;
                    } else {
                        failedPathFindingPenalty += 10;
                    }
                }
                if (distanceSq > 1024.0D) {
                    this.ticksUntilNextPathRecalculation += 10;
                } else if (distanceSq > 256.0D) {
                    this.ticksUntilNextPathRecalculation += 5;
                }

                if (!this.mob.getNavigation().moveTo(target, this.speedModifier)) {
                    this.ticksUntilNextPathRecalculation += 15;
                }

                this.ticksUntilNextPathRecalculation = this.adjustedTickDelay(this.ticksUntilNextPathRecalculation);
                }
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndPerformAttack(target, distanceSq);
            }
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 5;
        ticksUntilNextAttack = 5;
    }


    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr) && isTimeToAttack()) {
            resetAttackCooldown();
            mob.swing(InteractionHand.MAIN_HAND);
            entity.setAttacking(isTimeToStartAttackAnimation());
            // 👉 Тут можеш реалізувати перевірку на блок, парирування тощо
            mob.doHurtTarget(pEnemy);
        }

    }

}
