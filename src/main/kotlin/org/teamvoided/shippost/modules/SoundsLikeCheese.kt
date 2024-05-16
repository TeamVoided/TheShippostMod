package org.teamvoided.shippost.modules

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents
import net.minecraft.component.DataComponentTypes
import net.minecraft.item.FoodComponent
import net.minecraft.item.Items

object SoundsLikeCheese {
    val cheese = FoodComponent.Builder().hunger(4).saturation(2.5f).build()

    fun init() {
        DefaultItemComponentEvents.MODIFY.register { c ->
            c.modify(Items.BELL) { it.put(DataComponentTypes.FOOD, cheese) }
        }
    }
}