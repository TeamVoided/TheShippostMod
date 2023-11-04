package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.*
import net.minecraft.data.client.model.BlockStateModelGenerator.*
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import org.teamvoided.shippost.init.SpBlocks
import org.teamvoided.shippost.init.SpItems
import org.teamvoided.shippost.init.SpItems.itemsToModel
import org.teamvoided.voidlib.core.gId

class ModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    private val itemEx = listOf(SpItems.BIBLE)
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        gen.registerSimpleCubeAll(SpBlocks.TEST_BLOCK)
        gen.stairs(SpBlocks.SWAGGIEST_STAIRS, Blocks.NETHERITE_BLOCK.gId)
    }


    override fun generateItemModels(gen: ItemModelGenerator) {
        gen.register(SpItems.BIBLE, Items.ENCHANTED_BOOK, Models.SINGLE_LAYER_ITEM)

        itemsToModel.forEach {
            if (!itemEx.contains(it))
                gen.register(it, Models.SINGLE_LAYER_ITEM)
        }
    }

    private fun BlockStateModelGenerator.stairs(block: Block, baseBlock: Identifier ) =
        this.stairs(block, baseBlock, baseBlock, baseBlock)

    private fun BlockStateModelGenerator.stairs(
        block: Block, bottom: Identifier, side: Identifier, top: Identifier,
        ) {
        val texture: Texture = Texture.texture(block)
            .put(TextureKey.BOTTOM, bottom.withPrefix("block/"))
            .put(TextureKey.SIDE, side.withPrefix("block/"))
            .put(TextureKey.TOP, top.withPrefix("block/"))

        val id: Identifier = Models.INNER_STAIRS.upload(block, texture, this.modelCollector)
        val id2: Identifier = Models.STAIRS.upload(block, texture, this.modelCollector)
        val id3: Identifier = Models.OUTER_STAIRS.upload(block, texture, this.modelCollector)

        this.blockStateCollector.accept(createStairsBlockState(block, id, id2, id3))
        this.registerParentedItemModel(block, id2)
    }
}