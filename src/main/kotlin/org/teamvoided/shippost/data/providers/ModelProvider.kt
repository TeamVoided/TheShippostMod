package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.Models
import net.minecraft.item.Items
import org.teamvoided.shippost.init.SpBlocks
import org.teamvoided.shippost.init.SpItems
import org.teamvoided.shippost.init.SpItems.itemsToModel

class ModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    private val itemEx = listOf(SpItems.BIBLE)
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        gen.registerSimpleCubeAll(SpBlocks.TEST_BLOCK)
    }


    override fun generateItemModels(gen: ItemModelGenerator) {
        gen.register(SpItems.BIBLE, Items.ENCHANTED_BOOK, Models.SINGLE_LAYER_ITEM)

        itemsToModel.forEach {
            if (!itemEx.contains(it)) gen.register(it, Models.SINGLE_LAYER_ITEM)
        }
    }
}