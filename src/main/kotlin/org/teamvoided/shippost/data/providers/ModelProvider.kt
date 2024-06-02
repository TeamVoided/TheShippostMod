package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.block.Blocks
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.Models
import net.minecraft.item.Items
import org.teamvoided.shippost.TheShipPostMod.gId
import org.teamvoided.shippost.init.SpBlocks
import org.teamvoided.shippost.init.SpItems
import org.teamvoided.shippost.init.SpItems.itemsToModel
import org.teamvoided.shippost.utils.stairs
import org.teamvoided.shippost.utils.topBottomSides

class ModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    private val tools = listOf(SpItems.COPPER_SHORTSWORD, SpItems.NETHERITE_COPPER_SHORTSWORD)
    private val itemEx = listOf(SpItems.BIBLE) + tools

    val stairs = listOf(
        SpBlocks.SWAGGY_STAIRS to Blocks.EMERALD_BLOCK,
        SpBlocks.SWAGGIER_STAIRS to Blocks.DIAMOND_BLOCK,
        SpBlocks.SWAGGIEST_STAIRS to Blocks.NETHERITE_BLOCK,
        SpBlocks.RED_CONCRETE_STAIRS to Blocks.RED_CONCRETE,
    )

    val cubes = listOf(
        SpBlocks.TEST_BLOCK,
    )

    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        cubes.forEach { gen.registerSimpleCubeAll(it) }
        stairs.forEach { (stair, base) -> gen.stairs(stair, base.gId) }

        gen.topBottomSides(
            SpBlocks.SUS_CONCRETE,
            Blocks.CYAN_CONCRETE.gId, SpBlocks.SUS_CONCRETE.gId, Blocks.RED_CONCRETE.gId
        )

    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        gen.register(SpItems.BIBLE, Items.ENCHANTED_BOOK, Models.SINGLE_LAYER_ITEM)
        tools.forEach { gen.register(it, Models.HANDHELD) }

        itemsToModel.forEach {
            if (!itemEx.contains(it))
                gen.register(it, Models.SINGLE_LAYER_ITEM)
        }
    }

}
