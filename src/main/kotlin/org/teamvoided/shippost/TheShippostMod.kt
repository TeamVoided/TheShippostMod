package org.teamvoided.shippost

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory
import org.teamvoided.shippost.registries.ItemRegistry

object TheShippostMod : ModInitializer {
    const val MODID = "shippost"
    val LOGGER = LoggerFactory.getLogger(MODID)
    @JvmStatic
    fun id(path: String): Identifier = Identifier(MODID, path)

    override fun onInitialize() {
        LOGGER.info("hi, Gun \uD83D\uDD2B")

        BoneInjection.init()
        ItemRegistry.init()
    }
}