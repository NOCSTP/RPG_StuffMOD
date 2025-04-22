package net.nocst.rpg_stuff.entity.skeleton;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.entity.animations.ModAnimationsDefinitions;
import net.nocst.rpg_stuff.entity.skeleton.SkeletonEntity;

public class SkeletonModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(RPGSTUFF.MODID, "skeleton"), "main");
	private final ModelPart main;
	private final ModelPart arm_r;
	private final ModelPart arm_l;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rib_2;
	private final ModelPart rib_5;
	private final ModelPart rib_3;
	private final ModelPart bottom;
	private final ModelPart rib_4;
	private final ModelPart leg_r;
	private final ModelPart leg_l;

	public SkeletonModel(ModelPart root) {
		this.main = root.getChild("main");
		this.arm_r = this.main.getChild("arm_r");
		this.arm_l = this.main.getChild("arm_l");
		this.head = this.main.getChild("head");
		this.body = this.main.getChild("body");
		this.rib_2 = this.body.getChild("rib_2");
		this.rib_5 = this.body.getChild("rib_5");
		this.rib_3 = this.body.getChild("rib_3");
		this.bottom = this.main.getChild("bottom");
		this.rib_4 = this.bottom.getChild("rib_4");
		this.leg_r = this.bottom.getChild("leg_r");
		this.leg_l = this.bottom.getChild("leg_l");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition arm_r = main.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(32, 2).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -18.0F, -3.0F));

		PartDefinition bottom_r1 = arm_r.addOrReplaceChild("bottom_r1", CubeListBuilder.create().texOffs(22, 32).addBox(0.0F, -2.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 7.0F, -1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition arm_l = main.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(26, 32).addBox(0.0F, -1.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -17.0F, 5.0F));

		PartDefinition bottom_r2 = arm_l.addOrReplaceChild("bottom_r2", CubeListBuilder.create().texOffs(30, 32).addBox(0.0F, -2.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(3.0F, -17.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0981F, -3.634F, 2.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 16).addBox(5.0F, -19.0F, 0.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition body_top_r1 = body.addOrReplaceChild("body_top_r1", CubeListBuilder.create().texOffs(16, 30).addBox(2.0F, -7.0F, 0.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -7.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition rib_2 = body.addOrReplaceChild("rib_2", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(22, 30).addBox(-4.0F, -1.0F, 2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 16).addBox(-5.0F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 19).addBox(-5.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -14.0F, 1.0F));

		PartDefinition rib_5 = body.addOrReplaceChild("rib_5", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(28, 26).addBox(-4.0F, -1.0F, 3.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 28).addBox(-4.0F, -1.0F, -4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 35).addBox(-4.0F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(36, 2).addBox(-4.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -16.0F, 1.0F));

		PartDefinition rib_3 = body.addOrReplaceChild("rib_3", CubeListBuilder.create().texOffs(14, 16).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(32, 14).addBox(-3.0F, -1.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 30).addBox(-3.0F, -1.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 22).addBox(-4.0F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 32).addBox(-4.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -12.0F, 1.0F));

		PartDefinition bottom = main.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition rib_4 = bottom.addOrReplaceChild("rib_4", CubeListBuilder.create().texOffs(14, 23).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(32, 10).addBox(-4.0F, -1.0F, 2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 12).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 5).addBox(-5.0F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 37).addBox(-5.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -8.0F, 0.0F));

		PartDefinition leg_r = bottom.addOrReplaceChild("leg_r", CubeListBuilder.create(), PartPose.offset(1.0F, -8.0F, 2.0F));

		PartDefinition cube_r2 = leg_r.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(4, 30).addBox(0.0F, -2.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 9.0F, 1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r3 = leg_r.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, -3.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition leg_l = bottom.addOrReplaceChild("leg_l", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, -3.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r4 = leg_l.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 30).addBox(0.0F, -2.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 9.0F, 1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r5 = leg_l.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 30).addBox(0.0F, -3.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.3927F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationsDefinitions.SKELETON_IDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((SkeletonEntity) entity).idleAnimationsState, ModAnimationsDefinitions.SKELETON_IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return main;
	}
}