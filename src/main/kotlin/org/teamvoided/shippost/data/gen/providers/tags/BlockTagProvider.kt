package org.teamvoided.shippost.data.gen.providers.tags

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.BlockTags
import org.teamvoided.shippost.init.SpBlocks
import java.util.concurrent.CompletableFuture

class BlockTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun configure(arg: HolderLookup.Provider) {
        pickaxeMineable()
        ironLevel()
        diamondLevel()
        stairs()
    }

    private fun pickaxeMineable() = getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        .add(
            SpBlocks.SUS_CONCRETE,
            SpBlocks.RED_CONCRETE_STAIRS,
            SpBlocks.SWAGGY_STAIRS,
            SpBlocks.SWAGGIER_STAIRS,
            SpBlocks.SWAGGIEST_STAIRS
        )

    private fun ironLevel() = getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
        .add(
            SpBlocks.SWAGGY_STAIRS,
            SpBlocks.SWAGGIER_STAIRS
        )

    private fun diamondLevel() = getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        .add(
            SpBlocks.SWAGGIEST_STAIRS,
        )

    private fun stairs() = getOrCreateTagBuilder(BlockTags.STAIRS)
        .add(
            SpBlocks.SWAGGY_STAIRS,
            SpBlocks.SWAGGIER_STAIRS,
            SpBlocks.SWAGGIEST_STAIRS,
            SpBlocks.RED_CONCRETE_STAIRS
        )
}
