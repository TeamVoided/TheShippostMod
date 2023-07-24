package org.teamvoided.shippost.items

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import org.teamvoided.shippost.registries.SpDamageTypes.SUBSTANCE_CONCOCTION
import org.teamvoided.shippost.registries.SpDamageTypes.create

class LegalSubstanceConcoction(settings: Settings) : Item(settings) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand))
        }
        if (!user.isCreative) user.getStackInHand(hand).decrement(1)
        user.damage(create(SUBSTANCE_CONCOCTION, user), Float.MAX_VALUE)

        return TypedActionResult.consume(user.getStackInHand(hand))
    }
}
