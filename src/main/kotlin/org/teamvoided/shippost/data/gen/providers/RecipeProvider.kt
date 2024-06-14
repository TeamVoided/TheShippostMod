package org.teamvoided.shippost.data.gen.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.block.Blocks
import net.minecraft.data.server.recipe.*
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeCategory
import net.minecraft.registry.HolderLookup
import org.teamvoided.shippost.TheShipPostMod.gId
import org.teamvoided.shippost.init.SpBlocks
import org.teamvoided.shippost.init.SpItems
import org.teamvoided.shippost.utils.*
import java.util.concurrent.CompletableFuture

class RecipeProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) : FabricRecipeProvider(o, r) {

    override fun generateRecipes(re: RecipeExporter) {
        craftingRecipes(re)
        smithingRecipes(re)

        // SKELET TIME
        skelet(re)
        // NO MORE SKELET
        stairs(re)
        jesseWeNeedToCook(re)
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

        ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, SpBlocks.SUS_CONCRETE, 2)
            .pattern("R")
            .pattern("C")
            .ingredientCriterion('R', Blocks.RED_CONCRETE)
            .ingredientCriterion('C', Blocks.CYAN_CONCRETE)
            .criterion(SpBlocks.SUS_CONCRETE)
            .offerTo(c, SpBlocks.SUS_CONCRETE.gId)

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

