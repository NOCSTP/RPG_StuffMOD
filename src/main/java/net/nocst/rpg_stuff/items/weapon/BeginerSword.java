package net.nocst.rpg_stuff.items.weapon;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class BeginerSword extends SwordItem {
    public BeginerSword() {
        super(Tiers.WOOD, 1, 0.4F, new Properties());
    }
}
