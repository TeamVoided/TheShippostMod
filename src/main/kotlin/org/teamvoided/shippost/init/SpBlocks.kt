package org.teamvoided.shippost.init

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.StairsBlock
import net.minecraft.item.BlockItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.TheShippostMod.id
import org.teamvoided.shippost.init.SpItems.ITEM_LIST
import java.util.*

object SpBlocks {
    val BLOCK_LIST = LinkedList<Block>()

    val TEST_BLOCK: Block = registerWithItem("test_block", Block(FabricBlockSettings.create()))
    lateinit var SWAGGIEST_STAIRS: Block

    fun init() {
        SWAGGIEST_STAIRS = registerWithItem(
            "swaggiest_stairs",
            StairsBlock(Blocks.NETHERITE_BLOCK.defaultState, FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK))
        )
    }

    private fun registerWithItem(id: String, block: Block): Block {
        BLOCK_LIST.add(block)
        ITEM_LIST.add(Registry.register(Registries.ITEM, id(id), BlockItem(block, FabricItemSettings())).defaultStack)
        return register(id, block)
    }

    private fun register(id: String, block: Block) = Registry.register(Registries.BLOCK, id(id), block)
}