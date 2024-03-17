package org.teamvoided.shippost.data.providers


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.util.Identifier
import org.apache.commons.lang3.text.WordUtils
import org.teamvoided.shippost.TheShipPostMod
import org.teamvoided.shippost.TheShipPostMod.gId
import org.teamvoided.shippost.init.SpItems.ITEM_LIST

class EnglishTranslationProvider(output: FabricDataOutput) : FabricLanguageProvider(output, "en_us") {
    override fun generateTranslations(gen: TranslationBuilder) {

        ITEM_LIST.forEach { gen.add(it.translationKey, genLang(it.item.gId)) }

        gen.add("death.attack.substance_concoction", "%s was kill by a strong brew")

        gen.add("item.${TheShipPostMod.MODID}.bible.tooltip_1", "A book that does nothing.")
        gen.add("item.${TheShipPostMod.MODID}.bible.tooltip_2", "What do you expect?")
        gen.add("item.${TheShipPostMod.MODID}.bible.tooltip_3", "God isn't real!")
    }
    private fun genLang(identifier: Identifier): String = WordUtils.capitalize(identifier.path.replace("_", " "))
}