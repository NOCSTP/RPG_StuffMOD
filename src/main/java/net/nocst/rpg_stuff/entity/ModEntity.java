package net.nocst.rpg_stuff.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton_damaged.GoldenSkeletonDamagedEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_warrior.GoldenWarriorEntity;

public class ModEntity {

public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
    DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RPGSTUFF.MODID);

    public static final RegistryObject<EntityType<GoldenSkeletonEntity>> GOLDEN_SKELETON_IDE =
            ENTITY_TYPES.register("golden_skeleton_ide", ()-> EntityType.Builder.of(GoldenSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f).build("golden_skeleton"));
    public static final RegistryObject<EntityType<GoldenSkeletonDamagedEntity>> GOLDEN_SKELETON_DAMAGED =
            ENTITY_TYPES.register("golden_skeleton_damaged", ()-> EntityType.Builder.of(GoldenSkeletonDamagedEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f).build("golden_skeleton_damaged"));
    public static final RegistryObject<EntityType<GoldenWarriorEntity>>GOLDEN_WARRIOR =
            ENTITY_TYPES.register("golden_warrior", ()-> EntityType.Builder.of(GoldenWarriorEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f).build("golden_warrior"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
