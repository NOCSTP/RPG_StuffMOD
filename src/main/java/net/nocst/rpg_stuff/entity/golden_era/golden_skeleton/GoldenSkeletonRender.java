package net.nocst.rpg_stuff.entity.golden_era.golden_skeleton;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.client.ModModelLayerss;

public class GoldenSkeletonRender extends MobRenderer<GoldenSkeletonEntity, GoldenSkeletonModel<GoldenSkeletonEntity>> {


    public GoldenSkeletonRender(EntityRendererProvider.Context pContext) {
        super(pContext, new GoldenSkeletonModel<>(pContext.bakeLayer(ModModelLayerss.GOLDEN_SKELETON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenSkeletonEntity pEntity) {
        return new ResourceLocation(RPGSTUFF.MODID, "textures/entity/golden_skeleton.png");
    }

    @Override
    public void render(GoldenSkeletonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()){
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

    }


}
