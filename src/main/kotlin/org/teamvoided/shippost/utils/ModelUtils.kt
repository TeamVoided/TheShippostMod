package org.teamvoided.shippost.utils

import net.minecraft.block.Block
import net.minecraft.data.client.model.*
import net.minecraft.data.client.model.BlockStateModelGenerator.*
import net.minecraft.util.Identifier

fun BlockStateModelGenerator.stairs(block: Block, baseBlock: Identifier) =
    this.stairs(block, baseBlock, baseBlock, baseBlock)

fun BlockStateModelGenerator.stairs(
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

fun BlockStateModelGenerator.topBottomSides(block: Block, bottom: Identifier, side: Identifier, top: Identifier) {
    val texture: Texture = Texture.texture(block)
        .put(TextureKey.BOTTOM, bottom.withPrefix("block/"))
        .put(TextureKey.SIDE, side.withPrefix("block/"))
        .put(TextureKey.TOP, top.withPrefix("block/"))

    val model: Identifier = Models.CUBE_BOTTOM_TOP.upload(block, texture, this.modelCollector)

    this.blockStateCollector.accept(createSingletonBlockState(block, model))
    this.registerParentedItemModel(block, model)
}
