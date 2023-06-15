package org.teamvoided.shippost.registries

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.BoneItem
import org.teamvoided.shippost.TheShippostMod.id
import java.util.*

object ItemRegistry {
    val ITEM_LIST = LinkedList<ItemStack>()

    val TEST: Item = BoneItem(FabricItemSettings())
    fun init() {
        registerItem("test", TEST)
    }

    fun registerItem(id: String, item: Item) {
        Registry.register(Registries.ITEM, id(id), item)
        ITEM_LIST.add(item.defaultStack)
    }
}