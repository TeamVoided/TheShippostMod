package org.teamvoided.shippost.item

import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text

typealias AddTooltip = (stack: ItemStack?, itemContext: Item.C_rdhfmrgz?, tooltip: MutableList<Text>?, flags: TooltipContext?) -> Unit

class TooltipItem(val addTooltip: AddTooltip, settings: Settings) : Item(settings) {
    constructor(addTooltip: AddTooltip) : this(addTooltip, Settings())

    override fun appendTooltip(
        stack: ItemStack?, itemContext: C_rdhfmrgz?, tooltip: MutableList<Text>?, flags: TooltipContext?
    ) {
        super.appendTooltip(stack, itemContext, tooltip, flags)
        addTooltip(stack, itemContext, tooltip, flags)
    }
}
