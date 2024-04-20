package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.registry.HolderLookup
import org.teamvoided.shippost.init.SpBlocks
import java.util.concurrent.CompletableFuture

class BlockLootTableProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootTableProvider(o, r) {
    private val selfDrop = listOf(
        SpBlocks.TEST_BLOCK,
        SpBlocks.SWAGGIEST_STAIRS
    )

    override fun generate() {
        selfDrop.forEach { addDrop(it) }
    }
}
