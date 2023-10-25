package org.teamvoided.shippost.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.World

class LoreItem(val addTooltip: (stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) -> Unit,settings: FabricItemSettings) : Item(settings) {
    constructor(addTooltip: (stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) -> Unit): this(addTooltip,FabricItemSettings())


    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        addTooltip(stack, world, tooltip, context)
    }
}