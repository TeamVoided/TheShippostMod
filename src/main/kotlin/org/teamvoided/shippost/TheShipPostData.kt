package org.teamvoided.shippost

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import org.teamvoided.shippost.data.providers.*
import org.teamvoided.shippost.data.providers.tags.BlockTagProvider
import org.teamvoided.shippost.data.providers.tags.ItemTagProvider


@Suppress("unused")
class TheShipPostData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack: FabricDataGenerator.Pack = gen.createPack()

        pack.addProvider(::ModelProvider)
        pack.addProvider(::RecipeProvider)
        pack.addProvider(::AdvancementProvider)
        pack.addProvider(::BlockLootTableProvider)
        pack.addProvider(::EnglishTranslationProvider)

        pack.addProvider(::BlockTagProvider)
        pack.addProvider(::ItemTagProvider)

    }
}