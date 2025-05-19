//package net.nocst.rpg_stuff.block.custom.entity;
//
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//import net.nocst.rpg_stuff.RPGSTUFF;
//import net.nocst.rpg_stuff.block.ModBlocks;
//
//public class ModBlocksEntities {
//    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
//            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RPGSTUFF.MODID);
//
//    public static final RegistryObject<BlockEntityType<GemPolishingStationBlockEntity>> GEM_POLISHING_BE =
//            BLOCK_ENTITIES.register("gem_polishing_be", ()->
//                    BlockEntityType.Builder.of(GemPolishingStationBlockEntity::new,
//                            ModBlocks.GEM_POLISHING_SATION.get()).build(null));
//
//    public static void register(IEventBus eventBus){
//        BLOCK_ENTITIES.register(eventBus);
//    }
//}
