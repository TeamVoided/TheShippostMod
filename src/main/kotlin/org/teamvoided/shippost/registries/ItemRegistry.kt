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
    val set = FabricItemSettings()
    val TEST: Item = BoneItem(set)
    val PELVIS: Item = BoneItem(set)

    val SANS: Item = BoneItem(set)
    val SKELETON: Item = BoneItem(set)
    val SKELETON_INCOMPLETE: Item = BoneItem(set)

    fun init() {
        register("test", TEST)
        register("sans", SANS)
        register("skeleton", SKELETON)
        register("skeleton_incomplete", SKELETON_INCOMPLETE)
        for (bone in boneItems) register(bone, BoneItem(set))
        register("pelvis", PELVIS)
    }

    fun register(id: String, item: Item) {
        Registry.register(Registries.ITEM, id(id), item)
        ITEM_LIST.add(item.defaultStack)
    }


    val boneItems = listOf(
        "ear_bones",
        "cranium",
        "face",
        "part_of_face",
        "skull",
        "hand",
        "finger",
        "thumb",
        "hand_base",
        "foot",
        "toe",
        "foot_base",
        "leg",
        "arm",
        "spine",
        "spine_part",
        "ribcage",
        "half_ribcage",
        "quarter_ribcage",
    )
}