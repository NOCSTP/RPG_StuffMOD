package net.nocst.rpg_stuff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nocst.rpg_stuff.RPGSTUFF;
import net.nocst.rpg_stuff.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RPGSTUFF.MODID, exFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.GEM_POLISHING_SATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("gem_polishing_station")));
    }



    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
