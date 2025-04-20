//package net.nocst.rpg_stuff.block;
//
//import net.minecraft.world.level.block.EntityBlock;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//import net.nocst.rpg_stuff.RPGSTUFF;
//import net.nocst.rpg_stuff.block.entity.ModPortalBlockEntity;
//
//public class ModBlockEntities {
//    public static final DeferredRegister<BlockEntityType<?>>BLOCK_ENTITY =
//            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RPGSTUFF.MODID);
//
//    public static final RegistryObject<BlockEntityType<ModPortalBlockEntity>> MOD_PORTAL_BLOCK_ENTITY =
//            BLOCK_ENTITY.register("mod_portal_block_entity",
//                    () -> BlockEntityType.Builder.of(ModPortalBlockEntity::new, ModBlocks.MOD_PORTAL.get()).build(null));
//
//    public static void register(IEventBus eventBus){
//        BLOCK_ENTITY.register(eventBus);
//    }
//}
