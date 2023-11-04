package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import org.teamvoided.shippost.init.SpBlocks

class BlockLootTableProvider(dataOutput: FabricDataOutput?) : FabricBlockLootTableProvider(dataOutput) {
    val selfDrop = listOf(
        SpBlocks.TEST_BLOCK,
        SpBlocks.SWAGGIEST_STAIRS
    )
    override fun generate() {
        selfDrop.forEach { addDrop(it) }
    }
}