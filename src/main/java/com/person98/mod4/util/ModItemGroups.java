package com.person98.mod4.util;

import com.person98.mod4.Mod4;
import com.person98.mod4.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mod4.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModBlocks.GRAY_DANCE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GRAY_DANCE_BLOCK);
                        entries.add(ModBlocks.GREEN_DANCE_BLOCK);
                        entries.add(ModBlocks.WHITE_DANCE_BLOCK);
                        entries.add(ModBlocks.BROWN_DANCE_BLOCK);
                        entries.add(ModBlocks.RED_DANCE_BLOCK);
                        entries.add(ModBlocks.BLUE_DANCE_BLOCK);




                    }).build());


    public static void registerItemGroups() {
        Mod4.LOGGER.info("Registering Item Groups for " + Mod4.MOD_ID);
    }
}