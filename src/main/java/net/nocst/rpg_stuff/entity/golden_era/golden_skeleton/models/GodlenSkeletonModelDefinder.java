package net.nocst.rpg_stuff.entity.golden_era.golden_skeleton.models;

import java.util.function.Function;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

// a little generic holder for one of your models
public class GodlenSkeletonModelDefinder<E, M> {
    private final ModelLayerLocation layerLoc;
    private final Function<EntityRendererProvider.Context, M> constructor;

    public GodlenSkeletonModelDefinder(ModelLayerLocation layerLoc,
                                       Function<EntityRendererProvider.Context, M> constructor)
    {
        this.layerLoc     = layerLoc;
        this.constructor  = constructor;
    }

    public ModelLayerLocation layerLocation()       { return layerLoc; }
    public Function<EntityRendererProvider.Context, M> factory() { return constructor; }
}
