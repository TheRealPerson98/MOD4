package com.person98.mod4;

import com.person98.mod4.block.ModBlocks;
import com.person98.mod4.util.ModItemGroups;
import com.person98.mod4.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Mod4 implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("mod4");
	public static final String MOD_ID = "mod4";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Mod4...");

		ModItemGroups.registerItemGroups();
		LOGGER.info("Registered item groups.");

		ModBlocks.registerModBlocks();
		LOGGER.info("Registered mod blocks.");

		ModWorldGen.generateWorldGen();
		LOGGER.info("Initialized world generation.");

		LOGGER.info("Hello Fabric world!");



	}
}