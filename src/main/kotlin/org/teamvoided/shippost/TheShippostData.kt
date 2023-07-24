package org.teamvoided.shippost

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import org.teamvoided.shippost.data.providers.AdvancementProvider
import org.teamvoided.shippost.data.providers.BlockLootTableProvider
import org.teamvoided.shippost.data.providers.ModelProvider
import org.teamvoided.shippost.data.providers.RecipeProvider


@Suppress("unused")
class TheShippostData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack: FabricDataGenerator.Pack = gen.createPack()

        pack.addProvider { output: FabricDataOutput -> RecipeProvider(output) }
        pack.addProvider { output: FabricDataOutput -> ModelProvider(output) }
        pack.addProvider { output: FabricDataOutput -> BlockLootTableProvider(output) }
        pack.addProvider { output: FabricDataOutput -> AdvancementProvider(output) }
    }
}