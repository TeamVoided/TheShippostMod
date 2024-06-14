package org.teamvoided.shippost.modules

import net.fabricmc.fabric.api.event.player.UseItemCallback
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents
import net.minecraft.registry.Registries
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import org.teamvoided.shippost.config.StickableConfig
import org.teamvoided.shippost.config.StickableConfig.STICKABLE
import org.teamvoided.shippost.config.StickableConfig.STICKABLE_EXPLOSIVE
import org.teamvoided.shippost.config.StickableConfig.STICKABLE_FLAMMABLE
import org.teamvoided.shippost.init.SpComponents
import org.teamvoided.shippost.item.components.StickableComponent

object Stickable {
    fun init() {
        DefaultItemComponentEvents.MODIFY.register { c ->
            Registries.ITEM.forEach { item ->
                val data = if (STICKABLE_FLAMMABLE.contains(item)) {
                    StickableComponent.STICKABLE_FLAMMABLE
                } else if (STICKABLE_EXPLOSIVE.contains(item)) {
                    StickableComponent.STICKABLE_EXPLOSIVE
                } else if (STICKABLE.contains(item)) {
                    StickableComponent.STICKABLE
                } else null

                data?.let { data1 -> c.modify(item) { it.put(SpComponents.STICKABLE, data1) } }
            }
        }
        UseItemCallback.EVENT.register { player, world, hand ->
            val stack = player.getStackInHand(hand)
            if (!world.isClient) {
                stack.get(SpComponents.STICKABLE)?.let { stickable ->
                    val isCreative = player.isCreative
                    when (stickable) {
                        StickableComponent.STICKABLE -> {
                            world.playSoundFromEntity(
                                null, player,
                                SoundEvents.BLOCK_BAMBOO_BREAK, SoundCategory.BLOCKS,
                                1.0f, 1.0f
                            )
                            stack.increment(1)
                        }

                        StickableComponent.STICKABLE_EXPLOSIVE -> {
                            world.createExplosion(
                                null, player.x, player.y + 1, player.z,
                                2.0f,
                                World.ExplosionSourceType.NONE
                            )
                            if (!isCreative) stack.decrement(1)
                        }

                        StickableComponent.STICKABLE_FLAMMABLE -> {
                            player.fireTicks += StickableConfig.flammableLength
                            if (!isCreative) stack.decrement(1)
                        }
                    }
                    TypedActionResult.consume(stack)
                }
            }
            TypedActionResult.pass(stack)
        }
    }
}
