package net.nocst.rpg_stuff.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.skeleton.SkeletonEntity;
import net.nocst.rpg_stuff.entity.skelets.golden_skeleton.GoldenSkeletonEntity;

public class ModEntity {

public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
    DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RPGSTUFF.MODID);

    public static final RegistryObject<EntityType<SkeletonEntity>> SKELETON =
            ENTITY_TYPES.register("skeleton", ()-> EntityType.Builder.of(SkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f).build("skeleton"));
    public static final RegistryObject<EntityType<GoldenSkeletonEntity>> GOLDEN_SKELETON =
            ENTITY_TYPES.register("godlen_skeleton", ()-> EntityType.Builder.of(GoldenSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f).build("golden_skeleton"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
