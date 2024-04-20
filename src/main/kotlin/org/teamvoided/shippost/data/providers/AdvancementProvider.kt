package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.Advancement.*
import net.minecraft.advancement.AdvancementHolder
import net.minecraft.advancement.AdvancementType
import net.minecraft.advancement.criterion.LocationCriterionTrigger
import net.minecraft.block.Blocks
import net.minecraft.registry.HolderLookup
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.teamvoided.shippost.TheShipPostMod.LOG
import org.teamvoided.shippost.TheShipPostMod.id
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AdvancementProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricAdvancementProvider(o, r) {

    override fun generateAdvancement(provider: HolderLookup.Provider, c: Consumer<AdvancementHolder>?) {

        LOG.info("Gen Advancements")

        val root = Builder.create()
            .display(
                Blocks.ORANGE_BANNER,
                Text.translatable("advancements.story.root.title"),
                Text.translatable("advancements.story.root.description"),
                Identifier("textures/gui/advancements/backgrounds/stone.png"),
                AdvancementType.TASK,
                false,
                false,
                false
            )
            .putCriteria("tick", LocationCriterionTrigger.Conditions.createTick())
            .build(c, id("shippost/root").toString())
//        Builder.create().display(
//            AdvancementDisplay(
//                Items.DIAMOND_SWORD.defaultStack,
//                Text.translatable("Ded"),
//                Text.translatable("RubyFirefly is now ded"),
//                null,
//                AdvancementComponent.CHALLENGE,
//                true,
//                true,
//                false
//            )
//        )
//            .putCriteria(
//            "none",
//           ImpossibleCriterionTrigger.Conditions.method_54938()
//        ).parent(root).build(c, id("shippost/kill_ruby").toString())

//        Builder.create().parent(AdvancementHolder(id("test"), null)).method_697(
//            Blocks.DRAGON_EGG,
//            Text.translatable("advancements.end.dragon_egg.title"),
//            Text.translatable("advancements.end.dragon_egg.description"),
//            null as Identifier?,
//            AdvancementComponent.GOAL,
//            true,
//            true,
//            false
//        ).putCriteria(
//            "dragon_egg",
//            InventoryChangedCriterionTrigger.Conditions.create(*arrayOf<ItemConvertible>(Blocks.DRAGON_EGG))
//        ).build(advancementConsumer, "end/dragon_egg")
    }

    companion object {
        var fatalStrike: Advancement? = null
    }

}
