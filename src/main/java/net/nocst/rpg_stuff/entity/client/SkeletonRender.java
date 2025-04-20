package net.nocst.rpg_stuff.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.custom.SkeletonEntity;

public class SkeletonRender extends MobRenderer<SkeletonEntity, SkeletonModel<SkeletonEntity>> {
    public SkeletonRender(EntityRendererProvider.Context pContext) {
        super(pContext, new SkeletonModel<>(pContext.bakeLayer(ModModelLayerss.SKELETON_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(SkeletonEntity pEntity) {
        return new ResourceLocation(RPGSTUFF.MODID, "textures/entity/skeleton.png");
    }

    @Override
    public void render(SkeletonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()){
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
