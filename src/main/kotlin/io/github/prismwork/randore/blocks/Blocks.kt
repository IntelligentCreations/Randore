package io.github.prismwork.randore.blocks

import io.github.prismwork.randore.Randore.MOD_ID
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

val RANDOM_ORE: Block = Block(
    FabricBlockSettings.create()
        .mapColor(MapColor.STONE_GRAY)
        .strength(4.0f)
        .requiresTool()
        .sounds(BlockSoundGroup.STONE)
)

val DEEPSLATE_RANDOM_ORE: Block = Block(
    FabricBlockSettings.create()
        .mapColor(MapColor.STONE_GRAY)
        .strength(4.0f)
        .requiresTool()
        .sounds(BlockSoundGroup.DEEPSLATE)
)

val NETHER_RANDOM_ORE: Block = Block(
    FabricBlockSettings.create()
        .mapColor(MapColor.STONE_GRAY)
        .strength(4.0f)
        .requiresTool()
        .sounds(BlockSoundGroup.NETHERRACK)
)

val END_RANDOM_ORE: Block = Block(
    FabricBlockSettings.create()
        .mapColor(MapColor.STONE_GRAY)
        .strength(4.0f)
        .requiresTool()
        .sounds(BlockSoundGroup.STONE)
)

fun registerBlocks() {
    Registry.register(Registries.BLOCK, Identifier(MOD_ID, "random_ore"), RANDOM_ORE)
    val randomOreItem = Registry.register(Registries.ITEM, Identifier(MOD_ID, "random_ore"), BlockItem(
        RANDOM_ORE, FabricItemSettings()))
    Registry.register(Registries.BLOCK, Identifier(MOD_ID, "deepslate_random_ore"), DEEPSLATE_RANDOM_ORE)
    val deepslateRandomOreItem = Registry.register(Registries.ITEM, Identifier(MOD_ID, "deepslate_random_ore"), BlockItem(
        DEEPSLATE_RANDOM_ORE, FabricItemSettings()))
    Registry.register(Registries.BLOCK, Identifier(MOD_ID, "nether_random_ore"), NETHER_RANDOM_ORE)
    val netherRandomOreItem = Registry.register(Registries.ITEM, Identifier(MOD_ID, "nether_random_ore"), BlockItem(
        NETHER_RANDOM_ORE, FabricItemSettings()))
    Registry.register(Registries.BLOCK, Identifier(MOD_ID, "end_random_ore"), END_RANDOM_ORE)
    val endRandomOreItem = Registry.register(Registries.ITEM, Identifier(MOD_ID, "end_random_ore"), BlockItem(
        END_RANDOM_ORE, FabricItemSettings()))
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register {
        it.addAll(mutableListOf(
            randomOreItem.defaultStack,
            deepslateRandomOreItem.defaultStack,
            netherRandomOreItem.defaultStack,
            endRandomOreItem.defaultStack
        ))
    }
}
