package net.nocst.rpg_stuff.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.client.ModModelLayerss;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton_damaged.GoldenSkeletonDamagedModel;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.models.GoldenSkeletonModelIde;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.models.GoldenSkeletonlLayerss;
import net.nocst.rpg_stuff.entity.golden_era.golden_warrior.GoldenWarriorModel;

@Mod.EventBusSubscriber(modid = RPGSTUFF.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GoldenSkeletonlLayerss.GOLDEN_SKELETON_LAYER_IDE, GoldenSkeletonModelIde::createBodyLayer);
        event.registerLayerDefinition(GoldenSkeletonlLayerss.GOLDEN_SKELETON_LAYER_DAMAGED, GoldenSkeletonDamagedModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerss.GOLDEN_WARRIOR_LAYER, GoldenWarriorModel::createBodyLayer);

    }

}
