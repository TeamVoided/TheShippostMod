package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder
import net.minecraft.recipe.book.RecipeCategory
import java.util.function.Consumer
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import org.teamvoided.shippost.TheShippostMod.getId
import org.teamvoided.shippost.registries.SpItems

class RecipeProvider(output: FabricDataOutput?) : FabricRecipeProvider(output) {

    override fun generate(exporter: Consumer<RecipeJsonProvider>) {
        craftingRecipes(exporter)
    }

    fun craftingRecipes(c: Consumer<RecipeJsonProvider>) {

        //Exmaple
        /*
               ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, SpBlocks.TEST_BLOCK)
                   .pattern("###")
                   .pattern("#$#")
                   .pattern("~~~")
                   .input('#', Items.BRICK)
                   .input('$', Blocks.FURNACE)
                   .input('~', Blocks.SMOOTH_STONE)
                   .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                   .criterion(hasItem(SpBlocks.TEST_BLOCK), conditionsFromItem(SpBlocks.TEST_BLOCK))
                   .offerTo(c, getId(SpBlocks.TEST_BLOCK))

               ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, SpItems.TEST)
                   .input(Items.STICK)
                   .input(Items.STICK)
                   .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                   .criterion(hasItem(SpItems.TEST), conditionsFromItem(SpItems.TEST))
                   .offerTo(c, getId(SpItems.TEST))
               */

        // REAl
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, SpItems.COPPER_SHORTSWORD)
            .pattern("#")
            .pattern("#")
            .pattern("I")
            .input('#', Items.COPPER_INGOT)
            .input('I', Items.STICK)
            .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
            .criterion(hasItem(SpItems.COPPER_SHORTSWORD), conditionsFromItem(SpItems.COPPER_SHORTSWORD))
            .offerTo(c, getId(SpItems.COPPER_SHORTSWORD))

        SmithingTransformRecipeJsonBuilder.create(
            Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
            Ingredient.ofItems(Items.STICK),
            Ingredient.ofItems(Items.NETHERITE_INGOT),
            RecipeCategory.MISC,
            SpItems.NETHERITE_STICK
        )
            .criterion(
                hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
            )
            .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
            .criterion(hasItem(SpItems.NETHERITE_STICK), conditionsFromItem(SpItems.NETHERITE_STICK))
            .offerTo(c, getId(SpItems.NETHERITE_STICK))
    }
}