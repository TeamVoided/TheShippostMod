package org.teamvoided.shippost.registries

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.items.BoneItem
import org.teamvoided.shippost.TheShippostMod.id
import java.util.*

object ItemRegistry {
    val ITEM_LIST = LinkedList<ItemStack>()

    val TEST: Item = BoneItem(FabricItemSettings())
    val SANS: Item = BoneItem(FabricItemSettings())
    val SKELETON: Item = BoneItem(FabricItemSettings())
    val SKELETON_INCOMPLETE: Item = BoneItem(FabricItemSettings())

    fun init() {
        register("test", TEST)
        register("sans", SANS)
        register("skeleton", SKELETON)
        register("skeleton_incomplete", SKELETON_INCOMPLETE)
    }

    fun register(id: String, item: Item) {
        Registry.register(Registries.ITEM, id(id), item)
        ITEM_LIST.add(item.defaultStack)
    }
}