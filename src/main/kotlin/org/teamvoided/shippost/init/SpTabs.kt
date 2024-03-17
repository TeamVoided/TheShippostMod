package org.teamvoided.shippost.init

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import org.teamvoided.shippost.TheShipPostMod.id

object SpTabs {
    val SHIPPOST_TAB = register("shippost_tab")

    fun init() {
        Registry.register(
            Registries.ITEM_GROUP,
            SHIPPOST_TAB,
            FabricItemGroup.builder()
                .icon { SpItems.TEST.defaultStack }
                .name(Text.of("Your mother+"))
                .entries { _, entries ->
                    entries.addStacks(SpItems.ITEM_LIST.shuffled())
                }.build()
        )
    }

    private fun register(name: String): RegistryKey<ItemGroup> = RegistryKey.of(RegistryKeys.ITEM_GROUP, id(name))

}