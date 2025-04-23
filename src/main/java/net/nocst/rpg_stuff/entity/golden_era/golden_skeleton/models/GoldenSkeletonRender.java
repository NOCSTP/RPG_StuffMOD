package net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.models;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonModel;

// and then your renderer can pull in the right constructor
public class GoldenSkeletonRender extends MobRenderer<GoldenSkeletonEntity, GoldenSkeletonModelIde<GoldenSkeletonEntity>>
{
    public GoldenSkeletonRender(EntityRendererProvider.Context ctx) {
        super(
                ctx,
                GoldenSkeletonModels.GOLDEN_SKELETON_IDE.factory().apply(ctx),
                0.5f
        );
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenSkeletonEntity e) {
        return new ResourceLocation(
                RPGSTUFF.MODID,
                "textures/entity/golden_skeleton/golden_skeleton_idle.png"
        );
    }

    @Override
    public void render(GoldenSkeletonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()){
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

    }
}
