package org.teamvoided.shippost.modules

import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.minecraft.entity.EntityType
import net.minecraft.loot.LootPool
import net.minecraft.loot.entry.LootTableEntry
import net.minecraft.util.Identifier
import org.teamvoided.shippost.TheShippostMod.id
import java.util.function.Consumer

object BoneInjection {
    private val TWO_HUNDRED_BONES = id("inject/two_hundred_six_bones")
    fun init() {
        LootTableEvents.MODIFY.register { _, _, id, supplier, _ ->
            lootLoad(id, supplier::pool)
        }
    }

    private fun lootLoad(id: Identifier, addPool: Consumer<in LootPool.Builder>) {
        if (id == EntityType.SKELETON.lootTableId)
            addPool.accept(LootPool.builder().with(LootTableEntry.builder(TWO_HUNDRED_BONES)))

    }
}