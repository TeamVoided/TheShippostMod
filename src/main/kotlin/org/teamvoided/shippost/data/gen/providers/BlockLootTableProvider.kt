package org.teamvoided.shippost.data.gen.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.registry.HolderLookup
import org.teamvoided.shippost.init.SpBlocks
import java.util.concurrent.CompletableFuture

class BlockLootTableProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootTableProvider(o, r) {
    private val selfDrop = listOf(
        SpBlocks.SUS_CONCRETE,
        SpBlocks.RED_CONCRETE_STAIRS,
        SpBlocks.SWAGGY_STAIRS,
        SpBlocks.SWAGGIER_STAIRS,
        SpBlocks.SWAGGIEST_STAIRS,
    )

    override fun generate() {
        selfDrop.forEach { addDrop(it) }
    }
}
