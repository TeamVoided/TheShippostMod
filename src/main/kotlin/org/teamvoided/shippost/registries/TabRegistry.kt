package org.teamvoided.shippost.registries

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import org.teamvoided.shippost.TheShippostMod.id

object TabRegistry {
    val SHIPPOST_TAB = register("shippost_tab")

    fun init() {
        Registry.register(
            Registries.ITEM_GROUP,
            SHIPPOST_TAB,
            FabricItemGroup.builder()
                .icon { ItemRegistry.TEST.defaultStack }
                .displayName(Text.of("Your mother+"))
                .entries { displayContext, entries ->
                    entries.addAll(ItemRegistry.ITEM_LIST)
                }.build()
        )
    }

    private fun register(name: String): RegistryKey<ItemGroup> = RegistryKey.of(RegistryKeys.ITEM_GROUP, id(name))

}