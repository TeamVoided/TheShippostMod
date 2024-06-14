package org.teamvoided.shippost.item.components

import com.mojang.serialization.Codec
import io.netty.buffer.ByteBuf
import net.minecraft.client.item.TooltipConfig
import net.minecraft.item.Item
import net.minecraft.item.TooltipAppender
import net.minecraft.network.codec.PacketCodec
import net.minecraft.network.codec.PacketCodecs
import net.minecraft.text.Text
import net.minecraft.util.StringIdentifiable
import net.minecraft.util.collection.IdListUtil
import net.minecraft.util.collection.IdListUtil.OutOfBoundsHandler
import java.util.function.Consumer
import java.util.function.IntFunction

enum class StickableComponent(val id: Int) : StringIdentifiable, TooltipAppender {
    STICKABLE(0),
    STICKABLE_EXPLOSIVE(1),
    STICKABLE_FLAMMABLE(2);

    override fun asString(): String = name.lowercase()

    override fun appendToTooltip(
        context: Item.TooltipContext, tooltipConsumer: Consumer<Text>, config: TooltipConfig
    ) {
        tooltipConsumer.accept(Text.translatable("item.shippost.stickable.${asString()}"))
    }

    companion object {
        val INDEX_LIST: IntFunction<StickableComponent> =
            IdListUtil.sortArray({ it.id }, StickableComponent.entries.toTypedArray(), OutOfBoundsHandler.ZERO)
        val CODEC: Codec<StickableComponent> =
            StringIdentifiable.createCodec { StickableComponent.entries.toTypedArray() }
        val PACKET_CODEC: PacketCodec<ByteBuf, StickableComponent> = PacketCodecs.indexed(INDEX_LIST) { it.id }
    }
}
