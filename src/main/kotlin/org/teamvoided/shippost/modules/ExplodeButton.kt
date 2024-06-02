package org.teamvoided.shippost.modules

import com.mojang.blaze3d.platform.InputUtil
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.client.option.KeyBind
import net.minecraft.network.PacketByteBuf
import net.minecraft.network.codec.PacketCodec
import net.minecraft.network.packet.payload.CustomPayload
import net.minecraft.world.World
import org.teamvoided.shippost.TheShipPostMod.id

object ExplodeButton {
    fun initClient() {
        val explodeKey: KeyBind = KeyBindingHelper
            .registerKeyBinding(KeyBind("Explode", InputUtil.KEY_K_CODE, "ShipPost"))

        ClientTickEvents.END_CLIENT_TICK.register {
            if (explodeKey.wasPressed()) ClientPlayNetworking.send(ExplodeKey())
        }
    }

    fun initCommon() {
        PayloadTypeRegistry.playC2S().register(ExplodeKey.ID, ExplodeKey.CODEC)
        ServerPlayNetworking.registerGlobalReceiver(ExplodeKey.ID) { _, c ->
            val player = c.player()
            player.world.createExplosion(
                null, player.x, player.y + 1, player.z,
                8.0f,
                World.ExplosionSourceType.NONE
            )
        }
    }

    class ExplodeKey() : CustomPayload {
        private constructor(ignored: PacketByteBuf) : this()
        override fun getId(): CustomPayload.Id<ExplodeKey> = ID

        companion object {
            val CODEC: PacketCodec<PacketByteBuf, ExplodeKey> = CustomPayload.create({ _, _ -> }, ::ExplodeKey)
            val ID: CustomPayload.Id<ExplodeKey> = CustomPayload.Id(id("explode_key"))
        }
    }
}
