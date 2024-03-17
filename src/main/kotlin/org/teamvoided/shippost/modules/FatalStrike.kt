package org.teamvoided.shippost.modules

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents
import net.minecraft.advancement.Advancement
import net.minecraft.server.network.ServerPlayerEntity
import org.teamvoided.shippost.data.providers.AdvancementProvider.Companion.fatalStrike

object FatalStrike {
    fun inti() {
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register{ server, killer, victim ->
           if (killer is ServerPlayerEntity){
//               println(killer.name)
//               println(killer.uuid)
               fatalStrike?.let { killer.grantAdvancement(it) }
           }
        }
    }

    private fun ServerPlayerEntity.grantAdvancement(advancement: Advancement){
//        val advancementProgress: AdvancementProgress = this.advancementTracker.getProgress(advancement)
//        if (advancementProgress.isDone) return
//
//        for (string in advancementProgress.unobtainedCriteria)
//            this.advancementTracker.grantCriterion(advancement, string)
    }
}