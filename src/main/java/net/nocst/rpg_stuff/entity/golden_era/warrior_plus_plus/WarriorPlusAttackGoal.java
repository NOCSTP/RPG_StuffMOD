//package net.nocst.rpg_stuff.entity.golden_era.warrior_plus_plus;
//
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.PathfinderMob;
//import net.minecraft.world.entity.ai.goal.Goal;
//import net.minecraft.world.level.pathfinder.Path;
//import net.minecraft.world.phys.Vec3;
//
//import java.util.EnumSet;
//
//public class WarriorPlusAttackGoal extends Goal {
//
//    protected final PathfinderMob mob;
//    private final double speedModifier;
//    private final boolean followingTargetEvenIfNotSeen;
//    private Path path;
//    protected long lastCanUseCheck;
//    private boolean canPenalize = false;
//    private WarriorPlusPlusEntity.AttackType currenAttackType;
//    private int ticksTillAttack;
//    private int tickTillAttackEnd;
//    private int ticksUntilNextPathRecalculation;
//    private double pathedTargetX;
//    private double pathedTargetY;
//    private double pathedTargetZ;
//    private int failedPathFindingPenalty = 0;
//    private int ticksUntilNextAttack;
//    private Vec3 dashDirection;
//    private int currentAttackTicks = 0;
//    private boolean nowAttacking;
//
//
//
//    public WarriorPlusAttackGoal(PathfinderMob mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
//
//        this.mob = mob;
//        this.speedModifier = speedModifier;
//        this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
//        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
//    }
//
//
//
//    @Override
//    public boolean canUse() {
//        LivingEntity target = this.mob.getTarget();
//        if (target == null) {
//            return false;
//        } else if (!target.isAlive()) {
//            return false;
//        } else {
//            this.path = this.mob.getNavigation().createPath(target, 0);
//            if (this.path != null) {
//                return true;
//            } else {
//                return this.getAttackReachSqr(target) >= this.mob.distanceToSqr(target.getX(), target.getY(), target.getZ());
//            }
//
//        }
//    }
//
//
//    public void tick(){
//        LivingEntity livingentity = this.mob.getTarget();
//        if (livingentity != null) {
//            this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
//            double d0 = this.mob.getPerceivedTargetDistanceSquareForMeleeAttack(livingentity);
//            this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
//            if // чи оновлювати маршрут
//            ((this.followingTargetEvenIfNotSeen || this.mob.getSensing().hasLineOfSight(livingentity))
//                    && this.ticksUntilNextPathRecalculation <= 0 &&
//                    (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D &&
//                            this.pathedTargetZ == 0.0D ||
//                            livingentity.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.mob.getRandom().nextFloat() < 0.05F)) {
//                // 4.1. Зберігаємо нову цільову точку
//                this.pathedTargetX = livingentity.getX();
//                this.pathedTargetY = livingentity.getY();
//                this.pathedTargetZ = livingentity.getZ();
//                // 4.2. Встановлюємо новий таймер для перерахунку
//                this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
//                // 4.3. Якщо включена "штрафна система" (canPenalize)
//                if (this.canPenalize) {
//                    this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
//                    if (this.mob.getNavigation().getPath() != null) {
//                        net.minecraft.world.level.pathfinder.Node finalPathPoint = this.mob.getNavigation().getPath().getEndNode();
//                        if (finalPathPoint != null && livingentity.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
//                            failedPathFindingPenalty = 0;
//                        else
//                            failedPathFindingPenalty += 10;
//                    } else {
//                        failedPathFindingPenalty += 10;
//                    }
//                }
//                // 4.4. Якщо дуже далеко — збільшуємо час до наступної перерахунку
//                if (d0 > 1024.0D) {
//                    this.ticksUntilNextPathRecalculation += 10;
//                } else if (d0 > 256.0D) {
//                    this.ticksUntilNextPathRecalculation += 5;
//                }
//                // 4.5. Переходимо до цілі
//                if (!this.mob.getNavigation().moveTo(livingentity, this.speedModifier)) {
//                    this.ticksUntilNextPathRecalculation += 15;
//                }
//
//                this.ticksUntilNextPathRecalculation = this.adjustedTickDelay(this.ticksUntilNextPathRecalculation);
//            }
//            double deltaY = Math.abs(livingentity.getY() - this.mob.getY());
//            if (d0 >= 10.0D && d0 <= 20.0D && deltaY <= 2.0D && this.mob.getSensing().hasLineOfSight(livingentity)){
//                startDashTowards(livingentity, d0, deltaY);
//            }
//                // якщо шлях оновлювати не треба тоді
////            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
////            this.checkAndPerformAttack(livingentity, d0);
//
//        }
//    }
//
//
//
//
//    protected double getAttackReachSqr(LivingEntity target) {
//        return (double)(this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + target.getBbWidth());
//    }
//
//    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
//        double d0 = this.getAttackReachSqr(pEnemy);
//        if (pDistToEnemySqr <= d0 && this.ticksUntilNextAttack <= 0) {
//            this.resetAttackCooldown();
//            this.mob.swing(InteractionHand.MAIN_HAND);
//            this.mob.doHurtTarget(pEnemy);
//        }
//    }
//
//    private void startDashTowards(LivingEntity target, double distance, double deltaY) {
//
//        Vec3 dir = new Vec3(
//                target.getX() - this.mob.getX(),
//                0, // Без зміни по висоті
//                target.getZ() - this.mob.getZ()
//        ).normalize();
//        this.dashDirection = dir;
//        this.nowAttacking = true;
//        this.currentAttackTicks = 0;
//
//        // Зупинити звичайну навігацію
//        this.mob.getNavigation().stop();
//
//        // Запустити анімацію DashAttack
//        WarriorPlusPlusEntity.AttackType.DashAttack.runAnimation((WarriorPlusPlusEntity) this.mob);
//    }
//
//    // Логіка ривка
//    private void doDash() {
//        if (currentAttackTicks < DASH_DURATION_TICKS) {
//            Vec3 movement = dashDirection.scale(DASH_SPEED_PER_TICK);
//            this.mob.setDeltaMovement(movement);
//            this.mob.hasImpulse = true; // потрібно щоб Minecraft правильно оновив рух
//
//            currentAttackTicks++;
//        } else {
//            finishDash();
//        }
//    }
//
//    // Завершити ривок і нанести удар
//    private void finishDash() {
//        this.isDashing = false;
//        this.mob.setDeltaMovement(Vec3.ZERO); // зупинити моба після ривка
//
//        // Завдати урону цілі якщо дуже близько
//        LivingEntity target = this.mob.getTarget();
//        if (target != null && this.mob.distanceTo(target) <= 1.5D) {
//            target.hurt(DamageSource.mobAttack(this.mob), WarriorPlusPlusEntity.AttackType.DashAttack.damage);
//            // Відкидання
//            Vec3 knockbackVec = new Vec3(
//                    target.getX() - this.mob.getX(),
//                    0.0,
//                    target.getZ() - this.mob.getZ()
//            ).normalize().scale(WarriorPlusPlusEntity.AttackType.DashAttack.knockback);
//            target.push(knockbackVec.x, 0.1, knockbackVec.z);
//        }//de
//    }
//
//    protected void resetAttackCooldown() {
//        this.ticksUntilNextAttack = this.adjustedTickDelay(20);
//    }
//
//    protected boolean isTimeToAttack() {
//        return this.ticksUntilNextAttack <= 0;
//    }
//
//    protected int getTicksUntilNextAttack() {
//        return this.ticksUntilNextAttack;
//    }
//
//    protected int getAttackInterval() {
//        return this.adjustedTickDelay(20);
//    }
//
//}
