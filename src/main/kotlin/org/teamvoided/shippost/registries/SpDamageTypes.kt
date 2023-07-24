package org.teamvoided.shippost.registries

import net.minecraft.entity.Entity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageType
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import org.teamvoided.shippost.TheShippostMod.id

object SpDamageTypes {

    val SUBSTANCE_CONCOCTION: RegistryKey<DamageType> = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, id("substance_concoction"))

    fun create(type:RegistryKey<DamageType>, entity: Entity): DamageSource {
        return entity.damageSources.create(type)
    }
}