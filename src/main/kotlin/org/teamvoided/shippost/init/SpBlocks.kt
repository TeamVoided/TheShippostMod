package org.teamvoided.shippost.init

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.StairsBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.TheShipPostMod.id
import org.teamvoided.shippost.init.SpItems.ITEM_LIST
import java.util.*

object SpBlocks {
    fun init() {}
    val BLOCK_LIST = LinkedList<Block>()

    val TEST_BLOCK: Block = registerWithItem("test_block", Block(AbstractBlock.Settings.create()))

    val SUS_CONCRETE = registerWithItem("sus_concrete", Block(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE)))

    // Stairs
    var SWAGGY_STAIRS: Block = registerWithItem("swaggy_stairs", StairsBlock(Blocks.EMERALD_BLOCK))
    var SWAGGIER_STAIRS: Block = registerWithItem("swaggier_stairs", StairsBlock(Blocks.DIAMOND_BLOCK))
    var SWAGGIEST_STAIRS: Block = registerWithItem("swaggiest_stairs", StairsBlock(Blocks.NETHERITE_BLOCK))

    var RED_CONCRETE_STAIRS: Block = registerWithItem("red_concrete_stairs", StairsBlock(Blocks.RED_CONCRETE))


    private fun registerWithItem(id: String, block: Block): Block {
        BLOCK_LIST.add(block)
        ITEM_LIST.add(Registry.register(Registries.ITEM, id(id), BlockItem(block, Item.Settings())).defaultStack)
        return register(id, block)
    }

    private fun register(id: String, block: Block) = Registry.register(Registries.BLOCK, id(id), block)

    private fun StairsBlock(block: Block) = StairsBlock(block.defaultState, AbstractBlock.Settings.copy(block))
}
