package net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbPropertyGet;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonModel;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

// and then your renderer can pull in the right constructor
public class GoldenSkeletonRender<T extends HierarchicalModel<GoldenSkeletonEntity>> extends MobRenderer<GoldenSkeletonEntity, T>{
    private static GodlenSkeletonModelDefinder<GoldenSkeletonEntity, ? extends HierarchicalModel<GoldenSkeletonEntity>> SelectedModel;

    public static void setSelectedModel(GodlenSkeletonModelDefinder<GoldenSkeletonEntity, ? extends HierarchicalModel<GoldenSkeletonEntity>> selectedModel) {
        SelectedModel = selectedModel;
    }
    public static GodlenSkeletonModelDefinder<GoldenSkeletonEntity, ? extends HierarchicalModel<GoldenSkeletonEntity>> getSelectedModel() {
        return SelectedModel;
    }

    private static final List<GodlenSkeletonModelDefinder<GoldenSkeletonEntity, ? extends HierarchicalModel<GoldenSkeletonEntity>>> MODELS = List.of(
             GoldenSkeletonModels.GOLDEN_SKELETON_IDE,
             GoldenSkeletonModels.GOLDEN_SKELETON_MODEL_DAMAGED
    );



    private static HierarchicalModel<GoldenSkeletonEntity> getRandomModel(EntityRendererProvider.Context ctx) {
        Random random = new Random();
        GodlenSkeletonModelDefinder<GoldenSkeletonEntity, ? extends HierarchicalModel<GoldenSkeletonEntity>> definder =
                MODELS.get(random.nextInt(MODELS.size()));
        setSelectedModel(definder);
        RPGSTUFF.LOGGER.info("random!");
        return  definder.factory().apply(ctx);
    }

    public GoldenSkeletonRender(EntityRendererProvider.Context ctx) {
        super(
                ctx,
                (T)GoldenSkeletonModels.GOLDEN_SKELETON_IDE.factory().apply(ctx),
                0.5f

        );
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenSkeletonEntity e) {
        return new ResourceLocation(
                RPGSTUFF.MODID,

                "textures/entity/golden_skeleton/"+ GoldenSkeletonModels.GOLDEN_SKELETON_IDE.layerLocation().getModel().getPath() + ".png"


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
