package net.nocst.rpg_stuff.entity.golden_era.warrior_plus_plus;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class WarriorPlusAttackGoal extends MeleeAttackGoal {

    public WarriorPlusAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
    }
}
