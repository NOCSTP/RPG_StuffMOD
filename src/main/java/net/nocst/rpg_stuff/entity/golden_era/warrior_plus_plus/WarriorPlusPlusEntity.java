    package net.nocst.rpg_stuff.entity.golden_era.warrior_plus_plus;

    import net.minecraft.network.syncher.EntityDataAccessor;
    import net.minecraft.network.syncher.EntityDataSerializers;
    import net.minecraft.network.syncher.SynchedEntityData;
    import net.minecraft.world.entity.AnimationState;
    import net.minecraft.world.entity.EntityType;
    import net.minecraft.world.entity.monster.Monster;
    import net.minecraft.world.level.Level;
    import net.nocst.rpg_stuff.entity.basic.BasicEntity;

    import java.util.function.Consumer;

    public class WarriorPlusPlusEntity extends BasicEntity {



        public enum AttackType{
            LegAttack(3, 6.0, 10, 5, false, WarriorPlusPlusEntity::startLegAttack),
            ArmAttack(6, 1.0, 15, 10, false, WarriorPlusPlusEntity::startArmAttack),
            DashAttack(12, 0.5, 25, 20, true, WarriorPlusPlusEntity::startDashAttack)
            ;

            public final int damage;
            public final double knockback;
            public final int animationLenghtTicks;
            public final int tickTillAttackType;
            public final boolean doesDash;
            private final Consumer<WarriorPlusPlusEntity> runAnimation;

            AttackType(int damage, double knockback, int animationLenghtTicks, int tickTillAttackType, boolean deasDash, Consumer<WarriorPlusPlusEntity> runAnimation) {
                this.damage = damage;
                this.knockback = knockback;
                this.animationLenghtTicks = animationLenghtTicks;
                this.tickTillAttackType = tickTillAttackType;
                this.doesDash = deasDash;
                this.runAnimation = runAnimation;
            }

            public void runAnimation(WarriorPlusPlusEntity entity){
                this.runAnimation.accept(entity);
            }
        }

        public static final EntityDataAccessor<Boolean> LEG_ATTACKING =
                SynchedEntityData.defineId(WarriorPlusPlusEntity.class, EntityDataSerializers.BOOLEAN);
        public static final EntityDataAccessor<Boolean> ARM_ATTACKING =
                SynchedEntityData.defineId(WarriorPlusPlusEntity.class, EntityDataSerializers.BOOLEAN);
        public static final EntityDataAccessor<Boolean> DASH_ATTACKING =
                SynchedEntityData.defineId(WarriorPlusPlusEntity.class, EntityDataSerializers.BOOLEAN);

        public static AnimationState attackingLegAttackState = new AnimationState();
        public static AnimationState attackingArmAttackState = new AnimationState();
        public static AnimationState attackingDashAttackState = new AnimationState();

        private int attackAnimationTimeout = 0;


        public void setLegAttackState(boolean attacking){this.entityData.set(LEG_ATTACKING, attacking);}
        public void setArmAttackState(boolean attacking){this.entityData.set(ARM_ATTACKING, attacking);}
        public void setDashAttackState(boolean attacking){this.entityData.set(DASH_ATTACKING, attacking);}

        public void startLegAttack(){
            this.setLegAttackState(true);
            attackingLegAttackState.start(AttackType.LegAttack.animationLenghtTicks);
            this.attackAnimationTimeout = AttackType.LegAttack.animationLenghtTicks;
        }
        public void startArmAttack(){
            this.setLegAttackState(true);
            attackingArmAttackState.start(AttackType.ArmAttack.animationLenghtTicks);
            this.attackAnimationTimeout = AttackType.ArmAttack.animationLenghtTicks;
        }
        public void startDashAttack(){
            this.setLegAttackState(true);
            attackingDashAttackState.start(AttackType.DashAttack.animationLenghtTicks);
            this.attackAnimationTimeout = AttackType.DashAttack.animationLenghtTicks;
        }

        public boolean isAttacking(){
            if(this.entityData.get(LEG_ATTACKING) && this.entityData.get(ARM_ATTACKING) && this.entityData.get(DASH_ATTACKING)){
                return true;
            } else {return false;}
        }

        public void setupAnimationStates(){
            if (!this.isAttacking() && attackAnimationTimeout <= 0) {
                attackingLegAttackState.stop();
                attackingArmAttackState.stop();
                attackingDashAttackState.stop();
                setLegAttackState(false);
                setArmAttackState(false);
                setDashAttackState(false);
            } else {
                attackAnimationTimeout--;
            }
        }

        @Override
        public void tick() {
            super.tick();
            if (this.level().isClientSide()) {
                this.setupAnimationStates();
            }
        }

        public WarriorPlusPlusEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
            super(pEntityType, pLevel);
        }
    }
