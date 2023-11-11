package io.github.prismwork.randore

import io.github.prismwork.randore.blocks.registerBlocks
import io.github.prismwork.randore.worldgen.registerOregens
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Randore : ModInitializer {
    val LOGGER: Logger = LoggerFactory.getLogger("Rand'Ore")
    const val MOD_ID = "randore"

    override fun onInitialize() {
        registerBlocks()
        registerOregens()
        LOGGER.info("Initialized.")
    }
}
