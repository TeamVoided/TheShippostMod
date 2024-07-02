package org.teamvoided.shippost.data.gen.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement.Builder
import net.minecraft.advancement.AdvancementHolder
import net.minecraft.advancement.AdvancementRewards
import net.minecraft.advancement.AdvancementType
import net.minecraft.advancement.criterion.InventoryChangedCriterionTrigger
import net.minecraft.advancement.criterion.LocationCriterionTrigger
import net.minecraft.registry.HolderLookup
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.teamvoided.shippost.TheShipPostMod.MODID
import org.teamvoided.shippost.TheShipPostMod.id
import org.teamvoided.shippost.init.SpBlocks
import org.teamvoided.shippost.init.SpItems
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AdvancementProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricAdvancementProvider(o, r) {



    override fun generateAdvancement(provider: HolderLookup.Provider, c: Consumer<AdvancementHolder>?) {
        val root = Builder.create()
            .display(
                SpItems.SKELEON,
                advLang("root.title"),
                advLang("root.description"),
                Identifier.ofDefault("textures/gui/advancements/backgrounds/stone.png"),
                AdvancementType.TASK,
                false,
                false,
                false
            )
            .putCriteria("tick", LocationCriterionTrigger.Conditions.createTick())
            .build(c, id("funny/root").toString())

        val swagHolder = Builder.create()
            .display(
                SpBlocks.SWAGGIEST_STAIRS,
                advLang("sawg.title"),
                advLang("sawg.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            )
            .parent(root)
            .rewards(AdvancementRewards.Builder().setExperience(100))
            .putCriteria("swaggy", InventoryChangedCriterionTrigger.Conditions.create(SpBlocks.SWAGGY_STAIRS))
            .putCriteria("swaggier", InventoryChangedCriterionTrigger.Conditions.create(SpBlocks.SWAGGIER_STAIRS))
            .putCriteria("swaggiest", InventoryChangedCriterionTrigger.Conditions.create(SpBlocks.SWAGGIEST_STAIRS))
            .build(c, id("funny/swag").toString())
    }
    companion object{
        fun advLang(key: String, vararg objects: String): MutableText {
            return Text.translatable("advancements.$MODID.funny.$key", *objects)
        }
    }
}
