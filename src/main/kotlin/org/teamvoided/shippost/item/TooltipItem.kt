package org.teamvoided.shippost.item

import net.minecraft.client.item.TooltipConfig
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text

typealias AddTooltip = (stack: ItemStack?, itemContext: Item.TooltipContext?, tooltip: MutableList<Text>?, config: TooltipConfig?) -> Unit

class TooltipItem(val addTooltip: AddTooltip, settings: Settings) : Item(settings) {
    constructor(addTooltip: AddTooltip) : this(addTooltip, Settings())

    override fun appendTooltip(
        stack: ItemStack?, context: TooltipContext?, tooltip: MutableList<Text>?, config: TooltipConfig?
    ) {
        super.appendTooltip(stack, context, tooltip, config)
        addTooltip(stack, context, tooltip, config)
    }
}
