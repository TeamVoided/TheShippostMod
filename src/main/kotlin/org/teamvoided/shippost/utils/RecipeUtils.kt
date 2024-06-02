package org.teamvoided.shippost.utils

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider.conditionsFromItem
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider.hasItem
import net.minecraft.data.server.RecipesProvider
import net.minecraft.data.server.recipe.*
import net.minecraft.item.ItemConvertible
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeCategory
import net.minecraft.util.Identifier
import org.teamvoided.shippost.TheShipPostMod.gId

fun ShapedRecipeJsonFactory.ingredientCriterion(c: Char, item: ItemConvertible): ShapedRecipeJsonFactory {
    return this.ingredient(c, item).criterion(item)
}

fun ShapedRecipeJsonFactory.criterion(item: ItemConvertible): ShapedRecipeJsonFactory {
    return this.criterion(hasItem(item), conditionsFromItem(item))
}

fun ShapelessRecipeJsonFactory.ingredientCriterion(item: ItemConvertible): ShapelessRecipeJsonFactory {
    return this.ingredient(item).criterion(item)
}

fun ShapelessRecipeJsonFactory.criterion(item: ItemConvertible): ShapelessRecipeJsonFactory {
    return this.criterion(hasItem(item), conditionsFromItem(item))
}

fun TransformSmithingRecipeJsonFactory.criterion(item: ItemConvertible): TransformSmithingRecipeJsonFactory {
    return this.criterion(hasItem(item), conditionsFromItem(item))
}

fun CookingRecipeJsonFactory.criterion(item: ItemConvertible): CookingRecipeJsonFactory {
    return this.criterion(hasItem(item), conditionsFromItem(item))
}

fun RecipeExporter.stairs(ingredient: ItemConvertible, result: ItemConvertible, prefix: String = "") {
    ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, result, 4)
        .pattern("B  ")
        .pattern("BB ")
        .pattern("BBB")
        .ingredientCriterion('B', ingredient)
        .criterion(result)
        .offerTo(this, result.asItem().gId.withPrefix(prefix))
    this.customStonecutting(RecipeCategory.BUILDING_BLOCKS, result, ingredient, prefix)
}

fun RecipeExporter.cooking(
    ingredient: ItemConvertible,
    result: ItemConvertible,
    xp: Float, time: Int,
    prefix: String = ""
) {
    this.smelting(ingredient, result, xp, time, RecipeCategory.FOOD, prefix)
}

@Suppress("LongParameterList")
fun RecipeExporter.smelting(
    ingredient: ItemConvertible,
    result: ItemConvertible,
    xp: Float, time: Int,
    category: RecipeCategory,
    prefix: String = ""
) {
    CookingRecipeJsonFactory.createSmelting(ingredient.toIngredient(), category, result, xp, time)
        .criterion(ingredient)
        .criterion(result)
        .offerTo(this, result.asItem().gId.withPrefix(prefix))
}

fun RecipeExporter.customStonecutting(
    category: RecipeCategory, ingredient: ItemConvertible, result: ItemConvertible, prefix: String = "", count: Int = 1
) {
    val id = RecipesProvider.convertBetween(ingredient, result)
    SingleItemRecipeJsonFactory.createStonecuttingRecipe(
        result.toIngredient(), category, ingredient, count
    )
        .criterion(
            hasItem(result), conditionsFromItem(result)
        )
        .offerTo(this, Identifier("${id}_stonecutting").withPrefix(prefix))
}

fun ItemConvertible.toIngredient(): Ingredient = Ingredient.ofItems(this)
