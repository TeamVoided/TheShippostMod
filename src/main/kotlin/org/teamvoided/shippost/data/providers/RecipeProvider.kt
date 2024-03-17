package org.teamvoided.shippost.data.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.VanillaRecipesProvider
import net.minecraft.data.server.recipe.*
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeCategory
import org.teamvoided.shippost.TheShipPostMod.gId
import org.teamvoided.shippost.init.SpBlocks
import org.teamvoided.shippost.init.SpItems

class RecipeProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {

    override fun generateRecipes(re: RecipeExporter) {
        craftingRecipes(re)
        smelting(re)
        smithingRecipes(re)
        stonecuttingRecipes(re)
    }

    private fun craftingRecipes(c: RecipeExporter) {

        //Example
        /*
            //SHAPED
               ShapedRecipeJsonFactory.create(RecipeCategory.DECORATIONS, SpBlocks.TEST_BLOCK)
                   .pattern("###")
                   .pattern("#$#")
                   .pattern("~~~")
                   .ingredient('#', Items.BRICK)
                   .ingredient('$', Blocks.FURNACE)
                   .ingredient('~', Blocks.SMOOTH_STONE)
                   .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                   .criterion(hasItem(SpBlocks.TEST_BLOCK), conditionsFromItem(SpBlocks.TEST_BLOCK))
                   .offerTo(c, SpBlocks.TEST_BLOCK.gId)

            //SHAPELESS
               ShapelessRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.TEST)
                   .ingredient(Items.STICK)
                   .ingredient(Items.STICK)
                   .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                   .criterion(hasItem(SpItems.TEST), conditionsFromItem(SpItems.TEST))
                   .offerTo(c, SpItems.TEST.gId)
               */

        // REAl
        ShapedRecipeJsonFactory.create(RecipeCategory.COMBAT, SpItems.COPPER_SHORTSWORD)
            .pattern("#")
            .pattern("#")
            .pattern("I")
            .ingredient('#', Items.COPPER_INGOT)
            .ingredient('I', Items.STICK)
            .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
            .criterion(hasItem(SpItems.COPPER_SHORTSWORD), conditionsFromItem(SpItems.COPPER_SHORTSWORD))
            .offerTo(c, SpItems.COPPER_SHORTSWORD.gId)

        ShapelessRecipeJsonFactory.create(RecipeCategory.MISC, SpItems.LEGAL_SUBSTANCE_CONCOCTION)
            .ingredient(SpItems.LEGAL_SUBSTANCE)
            .ingredient(SpItems.LEGAL_SUBSTANCE_TWO)
            .ingredient(SpItems.LEGAL_SUBSTANCE_THREE)
            .criterion(hasItem(SpItems.LEGAL_SUBSTANCE), conditionsFromItem(SpItems.LEGAL_SUBSTANCE))
            .criterion(hasItem(SpItems.LEGAL_SUBSTANCE_TWO), conditionsFromItem(SpItems.LEGAL_SUBSTANCE_TWO))
            .criterion(hasItem(SpItems.LEGAL_SUBSTANCE_THREE), conditionsFromItem(SpItems.LEGAL_SUBSTANCE_THREE))
            .criterion(
                hasItem(SpItems.LEGAL_SUBSTANCE_CONCOCTION),
                conditionsFromItem(SpItems.LEGAL_SUBSTANCE_CONCOCTION)
            )
            .offerTo(c, SpItems.LEGAL_SUBSTANCE_CONCOCTION.gId)

        // SKELET TIME
        skelet(c)
        // NO MORE SKELET
        ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, SpBlocks.SWAGGIEST_STAIRS, 4)
            .pattern("B  ")
            .pattern("BB ")
            .pattern("BBB")
            .ingCri('B', Items.NETHERITE_BLOCK)
            .crit(SpBlocks.SWAGGIEST_STAIRS)
            .offerTo(c, SpBlocks.SWAGGIEST_STAIRS.gId)
    }

    private fun smelting(c: RecipeExporter) {
        CookingRecipeJsonFactory.createSmelting(
            Ingredient.ofItems(SpItems.SKELETON), RecipeCategory.BUILDING_BLOCKS,
            SpItems.WITHER_SKELETON.asItem(), 5f, 200
        )
            .criterion(hasItem(SpItems.WITHER_SKELETON), conditionsFromItem(SpItems.WITHER_SKELETON))
            .offerTo(c)

    }

    private fun smithingRecipes(c: RecipeExporter) {
        TransformSmithingRecipeJsonFactory.create(
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
            .offerTo(c, SpItems.NETHERITE_STICK.gId)
    }

    private fun stonecuttingRecipes(c: RecipeExporter) {
        VanillaRecipesProvider
            .createStonecuttingRecipe(c, RecipeCategory.REDSTONE, SpBlocks.SWAGGIEST_STAIRS, Items.NETHERITE_BLOCK)
    }

    fun ShapedRecipeJsonFactory.ingCri(c: Char, item: ItemConvertible): ShapedRecipeJsonFactory {
        return this.ingredient(c, item).crit(item)
    }

    fun ShapedRecipeJsonFactory.crit(item: ItemConvertible): ShapedRecipeJsonFactory {
        return this.criterion(hasItem(item), conditionsFromItem(item))
    }

    fun skelet(c: RecipeExporter) {
        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SANS)
            .pattern("X")
            .pattern("Y")
            .pattern("Z")
            .ingredient('X', SpItems.SKELETON)
            .ingredient('Y', Items.DIAMOND_CHESTPLATE)
            .ingredient('Z', Items.SOUL_LANTERN)
            .criterion(hasItem(SpItems.SKELETON), conditionsFromItem(SpItems.SKELETON))
            .criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
            .offerTo(c, SpItems.SANS.gId)

        ShapelessRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SKELETON)
            .ingredient(SpItems.SKELETON_INCOMPLETE)
            .ingredient(Items.BONE)
            .criterion(hasItem(SpItems.SKELETON_INCOMPLETE), conditionsFromItem(SpItems.SKELETON_INCOMPLETE))
            .offerTo(c, SpItems.SKELETON.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SKELETON_INCOMPLETE)
            .pattern(" S ")
            .pattern("ATA")
            .pattern("L L")
            .ingCri('S', SpItems.SKULL)
            .ingCri('A', SpItems.ARM)
            .ingCri('L', SpItems.LEG)
            .ingCri('T', SpItems.TORSO)
            .crit(SpItems.SKELETON_INCOMPLETE)
            .offerTo(c, SpItems.SKELETON_INCOMPLETE.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SKULL)
            .pattern("ECE")
            .pattern(" F ")
            .ingCri('E', SpItems.EAR_BONES)
            .ingCri('C', SpItems.CRANIUM)
            .ingCri('F', SpItems.FACE)
            .crit(SpItems.SKULL)
            .offerTo(c, SpItems.SKULL.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.ARM)
            .pattern("BBB")
            .pattern("B H")
            .pattern("B  ")
            .ingCri('H', SpItems.HAND)
            .ingCri('B', Items.BONE)
            .crit(SpItems.ARM)
            .offerTo(c, SpItems.ARM.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.LEG)
            .pattern("BBB")
            .pattern("BBB")
            .pattern("BBF")
            .ingCri('F', SpItems.FOOT)
            .ingCri('B', Items.BONE)
            .crit(SpItems.LEG)
            .offerTo(c, SpItems.LEG.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.TORSO)
            .pattern("R")
            .pattern("S")
            .pattern("P")
            .ingCri('R', SpItems.RIBCAGE)
            .ingCri('S', SpItems.SPINE)
            .ingCri('P', SpItems.PELVIS)
            .crit(SpItems.TORSO)
            .offerTo(c, SpItems.TORSO.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FACE)
            .pattern("FFF")
            .ingCri('F', SpItems.FACE_PART)
            .crit(SpItems.FACE)
            .offerTo(c, SpItems.FACE.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.HAND)
            .pattern("FFF")
            .pattern("FHT")
            .ingCri('F', SpItems.FINGER)
            .ingCri('T', SpItems.THUMB)
            .ingCri('H', SpItems.HAND_BASE)
            .crit(SpItems.HAND)
            .offerTo(c, SpItems.HAND.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FOOT)
            .pattern("TTT")
            .pattern("TBT")
            .ingCri('T', SpItems.TOE)
            .ingCri('B', SpItems.FOOT_BASE)
            .crit(SpItems.FOOT)
            .offerTo(c, SpItems.FOOT.gId)


        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SPINE)
            .pattern("SS ")
            .pattern(" S ")
            .pattern(" SS")
            .ingCri('S', SpItems.SPINE_PART)
            .crit(SpItems.SPINE)
            .offerTo(c, SpItems.SPINE.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.RIBCAGE)
            .pattern("RBR")
            .ingCri('R', SpItems.HALF_RIBCAGE)
            .ingCri('B', Items.BONE)
            .crit(SpItems.RIBCAGE)
            .offerTo(c, SpItems.RIBCAGE.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.HALF_RIBCAGE)
            .pattern("R")
            .pattern("B")
            .pattern("R")
            .ingCri('R', SpItems.QUARTER_RIBCAGE)
            .ingCri('B', Items.BONE)
            .crit(SpItems.HALF_RIBCAGE)
            .offerTo(c, SpItems.HALF_RIBCAGE.gId)

        ShapelessRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.PELVIS)
            .ingredient(Items.BONE)
            .ingredient(Items.BONE)
            .criterion(hasItem(SpItems.PELVIS), conditionsFromItem(SpItems.PELVIS))
            .offerTo(c, SpItems.PELVIS.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.EAR_BONES)
            .pattern(" B ")
            .pattern("B  ")
            .pattern(" B ")
            .ingCri('B', Items.BONE)
            .crit(SpItems.EAR_BONES)
            .offerTo(c, SpItems.EAR_BONES.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.THUMB)
            .pattern("B")
            .pattern("B")
            .pattern("B")
            .ingCri('B', Items.BONE)
            .crit(SpItems.THUMB)
            .offerTo(c, SpItems.THUMB.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FINGER)
            .pattern("BB ")
            .pattern("B  ")
            .pattern("B  ")
            .ingCri('B', Items.BONE)
            .crit(SpItems.FINGER)
            .offerTo(c, SpItems.FINGER.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.TOE)
            .pattern("B  ")
            .pattern("B  ")
            .pattern("BB ")
            .ingCri('B', Items.BONE)
            .crit(SpItems.TOE)
            .offerTo(c, SpItems.TOE.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FACE_PART)
            .pattern("B B")
            .pattern("BBB")
            .ingCri('B', Items.BONE)
            .crit(SpItems.FACE_PART)
            .offerTo(c, SpItems.FACE_PART.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SPINE_PART)
            .pattern("BB ")
            .pattern(" B ")
            .pattern(" BB")
            .ingCri('B', Items.BONE)
            .crit(SpItems.SPINE_PART)
            .offerTo(c, SpItems.SPINE_PART.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.QUARTER_RIBCAGE)
            .pattern("BBB")
            .pattern("BBB")
            .ingCri('B', Items.BONE)
            .crit(SpItems.QUARTER_RIBCAGE)
            .offerTo(c, SpItems.QUARTER_RIBCAGE.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FOOT_BASE)
            .pattern("BB")
            .pattern("BB")
            .pattern("BB")
            .ingCri('B', Items.BONE)
            .crit(SpItems.FOOT_BASE)
            .offerTo(c, SpItems.FOOT_BASE.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.HAND_BASE)
            .pattern("B B")
            .pattern("BBB")
            .pattern("BBB")
            .ingCri('B', Items.BONE)
            .crit(SpItems.HAND_BASE)
            .offerTo(c, SpItems.HAND_BASE.gId)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.CRANIUM)
            .pattern("BBB")
            .pattern("B B")
            .pattern("BBB")
            .ingCri('B', Items.BONE)
            .crit(SpItems.CRANIUM)
            .offerTo(c, SpItems.CRANIUM.gId)
    }
}