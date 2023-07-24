package org.teamvoided.shippost.registries

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.TheShippostMod.id
import org.teamvoided.shippost.items.BoneItem
import org.teamvoided.shippost.items.LegalSubstanceConcoction
import org.teamvoided.shippost.items.ToolMaterials
import java.util.*

@Suppress("unused")
object SpItems {
    val ITEM_LIST = LinkedList<ItemStack>()
    val set = FabricItemSettings().maxCount(64)

    val TEST: Item = register("test", BoneItem(set))
    val PELVIS: Item = register("pelvis", BoneItem(set))

    val SANS: Item = register("sans", BoneItem(set))
    val SKELETON: Item = register("skeleton", BoneItem(set))
    val SKELETON_INCOMPLETE: Item = register("skeleton_incomplete", BoneItem(set))

    //Bones
    val EAR_BONES: Item = register("ear_bones", BoneItem(set))
    val CRANIUM: Item = register("cranium", BoneItem(set))
    val FACE: Item = register("face", BoneItem(set))
    val PART_OF_FACE: Item = register("part_of_face", BoneItem(set))
    val SKULL: Item = register("skull", BoneItem(set))
    val HAND: Item = register("hand", BoneItem(set))
    val FINGER: Item = register("finger", BoneItem(set))
    val THUMB: Item = register("thumb", BoneItem(set))
    val HAND_BASE: Item = register("hand_base", BoneItem(set))
    val FOOT: Item = register("foot", BoneItem(set))
    val TOE: Item = register("toe", BoneItem(set))
    val FOOT_BASE: Item = register("foot_base", BoneItem(set))
    val LEG: Item = register("leg", BoneItem(set))
    val ARM: Item = register("arm", BoneItem(set))
    val SPINE: Item = register("spine", BoneItem(set))
    val SPINE_PART: Item = register("spine_part", BoneItem(set))
    val RIBCAGE: Item = register("ribcage", BoneItem(set))
    val HALF_RIBCAGE: Item = register("half_ribcage", BoneItem(set))
    val QUARTER_RIBCAGE: Item = register("quarter_ribcage", BoneItem(set))

    val NETHERITE_STICK: Item = register("netherite_stick", Item(set))

    val LEGAL_SUBSTANCE: Item = register("legal_substance", Item(set))
    val LEGAL_SUBSTANCE_TWO: Item = register("legal_substance_two", Item(set))
    val LEGAL_SUBSTANCE_THREE: Item = register("legal_substance_three", Item(set))

    val LEGAL_SUBSTANCE_CONCOCTION: Item = register("legal_substance_concoction", LegalSubstanceConcoction(set))


    //NON Stackable
    val COPPER_SHORTSWORD: Item =
        register("copper_shortsword", SwordItem(ToolMaterials.COPPER_MATERIAL, 3, -2.4f, FabricItemSettings()))


    fun init() {
    }

    fun register(id: String, item: Item): Item {
        ITEM_LIST.add(item.defaultStack)
        return Registry.register(Registries.ITEM, id(id), item)
    }


}