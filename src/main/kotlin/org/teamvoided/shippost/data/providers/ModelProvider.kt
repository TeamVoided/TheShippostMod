package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import org.teamvoided.shippost.registries.ItemRegistry

import net.minecraft.data.client.*
import net.minecraft.item.BlockItem
import org.teamvoided.shippost.TheShippostMod.getId
import org.teamvoided.shippost.TheShippostMod.id
import org.teamvoided.shippost.registries.BlockRegistry

class ModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        gen.registerSimpleCubeAll(BlockRegistry.TEST_BLOCK)
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        gen.register(ItemRegistry.TEST, Models.GENERATED)

        for (i in ItemRegistry.ITEM_LIST) {
            val item = i.item
            if (item is BlockItem) {
                val path = getId(item).path
                gen.writer.accept(id("item/$path"), SimpleModelSupplier(id("block/$path")))
            } else if (getId(item).path != "test") {
                gen.register(item, Models.GENERATED)
            }
        }
    }
}