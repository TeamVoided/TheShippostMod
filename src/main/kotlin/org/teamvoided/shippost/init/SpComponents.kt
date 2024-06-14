package org.teamvoided.shippost.init

import net.minecraft.component.DataComponentType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.TheShipPostMod.id
import org.teamvoided.shippost.item.components.StickableComponent
import java.util.function.UnaryOperator

object SpComponents {
    fun init() {}

    val STICKABLE: DataComponentType<StickableComponent> =
        register("stickable") { it.codec(StickableComponent.CODEC).packetCodec(StickableComponent.PACKET_CODEC) }

    fun <T> register(id: String, operator: UnaryOperator<DataComponentType.Builder<T>>): DataComponentType<T> {
        return Registry.register(
            Registries.DATA_COMPONENT_TYPE, id(id),
            operator.apply(DataComponentType.builder()).build()
        )
    }
}
