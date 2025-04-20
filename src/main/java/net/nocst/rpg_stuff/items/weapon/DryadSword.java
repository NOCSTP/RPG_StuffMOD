package net.nocst.rpg_stuff.items.weapon;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.minecraft.network.chat.Component; // потрібно для імені

public class DryadSword extends SwordItem {

    public DryadSword() {
        super(Tiers.DIAMOND, 3, 4.5F, new Item.Properties().durability(1561)); // durability важливо
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        boolean result = super.hurtEnemy(pStack, pTarget, pAttacker); // базовий удар

        if (!pTarget.level().isClientSide) {
            String targetName = pTarget.getName().getString(); // отримати ім'я моба
            RPGSTUFF.LOGGER.info("Hit entity: " + targetName); // вивести в консоль

            pTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 1)); // дати отруєння
//            pTarget.killedEntity(pTarget);
        }
        return result;
    }
}
