package org.teamvoided.shippost.data.providers


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.util.Identifier
import org.apache.commons.lang3.text.WordUtils
import org.teamvoided.shippost.TheShippostMod.getId
import org.teamvoided.shippost.registries.SpBlocks.BLOCK_LIST

class EnglishTranslationProvider(output: FabricDataOutput) : FabricLanguageProvider(output, "en_us") {
    override fun generateTranslations(build: TranslationBuilder) {
//        ITEM_LIST.forEach { build.add(it.translationKey, genLang(it)) }

        BLOCK_LIST.forEach {
            val x = genLang(getId(it))
            try {
                build.add(it.translationKey, x)
            } catch (e: Exception) {
                LOGGER.error("Error {}", e.toString())
            }
        }

    }
    private fun genLang(identifier: Identifier): String = WordUtils.capitalize(identifier.path.replace("_", " "))
}