package net.nocst.rpg_stuff.entity.skelets.golden_skeleton;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.nocst.rpg_stuff.items.ModItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

public class GoldenSkeletonEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(GoldenSkeletonEntity.class, EntityDataSerializers.BOOLEAN);

    final AnimationState attackAnimationState = new AnimationState();
    private int attackaimationsTimeout = 0;
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
//        if(this.idleAnimationsTimeout <= 0){
//            this.idleAnimationsTimeout = this.random.nextInt(40)+80;
//            this.idleAnimationsState.start(this.tickCount);
//        } else {
//            --this.idleAnimationsTimeout;
//        }
        if(!this.isMoving()){
            if(this.idleAnimationsTimeout <= 0){
                this.idleAnimationsTimeout = this.random.nextInt(40)+ 80;
                this.idleAnimationsState.start(this.tickCount);
            } else {
                --this.idleAnimationsTimeout;
            }
        }
        if (this.isAttacking() && attackaimationsTimeout<= 0){
           attackaimationsTimeout= 10;
           attackAnimationState.start(this.tickCount);
        } else {
            --this.attackaimationsTimeout;
        }
        if (!this.isAttacking()){
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
