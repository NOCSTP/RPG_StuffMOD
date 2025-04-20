package net.nocst.rpg_stuff.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.common.Mod;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.client.ModModelLayerss;
import net.nocst.rpg_stuff.entity.client.SkeletonModel;
import net.nocst.rpg_stuff.entity.custom.SkeletonEntity;

@Mod.EventBusSubscriber(modid = RPGSTUFF.MODID, bus =  Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayerss.SKELETON_LAYER, SkeletonModel::createBodyLayer);
    }

}
