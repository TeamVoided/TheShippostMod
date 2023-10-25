package org.teamvoided.shippost.item

import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import java.util.function.Supplier

enum class ToolMaterials(
    private val miningLevel: Int,
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairIngredient: Supplier<Ingredient>,
) : ToolMaterial {
    COPPER_MATERIAL(
        2, 501, 6.0f, 2.0f, 20,
        Supplier { Ingredient.ofItems(Items.COPPER_INGOT) });

    override fun getDurability(): Int = this.itemDurability


    override fun getMiningSpeedMultiplier(): Float = this.miningSpeed


    override fun getAttackDamage(): Float = this.attackDamage


    override fun getMiningLevel(): Int = this.miningLevel


    override fun getEnchantability(): Int = this.enchantability

    override fun getRepairIngredient(): Ingredient = this.repairIngredient.get()
}