        TransformSmithingRecipeJsonFactory.create(
            Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
            Ingredient.ofItems(SpItems.COPPER_SHORTSWORD),
            Ingredient.ofItems(Items.NETHERITE_INGOT),
            RecipeCategory.MISC,
            SpItems.NETHERITE_COPPER_SHORTSWORD
        )
            .criterion(
                hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
            )
            .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
            .criterion(
                hasItem(SpItems.NETHERITE_COPPER_SHORTSWORD),
                conditionsFromItem(SpItems.NETHERITE_COPPER_SHORTSWORD)
            )
            .offerTo(c, SpItems.NETHERITE_COPPER_SHORTSWORD.gId)
    }

    private fun swagCrafting(c: RecipeExporter) {
        c.stairs(Blocks.EMERALD_BLOCK, SpBlocks.SWAGGY_STAIRS, SWAG_FOLDER)
        c.stairs(Blocks.DIAMOND_BLOCK, SpBlocks.SWAGGIER_STAIRS, SWAG_FOLDER)
        c.stairs(Blocks.NETHERITE_BLOCK, SpBlocks.SWAGGIEST_STAIRS, SWAG_FOLDER)


        TransformSmithingRecipeJsonFactory.create(
            Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE.toIngredient(),
            SpBlocks.SWAGGIER_STAIRS.toIngredient(),
            Items.NETHERITE_INGOT.toIngredient(),
            RecipeCategory.MISC, SpBlocks.SWAGGIEST_STAIRS.asItem()
        )
            .criterion(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
            .criterion(Items.NETHERITE_INGOT)
            .criterion(SpBlocks.SWAGGIEST_STAIRS)
            .offerTo(c, SpBlocks.SWAGGIEST_STAIRS.gId.withPrefix("smithing_").withPrefix(SWAG_FOLDER))
    }

    private fun stairs(c: RecipeExporter) {
        swagCrafting(c)
        c.stairs(Blocks.RED_CONCRETE, SpBlocks.RED_CONCRETE_STAIRS)
    }

    @Suppress("MagicNumber")
    private fun jesseWeNeedToCook(c: RecipeExporter) {
        c.cooking(Items.SUGAR_CANE, SpItems.LEGAL_SUBSTANCE, 5f, 200, LEGAL_FOLDER)
        CookingRecipeJsonFactory.create(
            Items.TORCHFLOWER.toIngredient(),
            RecipeCategory.FOOD,
            SpItems.LEGAL_SUBSTANCE_TWO,
            5f,
            200,
        )
            .criterion(Items.TORCHFLOWER)
            .criterion(SpItems.LEGAL_SUBSTANCE_TWO)
            .offerTo(c, SpItems.LEGAL_SUBSTANCE_TWO.gId.withPrefix(LEGAL_FOLDER))

        CookingRecipeJsonFactory.create(
            Items.POTION.toIngredient(),
            RecipeCategory.FOOD,
            SpItems.LEGAL_SUBSTANCE_THREE,
            15f,
            400,
        )
            .criterion(Items.POTION)
            .criterion(SpItems.LEGAL_SUBSTANCE_THREE)
            .offerTo(c, SpItems.LEGAL_SUBSTANCE_THREE.gId.withPrefix(LEGAL_FOLDER))

        ShapelessRecipeJsonFactory.create(RecipeCategory.FOOD, SpItems.LEGAL_SUBSTANCE_CONCOCTION)
            .ingredientCriterion(SpItems.LEGAL_SUBSTANCE)
            .ingredientCriterion(SpItems.LEGAL_SUBSTANCE_TWO)
            .ingredientCriterion(SpItems.LEGAL_SUBSTANCE_THREE)
            .criterion(SpItems.LEGAL_SUBSTANCE_CONCOCTION)
            .offerTo(c, SpItems.LEGAL_SUBSTANCE_CONCOCTION.gId.withPrefix(LEGAL_FOLDER))
    }

    private fun skelet(c: RecipeExporter) {
        c.cooking(SpItems.SKELETON, SpItems.WITHER_SKELETON, 5f, 200, SKELET_FOLDER)

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SANS)
            .pattern("X")
            .pattern("Y")
            .pattern("Z")
            .ingredient('X', SpItems.SKELETON)
            .ingredient('Y', Items.DIAMOND_CHESTPLATE)
            .ingredient('Z', Items.SOUL_LANTERN)
            .criterion(hasItem(SpItems.SKELETON), conditionsFromItem(SpItems.SKELETON))
            .criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
            .offerTo(c, SpItems.SANS.gId.withPrefix(SKELET_FOLDER))

        ShapelessRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SKELETON)
            .ingredient(SpItems.SKELEON)
            .ingredient(Items.BONE)
            .criterion(hasItem(SpItems.SKELEON), conditionsFromItem(SpItems.SKELEON))
            .offerTo(c, SpItems.SKELETON.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SKELEON)
            .pattern(" S ")
            .pattern("ATA")
            .pattern("L L")
            .ingredientCriterion('S', SpItems.SKULL)
            .ingredientCriterion('A', SpItems.ARM)
            .ingredientCriterion('L', SpItems.LEG)
            .ingredientCriterion('T', SpItems.TORSO)
            .criterion(SpItems.SKELEON)
            .offerTo(c, SpItems.SKELEON.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SKULL)
            .pattern("ECE")
            .pattern(" F ")
            .ingredientCriterion('E', SpItems.EAR_BONES)
            .ingredientCriterion('C', SpItems.CRANIUM)
            .ingredientCriterion('F', SpItems.FACE)
            .criterion(SpItems.SKULL)
            .offerTo(c, SpItems.SKULL.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.ARM)
            .pattern("BBB")
            .pattern("B H")
            .pattern("B  ")
            .ingredientCriterion('H', SpItems.HAND)
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.ARM)
            .offerTo(c, SpItems.ARM.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.LEG)
            .pattern("B  ")
            .pattern("B  ")
            .pattern("BBF")
            .ingredientCriterion('F', SpItems.FOOT)
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.LEG)
            .offerTo(c, SpItems.LEG.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.TORSO)
            .pattern("R")
            .pattern("S")
            .pattern("P")
            .ingredientCriterion('R', SpItems.RIBCAGE)
            .ingredientCriterion('S', SpItems.SPINE)
            .ingredientCriterion('P', SpItems.PELVIS)
            .criterion(SpItems.TORSO)
            .offerTo(c, SpItems.TORSO.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FACE)
            .pattern("FFF")
            .ingredientCriterion('F', SpItems.FACE_PART)
            .criterion(SpItems.FACE)
            .offerTo(c, SpItems.FACE.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.HAND)
            .pattern("FFF")
            .pattern("FHT")
            .ingredientCriterion('F', SpItems.FINGER)
            .ingredientCriterion('T', SpItems.THUMB)
            .ingredientCriterion('H', SpItems.HAND_BASE)
            .criterion(SpItems.HAND)
            .offerTo(c, SpItems.HAND.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FOOT)
            .pattern("TTT")
            .pattern("TBT")
            .ingredientCriterion('T', SpItems.TOE)
            .ingredientCriterion('B', SpItems.FOOT_BASE)
            .criterion(SpItems.FOOT)
            .offerTo(c, SpItems.FOOT.gId.withPrefix(SKELET_FOLDER))


        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SPINE)
            .pattern("SS ")
            .pattern(" S ")
            .pattern(" SS")
            .ingredientCriterion('S', SpItems.SPINE_PART)
            .criterion(SpItems.SPINE)
            .offerTo(c, SpItems.SPINE.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.RIBCAGE)
            .pattern("RBR")
            .ingredientCriterion('R', SpItems.HALF_RIBCAGE)
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.RIBCAGE)
            .offerTo(c, SpItems.RIBCAGE.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.HALF_RIBCAGE)
            .pattern("R")
            .pattern("R")
            .ingredientCriterion('R', SpItems.QUARTER_RIBCAGE)
            .criterion(SpItems.HALF_RIBCAGE)
            .offerTo(c, SpItems.HALF_RIBCAGE.gId.withPrefix(SKELET_FOLDER))

        ShapelessRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.PELVIS)
            .ingredient(Items.BONE)
            .ingredient(Items.BONE)
            .criterion(hasItem(SpItems.PELVIS), conditionsFromItem(SpItems.PELVIS))
            .offerTo(c, SpItems.PELVIS.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.EAR_BONES)
            .pattern(" B ")
            .pattern("B  ")
            .pattern(" B ")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.EAR_BONES)
            .offerTo(c, SpItems.EAR_BONES.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.THUMB)
            .pattern("B")
            .pattern("B")
            .pattern("B")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.THUMB)
            .offerTo(c, SpItems.THUMB.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FINGER)
            .pattern("BB ")
            .pattern("B  ")
            .pattern("B  ")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.FINGER)
            .offerTo(c, SpItems.FINGER.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.TOE)
            .pattern("B  ")
            .pattern("B  ")
            .pattern("BB ")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.TOE)
            .offerTo(c, SpItems.TOE.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FACE_PART)
            .pattern("B B")
            .pattern("BBB")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.FACE_PART)
            .offerTo(c, SpItems.FACE_PART.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.SPINE_PART)
            .pattern("BB ")
            .pattern(" B ")
            .pattern(" BB")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.SPINE_PART)
            .offerTo(c, SpItems.SPINE_PART.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.QUARTER_RIBCAGE)
            .pattern("BBB")
            .pattern("BBB")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.QUARTER_RIBCAGE)
            .offerTo(c, SpItems.QUARTER_RIBCAGE.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.FOOT_BASE)
            .pattern("BB")
            .pattern("BB")
            .pattern("BB")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.FOOT_BASE)
            .offerTo(c, SpItems.FOOT_BASE.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.HAND_BASE)
            .pattern("B B")
            .pattern("BBB")
            .pattern("BBB")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.HAND_BASE)
            .offerTo(c, SpItems.HAND_BASE.gId.withPrefix(SKELET_FOLDER))

        ShapedRecipeJsonFactory.create(RecipeCategory.REDSTONE, SpItems.CRANIUM)
            .pattern("BBB")
            .pattern("B B")
            .pattern("BBB")
            .ingredientCriterion('B', Items.BONE)
            .criterion(SpItems.CRANIUM)
            .offerTo(c, SpItems.CRANIUM.gId.withPrefix(SKELET_FOLDER))
    }

    companion object {
        const val LEGAL_FOLDER = "legal_things/"
        const val SKELET_FOLDER = "skelet/"
        const val SWAG_FOLDER = "swag/"
    }

}
