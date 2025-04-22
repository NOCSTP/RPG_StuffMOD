package net.nocst.rpg_stuff;

import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonRender;
import net.nocst.rpg_stuff.entity.golden_era.golden_warrior.GoldenWarriorEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_warrior.GoldenWarriorRender;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nocst.rpg_stuff.block.ModBlocks;
import net.nocst.rpg_stuff.entity.ModEntity;
import net.nocst.rpg_stuff.items.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RPGSTUFF.MODID)
public class RPGSTUFF {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "rpg_stuff";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public RPGSTUFF() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
//ModBlockEntities.register(modEventBus);
        ModEntity.register(modEventBus);

        // Register event handlers
        modEventBus.addListener(this::entityAttributeEvent);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.debug("debug mode is on");
    }

    private void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntity.GOLDEN_SKELETON.get(), GoldenSkeletonEntity.createAttributes().build());
        event.put(ModEntity.GOLDEN_WARRIOR.get(), GoldenWarriorEntity.createAttributes().build());
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            EntityRenderers.register(ModEntity.GOLDEN_SKELETON.get(), GoldenSkeletonRender::new);
            EntityRenderers.register(ModEntity.GOLDEN_WARRIOR.get(), GoldenWarriorRender::new);
        }
    }
}