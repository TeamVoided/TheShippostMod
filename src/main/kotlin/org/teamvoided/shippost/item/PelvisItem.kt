package org.teamvoided.shippost.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.stat.Stats
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import org.teamvoided.shippost.entity.PelvisEntity

class PelvisItem(settings: Settings) : BoneItem(settings) {

    override fun use(world: World, user: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack>? {
        val itemStack = user.getStackInHand(hand)
        world.playSound(
            null, user.x, user.y, user.z, SoundEvents.BLOCK_BONE_BLOCK_HIT,
            SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f)
        )
        if (!world.isClient) {
            val pelvis = PelvisEntity(world, user)
            pelvis.setItem(itemStack)
            pelvis.setProperties(user, user.pitch, user.yaw, 0.0f, 1.5f, .5f)
            world.spawnEntity(pelvis)
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this))
        if (!user.abilities.creativeMode) itemStack.decrement(1)

        return TypedActionResult.success(itemStack, world.isClient())
    }
}
