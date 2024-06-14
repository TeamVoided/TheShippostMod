package org.teamvoided.shippost.config

import net.minecraft.item.Items
import org.teamvoided.shippost.init.SpItems

object StickableConfig {
    val STICKABLE = listOf(
        Items.STICK,
        Items.END_ROD,
        Items.BONE,
        Items.DEBUG_STICK,
        SpItems.NETHERITE_STICK,
    )
    val STICKABLE_EXPLOSIVE = listOf(Items.FIREWORK_ROCKET)
    val STICKABLE_FLAMMABLE = listOf(Items.BLAZE_ROD)

    val flammableLength = 100
}
