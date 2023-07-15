package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.block.Blocks
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.recipe.book.RecipeCategory
import java.util.function.Consumer
import net.minecraft.item.Items
import org.teamvoided.shippost.TheShippostMod.getId
import org.teamvoided.shippost.registries.ShoppostBlocks
import org.teamvoided.shippost.registries.ShoppostItems

class RecipeProvider(output: FabricDataOutput?) : FabricRecipeProvider(output) {

    override fun generate(exporter: Consumer<RecipeJsonProvider>) {
        craftingRecipes(exporter)
    }

    fun craftingRecipes(c: Consumer<RecipeJsonProvider>) {


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ShoppostBlocks.TEST_BLOCK)
            .pattern("###")
            .pattern("#$#")
            .pattern("~~~")
            .input('#', Items.BRICK)
            .input('$', Blocks.FURNACE)
            .input('~', Blocks.SMOOTH_STONE)
            .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
            .criterion(hasItem(ShoppostBlocks.TEST_BLOCK), conditionsFromItem(ShoppostBlocks.TEST_BLOCK))
            .offerTo(c, getId(ShoppostBlocks.TEST_BLOCK))


        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ShoppostItems.TEST)
            .input(Items.STICK)
            .input(Items.STICK)
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .criterion(hasItem(ShoppostItems.TEST), conditionsFromItem(ShoppostItems.TEST))
            .offerTo(c, getId(ShoppostItems.TEST))
    }
}