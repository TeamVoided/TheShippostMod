package org.teamvoided.shippost

import net.fabricmc.api.ModInitializer
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory
import org.teamvoided.shippost.registries.ShoppostBlocks
import org.teamvoided.shippost.registries.ShoppostItems
import org.teamvoided.shippost.registries.ShoppostTabs

object TheShippostMod : ModInitializer {
    const val MODID = "shippost"
    val LOGGER = LoggerFactory.getLogger(MODID)
    fun id(path: String): Identifier = Identifier(MODID, path)
    override fun onInitialize() {
        LOGGER.info("hi, Gun :gun:")

        BoneInjection.init()
        ShoppostItems.init()
        ShoppostBlocks.init()
        ShoppostTabs.init()
    }
    fun getId(item: Item): Identifier = Registries.ITEM.getId(item)
    fun getId(block: Block): Identifier = Registries.BLOCK.getId(block)
}
