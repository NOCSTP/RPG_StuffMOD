package net.nocst.rpg_stuff.entity.skelets.golden_skeleton;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class GoldenSkeletonEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(GoldenSkeletonEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout = 0;
    public GoldenSkeletonEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationsState = new AnimationState();
    private int idleAnimationsTimeout = 0;

    @Override
    public void tick(){
        super.tick();

        if(this.level().isClientSide()){
            this.setupAnimationStates();
        }
    }


    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        SpawnGroupData data = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_AXE));
        return data;
    }

    private void setupAnimationStates(){
        if(!this.isMoving()){
            if(this.idleAnimationsTimeout <= 0){
                this.idleAnimationsTimeout = this.random.nextInt(240)+ 80;
                this.idleAnimationsState.start(this.tickCount);
            } else {
                --this.idleAnimationsTimeout;
            }
        }
        
        if (this.isAttacking() && attackAnimationTimeout <= 0){
           attackAnimationTimeout = 20; // Longer timeout to ensure animation completes
           attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }
        
        // Only stop the animation when it's complete, not immediately when not attacking
        if (!this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationState.stop();
        }
    }
    
    @Override
    protected void updateWalkAnimation(float pPartialTick){
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    public boolean isMoving() {
        return this.getDeltaMovement().horizontalDistanceSqr() > 0.001;
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.3F)
                .add(Attributes.ATTACK_DAMAGE, 1.5D)
                .add(Attributes.ARMOR, 2.0D)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0.1D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new GoldenSkeletonAttackGoal(this, 1.0D, true));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, TamableAnimal.class, true));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }
}
