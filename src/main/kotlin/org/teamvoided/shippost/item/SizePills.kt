package org.teamvoided.shippost.item

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class SizePills(val size: Double, settings: Settings) : Item(settings) {

    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val stack = user.getStackInHand(hand)
        if (hand == Hand.OFF_HAND && user.getStackInHand(Hand.MAIN_HAND).item is SizePills)
            return TypedActionResult.pass(stack)

        user.itemCooldownManager[this] = 2
        if (world.isClient) return TypedActionResult.pass(stack)

        user.getAttributeInstance(EntityAttributes.GENERIC_SCALE)!!.baseValue += size
        if (!user.isCreative) stack.decrement(1)

        return TypedActionResult.success(stack)
    }

    override fun useOnEntity(stack: ItemStack, user: PlayerEntity, entity: LivingEntity, hand: Hand): ActionResult {
        user.itemCooldownManager[this] = 2
        if (hand == Hand.OFF_HAND && user.getStackInHand(Hand.MAIN_HAND).item is SizePills)
            return ActionResult.PASS

        if (user.world.isClient) return ActionResult.PASS

        entity.getAttributeInstance(EntityAttributes.GENERIC_SCALE)!!.baseValue += size
        if (!user.isCreative) stack.decrement(1)

        return ActionResult.SUCCESS
    }
}