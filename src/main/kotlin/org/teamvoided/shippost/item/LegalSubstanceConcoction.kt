package org.teamvoided.shippost.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import org.teamvoided.shippost.init.SpDamageTypes.SUBSTANCE_CONCOCTION
import org.teamvoided.shippost.init.SpDamageTypes.customDamage

class LegalSubstanceConcoction(settings: Settings) : Item(settings) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        if (world.isClient)
            return TypedActionResult.pass(user.getStackInHand(hand))

        if (!user.abilities.creativeMode)
            user.getStackInHand(hand).decrement(1)

        user.customDamage(SUBSTANCE_CONCOCTION, Float.MAX_VALUE)

        return TypedActionResult.consume(user.getStackInHand(hand))
    }
}
