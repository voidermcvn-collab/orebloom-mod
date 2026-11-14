package vn.orebloom;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class OreBloom implements ModInitializer {
    private static final String MOD_ID = "orebloom";

    private static final String[] FEATURES = {
        "coal_ore", "iron_ore", "copper_ore", "gold_ore", "redstone_ore",
        "lapis_ore", "diamond_ore", "emerald_ore", "nether_quartz_ore",
        "nether_gold_ore", "ancient_debris", "coal_block", "iron_block",
        "gold_block", "netherite_block", "diamond_block", "emerald_block",
        "lapis_block", "raw_iron_block", "raw_gold_block"
    };

    @Override
    public void onInitialize() {
        for (String name : FEATURES) {
            ResourceKey<PlacedFeature> key = ResourceKey.create(
                Registries.PLACED_FEATURE,
                Identifier.fromNamespaceAndPath(MOD_ID, name)
            );
            BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                key
            );
        }
    }
}
