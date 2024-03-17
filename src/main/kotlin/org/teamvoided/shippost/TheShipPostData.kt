package org.teamvoided.shippost

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.registry.HolderLookup
import org.teamvoided.shippost.data.providers.*
import org.teamvoided.shippost.data.tags.BlockTagProvider
import java.util.concurrent.CompletableFuture


@Suppress("unused")
class TheShipPostData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack: FabricDataGenerator.Pack = gen.createPack()

        pack.addProvider { o: FabricDataOutput -> RecipeProvider(o) }
        pack.addProvider { o: FabricDataOutput -> ModelProvider(o) }
        pack.addProvider { output: FabricDataOutput -> BlockLootTableProvider(output) }
        pack.addProvider { output: FabricDataOutput -> AdvancementProvider(output) }
        pack.addProvider { o: FabricDataOutput -> EnglishTranslationProvider(o) }
        pack.addProvider { o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider> -> BlockTagProvider(o, r) }

    }
}