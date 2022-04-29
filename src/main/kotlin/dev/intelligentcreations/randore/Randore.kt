package dev.intelligentcreations.randore

import dev.intelligentcreations.randore.blocks.BlockInit
import dev.intelligentcreations.randore.config.RandoreConfig
import dev.intelligentcreations.randore.worldgen.OregenInit
import draylar.omegaconfig.OmegaConfig
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory


object Randore : ModInitializer {
    val LOGGER: Logger = LoggerFactory.getLogger("Rand'Ore")
    const val MOD_ID = "randore"
    val CONFIG: RandoreConfig = OmegaConfig.register(RandoreConfig::class.java)

    override fun onInitialize() {
        BlockInit.registerBlocks()
        OregenInit.registerOregen()
        LOGGER.info("Initialized.")
    }
}