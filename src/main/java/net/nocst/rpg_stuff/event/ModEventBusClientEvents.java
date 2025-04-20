package net.nocst.rpg_stuff.event;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.client.ModModelLayerss;
import net.nocst.rpg_stuff.entity.client.SkeletonModel;

@Mod.EventBusSubscriber(modid = RPGSTUFF.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayerss.SKELETON_LAYER, SkeletonModel::createBodyLayer);

    }

}
