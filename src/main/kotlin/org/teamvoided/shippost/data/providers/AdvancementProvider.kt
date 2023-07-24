package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.Advancement.*
import net.minecraft.advancement.AdvancementDisplay
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.OnKilledCriterion.Conditions.createPlayerKilledEntity
import net.minecraft.advancement.criterion.TickCriterion
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.item.Items
import net.minecraft.predicate.entity.EntityPredicate
import net.minecraft.predicate.entity.TypeSpecificPredicate
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.teamvoided.shippost.TheShippostMod.LOG
import org.teamvoided.shippost.TheShippostMod.id
import java.util.function.Consumer

class AdvancementProvider(output: FabricDataOutput?) : FabricAdvancementProvider(output) {
    override fun generateAdvancement(c: Consumer<Advancement>?) {

        LOG.info("ruins")
        val advancement = Builder.create()
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
            .criterion("tick", TickCriterion.Conditions.createTick())
            .build(c, id("shippost/root").toString())

        Builder.create().display(
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
        ).parent(advancement)
            .build(c, id("shippost/kill_ruby").toString())


    }

}