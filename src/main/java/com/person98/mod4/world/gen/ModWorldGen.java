package com.person98.mod4.world.gen;

import com.person98.mod4.Mod4;

public class ModWorldGen {
    public static void generateWorldGen() {
        Mod4.LOGGER.info("loaded ModWorldGen");
        ModTreeGeneration.generateTrees();
    }
}
