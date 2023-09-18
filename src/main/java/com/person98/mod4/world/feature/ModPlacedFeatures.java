package com.person98.mod4.world.feature;

import com.person98.mod4.Mod4;
import com.person98.mod4.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> DOGWOOD_CHECKED_KEY = registerKey("dogwood_checked");
    public static final RegistryKey<PlacedFeature> DOGWOOD_PLACED_KEY = registerKey("dogwood_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, DOGWOOD_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DOGWOOD_KEY),
                List.of(PlacedFeatures.wouldSurvive(ModBlocks.DOGWOOD_SAPLING)));
        // Use the modifiers method from ModPlacedFeatures which can handle PlacementModifier
        register(context, DOGWOOD_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DOGWOOD_KEY),
                dogwoodPlacedModifiers());


    }
    private static List<PlacementModifier> dogwoodPlacedModifiers() {
        return List.of(
                PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), // This might be an approximation of the weighted count
                SquarePlacementModifier.of(),
                SurfaceWaterDepthFilterPlacementModifier.of(0),  // You might need to create this method or class
                HeightmapPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR),
                BiomePlacementModifier.of()  // If more configurations for the biome are needed, you should adjust this
        );
    }
    private static List<PlacementModifier> getModifiersFromVegetation(PlacementModifier modifier) {
        return List.of(modifier);
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Mod4.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
}
