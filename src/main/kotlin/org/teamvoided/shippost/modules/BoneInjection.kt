package org.teamvoided.shippost.modules

import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.minecraft.entity.EntityType
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.LootTableEntry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import org.teamvoided.shippost.TheShipPostMod.id
import java.util.function.Consumer

object BoneInjection {
    private val TWO_HUNDRED_BONES = RegistryKey.of(RegistryKeys.LOOT_TABLE, id("inject/two_hundred_six_bones"))
    fun init() {
        LootTableEvents.MODIFY.register { id, supplier, _ -> lootLoad(id, supplier::pool) }
    }

    private fun lootLoad(id: RegistryKey<LootTable>, addPool: Consumer<in LootPool.Builder>) {
        if (id == EntityType.SKELETON.lootTableId)
            addPool.accept(LootPool.builder().with(LootTableEntry.method_428(TWO_HUNDRED_BONES)))
    }
}
