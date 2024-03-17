package org.teamvoided.shippost.init

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.shippost.TheShipPostMod.id
import org.teamvoided.shippost.entity.PelvisEntity

object SpEntities {

    val PELVIS_ENTITY = register(
        "pelvis",
        FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::PelvisEntity)
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
            .trackRangeBlocks(4).trackedUpdateRate(10).build()
    )


    fun serverInit() {

    }

    fun clientInit() {
        EntityRendererRegistry.register(PELVIS_ENTITY, ::FlyingItemEntityRenderer)
    }

    private fun <T : Entity> register(path: String, entry: EntityType<T>): EntityType<T> {
        return Registry.register(Registries.ENTITY_TYPE, id(path), entry)
    }

}