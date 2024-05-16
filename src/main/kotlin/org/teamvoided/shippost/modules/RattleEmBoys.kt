package org.teamvoided.shippost.modules

import net.fabricmc.fabric.api.event.player.AttackEntityCallback
import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.SkeletonEntity
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ActionResult

object RattleEmBoys {
    fun initCommon() {
        AttackEntityCallback.EVENT.register { player, world, hand, entity, entityHitResult ->
            val random = world.random
            if (!world.isClient
                && isSkelet(entity.type)
                && random.range(0, 10) == 0
            ) {
                player.sendSystemMessage(Text.of("Rattle em boys"))
                world.playSound(
                    null,
                    player.blockPos, SoundEvents.BLOCK_BONE_BLOCK_FALL, SoundCategory.MASTER
                )
                for (ignored in 0..random.range(2, 6)) {
                    world.playSound(
                        null,
                        entity.blockPos, SoundEvents.BLOCK_BONE_BLOCK_STEP, SoundCategory.HOSTILE
                    )
                    val skelet = SkeletonEntity(entity.type as EntityType<out SkeletonEntity>, world)
                    skelet.setPosition(entity.pos)
                    world.spawnEntity(skelet)
                }
            }
            ActionResult.PASS
        }
    }

    fun isSkelet(type: EntityType<*>): Boolean {
        return type == EntityType.SKELETON
                || type == EntityType.WITHER_SKELETON
                || type == EntityType.BOGGED
                || type == EntityType.STRAY
    }
}