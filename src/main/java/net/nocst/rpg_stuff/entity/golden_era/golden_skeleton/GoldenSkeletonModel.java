package net.nocst.rpg_stuff.entity.golden_era.golden_skeleton;// Made with Blockbench 4.12.4
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
import net.nocst.rpg_stuff.RPGSTUFF;

public class GoldenSkeletonModel<T extends GoldenSkeletonEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(RPGSTUFF.MODID, "golden_skeleton"), "main");
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart waist;
	private final ModelPart waistBack;
	private final ModelPart Body;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart leftItem;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public GoldenSkeletonModel(ModelPart root) {
		this.main = root.getChild("main");
		this.head = this.main.getChild("head");
		this.waist = this.main.getChild("waist");
		this.waistBack = this.waist.getChild("waistBack");
		this.Body = this.waistBack.getChild("Body");
		this.rightArm = this.main.getChild("rightArm");
		this.leftArm = this.main.getChild("leftArm");
		this.leftItem = this.leftArm.getChild("leftItem");
		this.rightLeg = this.main.getChild("rightLeg");
		this.leftLeg = this.main.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition waist = main.addOrReplaceChild("waist", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition waistBack = waist.addOrReplaceChild("waistBack", CubeListBuilder.create().texOffs(36, 21).addBox(-1.0F, -14.0F, 2.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 57).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition cube_r1 = waistBack.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 37).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(36, 37).addBox(-2.0F, -5.0F, -1.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(36, 36).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, -9.0F, 3.7F, 0.0F, -0.3054F, 0.0F));

		PartDefinition cube_r2 = waistBack.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 34).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(36, 34).addBox(-1.0F, 1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(36, 34).addBox(-1.0F, 3.0F, -1.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, -13.0F, 3.7F, 0.0F, 0.3054F, 0.0F));

		PartDefinition cube_r3 = waistBack.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(36, 14).addBox(-3.0F, -9.0F, 1.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, 2.8F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r4 = waistBack.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(36, 32).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8F, 3.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition Body = waistBack.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 0.0F));

		PartDefinition rightArm = main.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -22.0F, 0.0F));

		PartDefinition leftArm = main.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(8, 32).addBox(-1.0F, -2.1F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition leftItem = leftArm.addOrReplaceChild("leftItem", CubeListBuilder.create(), PartPose.offset(1.0F, 7.0F, 1.0F));

		PartDefinition rightLeg = main.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 16).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leftLeg = main.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(24, 31).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(32, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}




	@Override
	public ModelPart root() {
		return main;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(pNetHeadYaw, pHeadPitch, pAgeInTicks);
		GoldenSkeletonEntity goldenSkeleton = ((GoldenSkeletonEntity) pEntity);

		if (goldenSkeleton.isHurtAnimation()){
			this.animate(goldenSkeleton.hurtAnimationState, GoldenSkeletonAnimationsDefinitions.HITING, pAgeInTicks);
		} else {
			this.animateWalk(GoldenSkeletonAnimationsDefinitions.WALKINGBADIDLE, pLimbSwing, pLimbSwingAmount, 2f, 2.5f);
			this.animate(goldenSkeleton.idleAnimationsState, GoldenSkeletonAnimationsDefinitions.STAYSEC, pAgeInTicks, 2f);
			this.animate(goldenSkeleton.attackAnimationState, GoldenSkeletonAnimationsDefinitions.HIT, pAgeInTicks, 2f);
		}

	}



	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

}