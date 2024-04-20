package org.teamvoided.shippost.modules

import com.mojang.blaze3d.platform.InputUtil
import io.netty.buffer.Unpooled
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.client.option.KeyBind
import net.minecraft.network.PacketByteBuf
import net.minecraft.world.World
import org.teamvoided.shippost.TheShipPostMod.id

object ExplodeButton {
    private val EXPLODE_KEY = id("explode_key")

    private val explodeKey: KeyBind = KeyBindingHelper
        .registerKeyBinding(KeyBind("Explode", InputUtil.KEY_K_CODE, "ShipPost"))

    fun initClient() {
        ClientTickEvents.END_CLIENT_TICK.register {
            if (explodeKey.wasPressed()) ClientPlayNetworking.send(EXPLODE_KEY, PacketByteBuf(Unpooled.buffer()))
        }
    }

    fun initServer() {
        ServerPlayNetworking.registerGlobalReceiver(EXPLODE_KEY) { _, player, _, _, _ ->
            player.world.createExplosion(
                null,
                player.x,
                player.y + 1,
                player.z,
                8.0f,
                World.ExplosionSourceType.NONE
            )
        }
    }
}