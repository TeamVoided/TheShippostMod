package org.teamvoided.shippost.data.tags

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.BlockTags
import org.teamvoided.shippost.TheShippostMod.LOG
import org.teamvoided.shippost.init.SpBlocks
import java.util.concurrent.CompletableFuture

class BlockTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun configure(arg: HolderLookup.Provider) {
        try {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(SpBlocks.TEST_BLOCK)
        } catch (e: Exception) {
            LOG.error("Error {}", e.toString())
        }
    }

}