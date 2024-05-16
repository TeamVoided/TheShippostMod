package org.teamvoided.shippost.init

import net.minecraft.entity.EntityType
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import org.teamvoided.shippost.TheShipPostMod.MODID
import org.teamvoided.shippost.TheShipPostMod.id
import org.teamvoided.shippost.item.*
import java.util.*

@Suppress("unused")
object SpItems {
    fun init() {}

    val ITEM_LIST = LinkedList<ItemStack>()
    val itemsToModel = LinkedList<Item>()
    fun set() = Item.Settings()

    val TEST: Item = register("test", BoneItem(set()))

    val SANS: Item = register("sans", BoneItem(set()))
    val SKELETON: Item = register("skeleton", BoneItem(set()))
    val WITHER_SKELETON: Item =
        register("wither_skeleton", SpawnEggItem(EntityType.WITHER_SKELETON, 0x000000, 0x000000, set()))
    val SKELETON_INCOMPLETE: Item =
        register("skeleton_incomplete", SpawnEggItem(EntityType.SKELETON, 0xffffff, 0xffffff, set()))

    //Bones
    val SKULL: Item = register("skull", BoneItem(set()))
    val EAR_BONES: Item = register("ear_bones", BoneItem(set()))
    val CRANIUM: Item = register("cranium", BoneItem(set()))
    val FACE: Item = register("face", BoneItem(set()))
    val FACE_PART: Item = register("part_of_face", BoneItem(set()))

    val ARM: Item = register("arm", BoneItem(set()))
    val HAND: Item = register("hand", BoneItem(set()))
    val FINGER: Item = register("finger", BoneItem(set()))
    val THUMB: Item = register("thumb", BoneItem(set()))
    val HAND_BASE: Item = register("hand_base", BoneItem(set()))

    val LEG: Item = register("leg", BoneItem(set()))
    val FOOT: Item = register("foot", BoneItem(set()))
    val TOE: Item = register("toe", BoneItem(set()))
    val FOOT_BASE: Item = register("foot_base", BoneItem(set()))

    val TORSO: Item = register("torso", BoneItem(set()))
    val SPINE: Item = register("spine", BoneItem(set()))
    val SPINE_PART: Item = register("spine_part", BoneItem(set()))
    val PELVIS: Item = register("pelvis", PelvisItem(set()))
    val RIBCAGE: Item = register("ribcage", BoneItem(set()))
    val HALF_RIBCAGE: Item = register("half_ribcage", BoneItem(set()))
    val QUARTER_RIBCAGE: Item = register("quarter_ribcage", BoneItem(set()))

    val NETHERITE_STICK: Item = register("netherite_stick", Item(set()))

    val LEGAL_SUBSTANCE: Item = register("legal_substance", Item(set()))
    val LEGAL_SUBSTANCE_TWO: Item = register("legal_substance_two", Item(set()))
    val LEGAL_SUBSTANCE_THREE: Item = register("legal_substance_three", Item(set()))

    val LEGAL_SUBSTANCE_CONCOCTION: Item = register("legal_substance_concoction", LegalSubstanceConcoction(set()))


    val BIBLE: Item = register("bible",
        TooltipItem { _, _, tooltip, _ ->
            tooltip.add(Text.translatable("item.$MODID.bible.tooltip_1").formatted(Formatting.GRAY))
            tooltip.add(Text.translatable("item.$MODID.bible.tooltip_2").formatted(Formatting.GRAY))
            tooltip.add(Text.translatable("item.$MODID.bible.tooltip_3").formatted(Formatting.GRAY))
        })


    //NON Stackable
    val COPPER_SHORTSWORD: Item = register(
        "copper_shortsword", SwordItem(
            SPToolMaterials.COPPER_MATERIAL, Item.Settings()
                .attributeModifiersComponent(SwordItem.createAttributes(SPToolMaterials.COPPER_MATERIAL, 2, -2f))
        )
    )
    val NETHERITE_COPPER_SHORTSWORD: Item = register(
        "netherite_copper_shortsword", SwordItem(
            ToolMaterials.NETHERITE, Item.Settings().fireproof()
                .attributeModifiersComponent(SwordItem.createAttributes(ToolMaterials.NETHERITE, 2, -2f))
        )
    )


    fun register(id: String, item: Item): Item {
        ITEM_LIST.add(item.defaultStack)
        itemsToModel.add(item)
        return Registry.register(Registries.ITEM, id(id), item)
    }
}
