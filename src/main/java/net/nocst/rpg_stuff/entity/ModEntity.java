package net.nocst.rpg_stuff.entity;

import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.custom.SkeletonEntity;

import javax.swing.text.html.parser.Entity;

public class ModEntity {

public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
    DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RPGSTUFF.MODID);

    public static final RegistryObject<EntityType<SkeletonEntity>> SKELETON =
            ENTITY_TYPES.register("skeleton", ()-> EntityType.Builder.of(SkeletonEntity::new, MobCategory.MONSTER)
                    .sized(12.5f, 2.5f).build("skeleton"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
