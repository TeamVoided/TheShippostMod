package org.teamvoided.shippost.data.providers


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.util.Identifier
import org.apache.commons.lang3.text.WordUtils
import org.teamvoided.shippost.TheShippostMod
import org.teamvoided.shippost.init.SpItems.ITEM_LIST
import org.teamvoided.voidlib.core.gId

class EnglishTranslationProvider(output: FabricDataOutput) : FabricLanguageProvider(output, "en_us") {
    override fun generateTranslations(build: TranslationBuilder) {

        ITEM_LIST.forEach { build.add(it.translationKey, genLang(it.item.gId)) }

        build.add("death.attack.substance_concoction", "%s was kill by a strong brew")

        build.add("item.${TheShippostMod.MODID}.bible.tooltip_1", "A book that does nothing.")
        build.add("item.${TheShippostMod.MODID}.bible.tooltip_2", "What do you expect?")
        build.add("item.${TheShippostMod.MODID}.bible.tooltip_3", "God isn't real!")
    }
    private fun genLang(identifier: Identifier): String = WordUtils.capitalize(identifier.path.replace("_", " "))
}