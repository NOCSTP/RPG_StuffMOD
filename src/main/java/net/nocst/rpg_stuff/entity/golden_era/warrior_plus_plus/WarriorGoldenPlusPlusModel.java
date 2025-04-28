package net.nocst.rpg_stuff.entity.golden_era.warrior_plus_plus;// Made with Blockbench 4.12.4
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

import javax.swing.text.html.parser.Entity;

public class WarriorGoldenPlusPlusModel<T extends Entity> extends HierarchicalModel<WarriorPlusPlusEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "warriornetheritgolden"), "main");
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart cubeArmor;
	private final ModelPart leftHorn;
	private final ModelPart rightHorn;
	private final ModelPart body;
	private final ModelPart chizz;
	private final ModelPart coat;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public WarriorGoldenPlusPlusModel(ModelPart root) {
		this.main = root.getChild("main");
		this.head = this.main.getChild("head");
		this.cubeArmor = this.head.getChild("cubeArmor");
		this.leftHorn = this.head.getChild("leftHorn");
		this.rightHorn = this.head.getChild("rightHorn");
		this.body = this.main.getChild("body");
		this.chizz = this.body.getChild("chizz");
		this.coat = this.body.getChild("coat");
		this.rightArm = this.main.getChild("rightArm");
		this.leftArm = this.main.getChild("leftArm");
		this.rightLeg = this.main.getChild("rightLeg");
		this.leftLeg = this.main.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition cubeArmor = head.addOrReplaceChild("cubeArmor", CubeListBuilder.create().texOffs(80, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, -1.42F, 0.0F));

		PartDefinition leftHorn = head.addOrReplaceChild("leftHorn", CubeListBuilder.create().texOffs(48, 12).addBox(-0.2F, -5.0F, 1.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(4.6F, -8.0F, -2.3F, 0.0F, -0.384F, 0.0F));

		PartDefinition rightHorn = head.addOrReplaceChild("rightHorn", CubeListBuilder.create().texOffs(16, 48).addBox(-9.8F, -5.0F, 1.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-4.6F, -8.0F, -2.3F, 0.0F, 0.384F, 0.0F));

		PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition chizz = body.addOrReplaceChild("chizz", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition cube_r1 = chizz.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 28).mirror().addBox(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2F, -2.0F, -3.0F, -0.384F, -0.6283F, 0.0F));

		PartDefinition cube_r2 = chizz.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 28).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 4.0F, -2.4F, 0.3602F, 0.7269F, 0.0456F));

		PartDefinition cube_r3 = chizz.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 28).mirror().addBox(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8F, 4.0F, -2.4F, 0.3602F, -0.7269F, -0.0456F));

		PartDefinition cube_r4 = chizz.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 25).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, 1.0F, -3.0F, 0.0F, 0.6283F, 0.0F));

		PartDefinition cube_r5 = chizz.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 22).addBox(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, 1.0F, -3.0F, 0.0F, -0.6283F, 0.0F));

		PartDefinition cube_r6 = chizz.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 28).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, -2.0F, -3.0F, -0.384F, 0.6283F, 0.0F));

		PartDefinition coat = body.addOrReplaceChild("coat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition cube_r7 = coat.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8F, 1.4F, 0.1745F, 0.0F, 0.0F));

		PartDefinition rightArm = main.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(32, 12).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).mirror().addBox(-4.0F, -3.1F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -22.0F, 0.0F));

		PartDefinition leftArm = main.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -3.1F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition rightLeg = main.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(40, 28).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));

		PartDefinition leftLeg = main.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(40, 44).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return main;
	}

	@Override
	public void setupAnim(WarriorPlusPlusEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(pNetHeadYaw, pHeadPitch, pAgeInTicks);
        this.animate(WarriorPlusPlusEntity.attackingLegAttackState, WarriorGoldenPlusAnimationsDefinitions.HIT_LEG, 2f);
		this.animate(WarriorPlusPlusEntity.attackingArmAttackState, WarriorGoldenPlusAnimationsDefinitions.HIT_ARM, 2f);
		this.animate(WarriorPlusPlusEntity.attackingDashAttackState, WarriorGoldenPlusAnimationsDefinitions.DASH, 2f);
	}
}