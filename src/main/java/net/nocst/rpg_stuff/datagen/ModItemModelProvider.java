package net.nocst.rpg_stuff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.items.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RPGSTUFF.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        simpleItem(ModItems.SAPPHIRE);
//        simpleItem(ModItems.RAW_SAPPHIRE);
//
//        simpleItem(ModItems.METAL_DETECTOR);
//        simpleItem(ModItems.PINE_CONE);
//        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.KEY);

        materialItem(ModItems.COMMON_MATERIAL);

        //sword
        handheldItem(ModItems.BBEGINER_SWORD);
        handheldItem(ModItems.HOLY_SWORD);
        handheldItem(ModItems.VAMPIRE_BLADES);
        handheldItem(ModItems.ANCIENT_SWORD);
        handheldItem(ModItems.BERSERK_SWORD);
        handheldItem(ModItems.D_ANCIENT_SWORD);
        handheldItem(ModItems.DIAMOND_SWORD);
        handheldItem(ModItems.DRYAD_SWORD);
        handheldItem(ModItems.GOLDEN_SWORD);
        handheldItem(ModItems.GUARDIAN_SWORD);
        handheldItem(ModItems.HEAVY_IRON_SWORD);
        handheldItem(ModItems.IRON_SWORD);
        handheldItem(ModItems.KATANA);
        handheldItem(ModItems.LEGENDARY_SWORD);
        handheldItem(ModItems.MASTER_SWORD);
        handheldItem(ModItems.MOSSY_SWORD);
        handheldItem(ModItems.OLD_SWORD);
        handheldItem(ModItems.STALIN_SWORD);
        handheldItem(ModItems.STEEL_SWORD);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RPGSTUFF.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder materialItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RPGSTUFF.MODID,"item/material/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld"))
                .texture("layer0", new ResourceLocation(RPGSTUFF.MODID, "item/swords/" + item.getId().getPath()));
    }


//    private void handheldItem(Item item) {
//        String name = item.getRegistryName().getPath();
//        getBuilder(name)
//                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
//                .texture("layer0", new ResourceLocation(RPGSTUFF.MODID, "item/" + name));
//    }

}
