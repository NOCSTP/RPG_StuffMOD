package net.nocst.rpg_stuff.entity.skelets.golden_skeleton;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class GoldenSkeletonAttackGoal extends MeleeAttackGoal {
    private final GoldenSkeletonEntity entity;
    private int attackDelay = 5;
    private int ticksUntilNextAttack = 5;
    private boolean shouldCountTillNExtAttack = false;

    public GoldenSkeletonAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargettEventIfNotSeen){
        super(pMob, pSpeedModifier, pFollowingTargettEventIfNotSeen);
        this.entity = ((GoldenSkeletonEntity) pMob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 5;
        ticksUntilNextAttack = 5;
    }

    @Override
    public void tick() {
        super.tick();

        LivingEntity target = this.mob.getTarget();
        if (target != null) {
            double distanceSq = this.mob.distanceToSqr(target);

            if (isEnemyWithinAttackDistance(target, distanceSq)) {
                shouldCountTillNExtAttack = true;
                --ticksUntilNextAttack;

                entity.setAttacking(isTimeToStartAttackAnimation());

                if (isTimeToAttack()) {
                    performAttack(target);
                }
            } else {
                shouldCountTillNExtAttack = false;
                ticksUntilNextAttack = attackDelay; // або reset
                entity.setAttacking(false);
            }
        } else {
            entity.setAttacking(false);
        }
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


    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
    }


}
