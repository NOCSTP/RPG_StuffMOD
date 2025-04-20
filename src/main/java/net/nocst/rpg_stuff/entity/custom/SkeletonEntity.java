package net.nocst.rpg_stuff.entity.custom;

import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SkeletonEntity extends Monster {
    public SkeletonEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes(){
                return Monster.createMonsterAttributes()
                        .add(Attributes.FOLLOW_RANGE, 35.0D)
                        .add(Attributes.MOVEMENT_SPEED, (double)0.23F)
                        .add(Attributes.ATTACK_DAMAGE, 3.0D)
                        .add(Attributes.ARMOR, 2.0D)
                        .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0.1D);
    }
    @Override
    protected void registerGoals(){
            this.goalSelector.addGoal(0, new FloatGoal(this));
            this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
            this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
            this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

            this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(ZombifiedPiglin.class));
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
            this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
        }
    }


