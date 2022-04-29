package dev.intelligentcreations.randore.blocks

import dev.intelligentcreations.randore.Randore.MOD_ID
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object BlockInit {
    fun registerBlocks() {
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "random_ore"), RANDOM_ORE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "random_ore"), BlockItem(RANDOM_ORE, FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)))
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "deepslate_random_ore"), DEEPSLATE_RANDOM_ORE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "deepslate_random_ore"), BlockItem(DEEPSLATE_RANDOM_ORE, FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)))
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "nether_random_ore"), NETHER_RANDOM_ORE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "nether_random_ore"), BlockItem(NETHER_RANDOM_ORE, FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)))
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "end_random_ore"), END_RANDOM_ORE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "end_random_ore"), BlockItem(END_RANDOM_ORE, FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)))
    }

    val RANDOM_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool())
    val DEEPSLATE_RANDOM_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(6.0f).requiresTool())
    val NETHER_RANDOM_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool())
    val END_RANDOM_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).requiresTool())
}