package org.teamvoided.shippost.item

import net.minecraft.block.Block
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import java.util.function.Supplier

enum class SPToolMaterials(
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairIngredient: Supplier<Ingredient>,
    private val incorrectTag: TagKey<Block>,
) : ToolMaterial {
    COPPER_MATERIAL(
        501, 6.0f, 2.0f, 20,
        Supplier { Ingredient.ofItems(Items.COPPER_INGOT) }, BlockTags.INCORRECT_FOR_IRON_TOOL
    );

    override fun getDurability(): Int = this.itemDurability


    override fun getMiningSpeedMultiplier(): Float = this.miningSpeed


    override fun getAttackDamage(): Float = this.attackDamage

    override fun getIncorrectForDropsBlocks(): TagKey<Block> = this.incorrectTag


    override fun getEnchantability(): Int = this.enchantability

    override fun getRepairIngredient(): Ingredient = this.repairIngredient.get()
}
