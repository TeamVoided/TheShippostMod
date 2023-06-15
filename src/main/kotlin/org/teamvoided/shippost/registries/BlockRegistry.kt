package org.teamvoided.shippost.registries

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.TheShippostMod.id
import org.teamvoided.shippost.registries.ItemRegistry.ITEM_LIST

object BlockRegistry {


    val TEST_BLOCK: Block = Block(FabricBlockSettings.create())
    fun init() {
        registerWithItem("test_block", TEST_BLOCK)
    }

    private fun registerWithItem(id: String, block: Block) {
        ITEM_LIST.add(Registry.register(Registries.ITEM, id(id), BlockItem(block, FabricItemSettings())).defaultStack)
        register(id, block)
    }

    private fun register(id: String, block: Block) = Registry.register(Registries.BLOCK, id(id), block)
}