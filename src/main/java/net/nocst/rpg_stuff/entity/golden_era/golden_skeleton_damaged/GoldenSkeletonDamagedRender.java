package net.nocst.rpg_stuff.entity.golden_era.golden_skeleton_damaged;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.models.GoldenSkeletonlLayerss;

// and then your renderer can pull in the right constructor
public class GoldenSkeletonDamagedRender extends MobRenderer<GoldenSkeletonDamagedEntity, GoldenSkeletonDamagedModel<GoldenSkeletonDamagedEntity>> {
    public GoldenSkeletonDamagedRender(EntityRendererProvider.Context pContext) {
        super(pContext, new GoldenSkeletonDamagedModel<>(pContext.bakeLayer(GoldenSkeletonlLayerss.GOLDEN_SKELETON_LAYER_DAMAGED)), 0.6f);
    }


    @Override
    public ResourceLocation getTextureLocation(GoldenSkeletonDamagedEntity pEntity) {
        return new ResourceLocation(RPGSTUFF.MODID, "textures/entity/golden_skeleton/golden_skeleton_damaged.png");
    }

    @Override
    public void render(GoldenSkeletonDamagedEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

//        if(pEntity.isBaby()){
//            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
//        }else {
//            pMatrixStack.scale(1.25f, 1.25f, 1.25f);
//        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

    }
}
