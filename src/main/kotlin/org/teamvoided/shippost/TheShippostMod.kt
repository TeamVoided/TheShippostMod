package org.teamvoided.shippost

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object TheShippostMod : ModInitializer {
    const val MODID = "shippost"
    val LOGGER = LoggerFactory.getLogger(MODID)

    override fun onInitialize() {
        LOGGER.info("hi, Gun :gun:")

       BoneInjection.init()

    }

    fun id(path: String): Identifier = Identifier(MODID, path)
    
}
