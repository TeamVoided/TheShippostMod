package org.teamvoided.shippost

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.shippost.gogoly_gagady.BoneInjection
import org.teamvoided.shippost.gogoly_gagady.FatalStrike
import org.teamvoided.shippost.init.*

@Suppress("unused")
object TheShippostMod {
    const val MODID: String = "shippost"
    val LOG: Logger = LoggerFactory.getLogger(MODID)
    fun id(path: String): Identifier = Identifier(MODID, path)

    fun mainInit() {
        LOG.info("hi, Gun :gun:")

        SpEntities.serverInit()
        SpItems.init()
        SpBlocks.init()
        SpTabs.init()

        BoneInjection.init()
        FatalStrike.inti()
    }
    fun clientInit(){
        SpEntities.clientInit()
    }
}
