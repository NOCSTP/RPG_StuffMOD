package net.nocst.rpg_stuff.entity.golden_era.golden_warrior;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.client.ModModelLayerss;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonModel;

public class GoldenWarriorRender extends MobRenderer<GoldenWarriorEntity, GoldenWarriorModel<GoldenWarriorEntity>> {
    public GoldenWarriorRender(EntityRendererProvider.Context pContext) {
        super(pContext, new GoldenWarriorModel<>(pContext.bakeLayer(ModModelLayerss.GOLDEN_WARRIOR_LAYER)), 0.6f);
    }


    @Override
    public ResourceLocation getTextureLocation(GoldenWarriorEntity pEntity) {
        return new ResourceLocation(RPGSTUFF.MODID, "textures/entity/golden_warrior.png");
    }

    @Override
    public void render(GoldenWarriorEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

//        if(pEntity.isBaby()){
//            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
//        }else {
//            pMatrixStack.scale(1.25f, 1.25f, 1.25f);
//        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

    }
}
