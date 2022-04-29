package dev.intelligentcreations.randore.worldgen

import dev.intelligentcreations.randore.Randore
import dev.intelligentcreations.randore.Randore.MOD_ID
import dev.intelligentcreations.randore.blocks.BlockInit
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.block.Blocks
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.util.Identifier
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier
import java.util.*


object OregenInit {
    private val RANDOM_ORE_CONFIGURED_FEATURE: ConfiguredFeature<*, *> = ConfiguredFeature(
        Feature.ORE, OreFeatureConfig(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            BlockInit.RANDOM_ORE.defaultState,
            Randore.CONFIG.random_ore_vein_size
        )
    )

    var RANDOM_ORE_PLACED_FEATURE = PlacedFeature(
        RegistryEntry.of(RANDOM_ORE_CONFIGURED_FEATURE),
        Arrays.asList(
            CountPlacementModifier.of(Randore.CONFIG.random_ore_vein_number),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(Randore.CONFIG.random_ore_height))
        )
    )

    private val DEEPSLATE_RANDOM_ORE_CONFIGURED_FEATURE: ConfiguredFeature<*, *> = ConfiguredFeature(
        Feature.ORE, OreFeatureConfig(
            OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
            BlockInit.DEEPSLATE_RANDOM_ORE.defaultState,
            Randore.CONFIG.deepslate_random_ore_vein_size
        )
    )

    var DEEPSLATE_RANDOM_ORE_PLACED_FEATURE = PlacedFeature(
        RegistryEntry.of(DEEPSLATE_RANDOM_ORE_CONFIGURED_FEATURE),
        Arrays.asList(
            CountPlacementModifier.of(Randore.CONFIG.deepslate_random_ore_vein_number),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(Randore.CONFIG.deepslate_random_ore_height))
        )
    )

    private val NETHER_RANDOM_ORE_CONFIGURED_FEATURE: ConfiguredFeature<*, *> = ConfiguredFeature(
        Feature.ORE, OreFeatureConfig(
            OreConfiguredFeatures.NETHERRACK,
            BlockInit.NETHER_RANDOM_ORE.defaultState,
            Randore.CONFIG.nether_random_ore_vein_size
        )
    )

    var NETHER_RANDOM_ORE_PLACED_FEATURE = PlacedFeature(
        RegistryEntry.of(NETHER_RANDOM_ORE_CONFIGURED_FEATURE),
        Arrays.asList(
            CountPlacementModifier.of(Randore.CONFIG.nether_random_ore_vein_number),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(Randore.CONFIG.nether_random_ore_height))
        )
    )

    private val END_RANDOM_ORE_CONFIGURED_FEATURE: ConfiguredFeature<*, *> = ConfiguredFeature(
        Feature.ORE, OreFeatureConfig(
            BlockMatchRuleTest(Blocks.END_STONE),
            BlockInit.NETHER_RANDOM_ORE.defaultState,
            Randore.CONFIG.end_random_ore_vein_size
        )
    )

    var END_RANDOM_ORE_PLACED_FEATURE = PlacedFeature(
        RegistryEntry.of(END_RANDOM_ORE_CONFIGURED_FEATURE),
        Arrays.asList(
            CountPlacementModifier.of(Randore.CONFIG.end_random_ore_vein_number),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(Randore.CONFIG.end_random_ore_height))
        )
    )

    fun registerOregen() {
        if (Randore.CONFIG.random_ore_do_generate) {
            Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                Identifier(MOD_ID, "random_ore"), RANDOM_ORE_CONFIGURED_FEATURE
            )
            Registry.register(
                BuiltinRegistries.PLACED_FEATURE, Identifier(MOD_ID, "random_ore"),
                RANDOM_ORE_PLACED_FEATURE
            )
            BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                    Registry.PLACED_FEATURE_KEY,
                    Identifier(MOD_ID, "random_ore")
                )
            )
        }

        if (Randore.CONFIG.deepslate_random_ore_do_generate) {
            Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                Identifier(MOD_ID, "deepslate_random_ore"), DEEPSLATE_RANDOM_ORE_CONFIGURED_FEATURE
            )
            Registry.register(
                BuiltinRegistries.PLACED_FEATURE, Identifier(MOD_ID, "deepslate_random_ore"),
                DEEPSLATE_RANDOM_ORE_PLACED_FEATURE
            )
            BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                    Registry.PLACED_FEATURE_KEY,
                    Identifier(MOD_ID, "deepslate_random_ore")
                )
            )
        }

        if (Randore.CONFIG.nether_random_ore_do_generate) {
            Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                Identifier(MOD_ID, "nether_random_ore"), NETHER_RANDOM_ORE_CONFIGURED_FEATURE
            )
            Registry.register(
                BuiltinRegistries.PLACED_FEATURE, Identifier(MOD_ID, "nether_random_ore"),
                NETHER_RANDOM_ORE_PLACED_FEATURE
            )
            BiomeModifications.addFeature(
                BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                    Registry.PLACED_FEATURE_KEY,
                    Identifier(MOD_ID, "nether_random_ore")
                )
            )
        }

        if (Randore.CONFIG.end_random_ore_do_generate) {
            Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                Identifier(MOD_ID, "end_random_ore"), END_RANDOM_ORE_CONFIGURED_FEATURE
            )
            Registry.register(
                BuiltinRegistries.PLACED_FEATURE, Identifier(MOD_ID, "end_random_ore"),
                END_RANDOM_ORE_PLACED_FEATURE
            )
            BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                    Registry.PLACED_FEATURE_KEY,
                    Identifier(MOD_ID, "end_random_ore")
                )
            )
        }
    }
}