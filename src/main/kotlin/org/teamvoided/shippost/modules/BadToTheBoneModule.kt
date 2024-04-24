package org.teamvoided.shippost.modules

import net.fabricmc.fabric.api.event.player.AttackEntityCallback
import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.SkeletonEntity
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ActionResult

object BadToTheBoneModule {
    fun initCommon() {
        AttackEntityCallback.EVENT.register { player, world, hand, entity, entityHitResult ->
            val random = world.random
            if (!world.isClient
                && entity.type == EntityType.SKELETON
                && random.range(0, 100) == 0
            ) {
                player.sendSystemMessage(Text.of("Rattle em boys"))
                world.playSound(
                    null,
                    entity.blockPos, SoundEvents.BLOCK_BONE_BLOCK_PLACE, SoundCategory.HOSTILE
                )
                for (ignored in 0..random.range(2, 6)) {
                    world.playSound(
                        null,
                        entity.blockPos, SoundEvents.BLOCK_BONE_BLOCK_PLACE, SoundCategory.HOSTILE
                    )
                    val skelet = SkeletonEntity(EntityType.SKELETON, world)
                    skelet.setPosition(entity.pos)
                    world.spawnEntity(skelet)
                }
            }
            ActionResult.PASS
        }
    }
}