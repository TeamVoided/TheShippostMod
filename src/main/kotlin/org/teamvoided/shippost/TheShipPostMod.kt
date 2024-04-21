package org.teamvoided.shippost

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.shippost.init.SpBlocks
import org.teamvoided.shippost.init.SpEntities
import org.teamvoided.shippost.init.SpItems
import org.teamvoided.shippost.init.SpTabs
import org.teamvoided.shippost.modules.BadToTheBoneModule
import org.teamvoided.shippost.modules.BoneInjection
import org.teamvoided.shippost.modules.ExplodeButton
import org.teamvoided.shippost.modules.FatalStrike

@Suppress("unused")
object TheShipPostMod {
    const val MODID: String = "shippost"
    val LOG: Logger = LoggerFactory.getLogger(MODID)
    fun id(path: String): Identifier = Identifier(MODID, path)
    val Item.gId get() = Registries.ITEM.getId(this)
    val Block.gId get() = Registries.BLOCK.getId(this)

    fun mainInit() {
        LOG.info("hi, Gun :gun:")

        SpEntities.serverInit()
        SpItems.init()
        SpBlocks.init()
        SpTabs.init()

        BoneInjection.init()
        FatalStrike.inti()
        ExplodeButton.initCommon()
        BadToTheBoneModule.initCommon()
    }

    fun clientInit() {
        SpEntities.clientInit()
        ExplodeButton.initClient()
    }
}
