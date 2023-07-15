package org.teamvoided.shippost.registries

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.TheShippostMod.id
import org.teamvoided.shippost.items.BoneItem
import org.teamvoided.shippost.items.ToolMaterials
import java.util.*

@Suppress("unused")
object ShoppostItems {
    val ITEM_LIST = LinkedList<ItemStack>()
    val set = FabricItemSettings()
    val TEST: Item = register("test", BoneItem(set))
    val PELVIS: Item = register("pelvis", BoneItem(set))

    val SANS: Item = register("sans", BoneItem(set))
    val SKELETON: Item = register("skeleton", BoneItem(set))
    val SKELETON_INCOMPLETE: Item = register("skeleton_incomplete", BoneItem(set))
    val BONE_LIST = LinkedList<Item>()

    val COPPER_SHORTSWORD: Item =
        register("copper_shortsword", SwordItem(ToolMaterials.COPPER_MATERIAL, 3, -2.4f, set))


    fun init() {
        for (bone in boneItems) BONE_LIST.add(register(bone, BoneItem(set)))

//        register("test", TEST)
//        register("sans", SANS)
//        register("skeleton", SKELETON)
//        register("skeleton_incomplete", SKELETON_INCOMPLETE)
//        register("pelvis", PELVIS)
    }

    fun register(id: String, item: Item): Item {
        ITEM_LIST.add(item.defaultStack)
        return Registry.register(Registries.ITEM, id(id), item)
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