package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.Models
import org.teamvoided.shippost.registries.SpBlocks
import org.teamvoided.shippost.registries.SpItems.itemsToModel

class ModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        gen.registerSimpleCubeAll(SpBlocks.TEST_BLOCK)
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
//        gen.register(SpItems.TEST, Models.GENERATED)

        itemsToModel.forEach{
            gen.register(it, Models.SINGLE_LAYER_ITEM)
        }
    }
}