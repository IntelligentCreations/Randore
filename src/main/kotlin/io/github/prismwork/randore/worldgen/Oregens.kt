package io.github.prismwork.randore.worldgen

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.PlacedFeature

val RANDOM_ORE_FEATURE: RegistryKey<PlacedFeature> = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier("randore", "random_ore"))
val DEEPSLATE_RANDOM_ORE_FEATURE: RegistryKey<PlacedFeature> = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier("randore", "deepslate_random_ore"))
val NETHER_RANDOM_ORE_FEATURE: RegistryKey<PlacedFeature> = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier("randore", "nether_random_ore"))
val END_RANDOM_ORE_FEATURE: RegistryKey<PlacedFeature> = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier("randore", "end_random_ore"))

fun registerOregens() {
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RANDOM_ORE_FEATURE)
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, DEEPSLATE_RANDOM_ORE_FEATURE)
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NETHER_RANDOM_ORE_FEATURE)
    BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, END_RANDOM_ORE_FEATURE)
}
