package com.person98.mod4.block;

import com.person98.mod4.Mod4;
import com.person98.mod4.world.feature.tree.DogwoodSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RED_DANCE_BLOCK = registerBlock("red_dance_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block BLUE_DANCE_BLOCK = registerBlock("blue_dance_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block WHITE_DANCE_BLOCK = registerBlock("white_dance_block",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)));
    public static final Block GREEN_DANCE_BLOCK = registerBlock("green_dance_block",
            new SaplingBlock(new DogwoodSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block BROWN_DANCE_BLOCK = registerBlock("brown_dance_block",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(1.5f)));
    public static final Block GRAY_DANCE_BLOCK = registerBlock("gray_dance_block",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f), UniformIntProvider.create(4, 7)));
    public static final Block DOGWOOD_SAPLING = registerBlock("green_dance_block_sapling",
            new SaplingBlock(new DogwoodSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Mod4.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Mod4.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Mod4.LOGGER.info("Registering ModBlocks for " + Mod4.MOD_ID);
    }
}