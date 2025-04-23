package net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.models;

import net.nocst.rpg_stuff.entity.client.ModModelLayerss;
import net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.GoldenSkeletonEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_warrior.GoldenWarriorEntity;
import net.nocst.rpg_stuff.entity.golden_era.golden_warrior.GoldenWarriorModel;

// somewhere central (e.g. ModModels.java)
public class GoldenSkeletonModels {
    public static final GodlenSkeletonModelDefinder<GoldenSkeletonEntity, GoldenSkeletonModelIde<GoldenSkeletonEntity>>
            GOLDEN_SKELETON_IDE =
            new GodlenSkeletonModelDefinder<>(
                    GoldenSkeletonlLayerss.GOLDEN_SKELETON_LAYER_IDE,            // your layer ID
                    ctx -> new GoldenSkeletonModelIde<>(                  // constructor factory
                            ctx.bakeLayer(GoldenSkeletonlLayerss.GOLDEN_SKELETON_LAYER_IDE)
                    )
            );
    public static final GodlenSkeletonModelDefinder<GoldenSkeletonEntity, GoldenSkeletonModelDamaged<GoldenSkeletonEntity>>
            GOLDEN_SKELETON_MODEL_DAMAGED =
            new GodlenSkeletonModelDefinder<>(
                    GoldenSkeletonlLayerss.GOLDEN_SKELETON_LAYER_DAMAGED,
                    ctx-> new GoldenSkeletonModelDamaged<>(
                            ctx.bakeLayer(GoldenSkeletonlLayerss.GOLDEN_SKELETON_LAYER_DAMAGED)
                    )
            );

    public static final GodlenSkeletonModelDefinder<GoldenWarriorEntity, GoldenWarriorModel<GoldenWarriorEntity>>
            GOLDEN_WARRIOR =
            new GodlenSkeletonModelDefinder<>(
                    ModModelLayerss.GOLDEN_WARRIOR_LAYER,
                    ctx -> new GoldenWarriorModel<>(
                            ctx.bakeLayer(ModModelLayerss.GOLDEN_WARRIOR_LAYER)
                    )
            );
}
