package org.teamvoided.shippost.data.tag

import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import org.teamvoided.shippost.TheShipPostMod.id

object SpItemTags {
    fun create(id: String): TagKey<Item> = TagKey.of(RegistryKeys.ITEM, id(id))
}
