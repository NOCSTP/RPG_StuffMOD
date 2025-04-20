package net.nocst.rpg_stuff.tier;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.nocst.rpg_stuff.items.ModItems;

import java.util.function.Supplier;

public enum ModTiers implements Tier {

    COMMON_TIER(
            0,    // Mining Level
            560,   // Durability
            2.0F, // Mining Speed
            3.0F, // Attack Damage Bonus
            5,   // Enchantability
            () -> {
                return Ingredient.of(ModItems.COMMON_MATERIAL.get()); // Repair Ingredient
            }),
    RARE_TIER(
            0,    // Mining Level
            1020,   // Durability
            4.0F, // Mining Speed
            7.0F, // Attack Damage Bonus
            9,   // Enchantability
            () -> {
                return Ingredient.of(ModItems.RARE_MATERIAL.get()); // Repair Ingredient
            }),
    EPIC_TIER(
            0,    // Mining Level
            1800,   // Durability
            6.0F, // Mining Speed
            8.0F, // Attack Damage Bonus
            22,   // Enchantability
            () -> {
                return Ingredient.of(ModItems.EPIC_MATERIAL.get()); // Repair Ingredient
            }),
    LEGENDARY_TIER(
            0,    // Mining Level
            2000,   // Durability
            8.0F, // Mining Speed
            7.0F, // Attack Damage Bonus
            15,   // Enchantability
            () -> {
                return Ingredient.of(ModItems.LEGENDARY_MATERIAL.get()); // Repair Ingredient
            });


    private final int level;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModTiers(int level, int uses, float speed, float attackDamageBonus, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
