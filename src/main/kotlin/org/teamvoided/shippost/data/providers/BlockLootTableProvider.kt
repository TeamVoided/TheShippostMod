package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import org.teamvoided.shippost.registries.BlockRegistry

class BlockLootTableProvider(dataOutput: FabricDataOutput?) : FabricBlockLootTableProvider(dataOutput) {
    override fun generate() {
        addDrop(BlockRegistry.TEST_BLOCK)
    }
}