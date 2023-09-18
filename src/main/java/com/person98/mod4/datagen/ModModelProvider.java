package com.person98.mod4.datagen;

import com.person98.mod4.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAY_DANCE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREEN_DANCE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WHITE_DANCE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROWN_DANCE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_DANCE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_DANCE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOGWOOD_SAPLING);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    }
}