package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.Advancement.*
import net.minecraft.advancement.AdvancementDisplay
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.LocationCriterion
import net.minecraft.advancement.criterion.OnKilledCriterion.Conditions.createPlayerKilledEntity
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.item.Items
import net.minecraft.predicate.entity.EntityPredicate
import net.minecraft.predicate.entity.TypeSpecificPredicate
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.teamvoided.shippost.TheShipPostMod.LOG
import org.teamvoided.shippost.TheShipPostMod.id
import java.util.function.Consumer

class AdvancementProvider(output: FabricDataOutput?) : FabricAdvancementProvider(output) {
    override fun generateAdvancement(c: Consumer<Advancement>?) {

        LOG.info("Gen Advancements")

        val root = Task.create()
            .display(
                Blocks.ORANGE_BANNER,
                Text.translatable("advancements.story.root.title"),
                Text.translatable("advancements.story.root.description"),
                Identifier("textures/gui/advancements/backgrounds/stone.png"),
                AdvancementFrame.TASK,
                false,
                false,
                false
            )
            .criterion("tick", LocationCriterion.Conditions.createTick()).build(c, id("shippost/root").toString())
        fatalStrike = Task.create().display(
            AdvancementDisplay(
                Items.DIAMOND_SWORD.defaultStack,
                Text.translatable("Ded"),
                Text.translatable("RubyFirefly is now ded"),
                null,
                AdvancementFrame.CHALLENGE,
                true,
                true,
                false
            )
        ).criterion(
            "kill_ruby",
            createPlayerKilledEntity(
                EntityPredicate.Builder.create().type(EntityType.PLAYER)
                    .typeSpecific(TypeSpecificPredicate.ANY)
            )
        ).parent(root).build(c, id("shippost/kill_ruby").toString())
    }
    companion object {
        var fatalStrike :Advancement? = null
    }
}