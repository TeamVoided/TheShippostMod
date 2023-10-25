package org.teamvoided.shippost.init

import net.minecraft.entity.Entity
import net.minecraft.entity.damage.DamageType
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import org.teamvoided.shippost.TheShippostMod.id

object SpDamageTypes {

    val SUBSTANCE_CONCOCTION: RegistryKey<DamageType> = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, id("substance_concoction"))

    fun Entity.customDamage(type:RegistryKey<DamageType>, amount: Float) {
        this.damage(this.damageSources.create(type), amount)
    }
}