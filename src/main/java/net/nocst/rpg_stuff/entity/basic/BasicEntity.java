package net.nocst.rpg_stuff.entity.basic;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
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
import net.nocst.rpg_stuff.RPGSTUFF;

import javax.annotation.Nullable;

public class BasicEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(BasicEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_HURTING =
            SynchedEntityData.defineId(BasicEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout = 0;
    public BasicEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public final AnimationState idleAnimationsState = new AnimationState();
    private int idleAnimationsTimeout = 0;
    public final AnimationState hurtAnimationState = new AnimationState();
    private int hurtAnimationTimeout = 0;
    private boolean isHurt = false;
    private int hurtTicksLeft;


    @Override
    public void tick(){
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        } else {
            if (this.isHurtAnimation()) {
                if (--hurtTicksLeft <= 0) {
                    this.setHurtAnimation(false);
                }
            }
        }
    }


    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        SpawnGroupData data = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
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
        if (!this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationState.stop();
        }

        if (this.isHurtAnimation()) {
            if (!hurtAnimationState.isStarted()) {
                RPGSTUFF.LOGGER.info("CLIENT: hurt animation is RUNNING");
                hurtAnimationState.start(this.tickCount);
            }
        } else {
            if (hurtAnimationState.isStarted()) {
                hurtAnimationState.stop();
            }
        }


    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);

        if (result) {
            this.setHurtAnimation(true);
            this.hurtTicksLeft = 10; // тримаємо прапорець 10 тік
        }

        return result;
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

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    public boolean isHurtAnimation() {
        return this.entityData.get(IS_HURTING);
    }

    public void setHurtAnimation(boolean hurt) {
        this.entityData.set(IS_HURTING, hurt);
    }
    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(IS_HURTING, false);
    }


}
