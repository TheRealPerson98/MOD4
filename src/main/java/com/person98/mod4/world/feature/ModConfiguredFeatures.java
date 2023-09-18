package com.person98.mod4.world.feature;

import com.person98.mod4.Mod4;
import com.person98.mod4.block.ModBlocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> DOGWOOD_KEY = registerKey("dogwood");
    public static final RegistryKey<ConfiguredFeature<?,?>> DOGWOOD_SPAWN_KEY = registerKey("dogwood_spawn");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);


        register(context, DOGWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BROWN_DANCE_BLOCK),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.GREEN_DANCE_BLOCK.getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, DOGWOOD_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DOGWOOD_PLACED_KEY),
                        0.5f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DOGWOOD_PLACED_KEY)));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Mod4.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
