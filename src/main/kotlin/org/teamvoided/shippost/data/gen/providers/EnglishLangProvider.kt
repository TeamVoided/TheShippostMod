package org.teamvoided.shippost.data.gen.providers


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.util.Identifier
import org.apache.commons.lang3.text.WordUtils
import org.teamvoided.shippost.TheShipPostMod
import org.teamvoided.shippost.TheShipPostMod.gId
import org.teamvoided.shippost.data.gen.providers.AdvancementProvider.Companion.advLang
import org.teamvoided.shippost.init.SpItems.ITEM_LIST
import java.util.concurrent.CompletableFuture

class EnglishLangProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricLanguageProvider(o, "en_us", r) {
    override fun generateTranslations(priovider: HolderLookup.Provider, gen: TranslationBuilder) {

        ITEM_LIST.forEach { gen.add(it.translationKey, genLang(it.item.gId)) }

        gen.add("death.attack.substance_concoction", "%s was kill by a strong brew")

        gen.add("item.${TheShipPostMod.MODID}.bible.tooltip_1", "A book that does nothing.")
        gen.add("item.${TheShipPostMod.MODID}.bible.tooltip_2", "What do you expect?")
        gen.add("item.${TheShipPostMod.MODID}.bible.tooltip_3", "God isn't real!")

        gen.add(advLang("root.title").string, "The ShipPost mod")
        gen.add(advLang("root.description").string, "A mod that adds a ship post to the world.")
        gen.add(advLang("sawg.title").string, "The Swag Master")
        gen.add(advLang("sawg.description").string, "Collect all 3 swaggy stairs.")
    }

    private fun genLang(identifier: Identifier): String = WordUtils.capitalize(identifier.path.replace("_", " "))
}
