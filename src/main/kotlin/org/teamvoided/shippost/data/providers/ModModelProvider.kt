package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import org.teamvoided.shippost.registries.ItemRegistry

import net.minecraft.data.client.*

class ModModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {

    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        gen.register(ItemRegistry.TEST, Models.GENERATED);
    }
}