package org.teamvoided.shippost.entity

import net.minecraft.entity.EntityStatuses
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.particle.ItemStackParticleEffect
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import org.teamvoided.shippost.init.SpEntities
import org.teamvoided.shippost.init.SpItems

class PelvisEntity : ThrownItemEntity {
    constructor(entityType: EntityType<out PelvisEntity?>?, world: World?) :
            super(entityType as EntityType<out ThrownItemEntity?>?, world)

    constructor(world: World?, owner: LivingEntity?) :
            super(SpEntities.PELVIS_ENTITY as EntityType<out ThrownItemEntity?>, owner, world)

    constructor(world: World?, x: Double, y: Double, z: Double) :
            super(SpEntities.PELVIS_ENTITY as EntityType<out ThrownItemEntity?>, x, y, z, world)

    override fun getDefaultItem(): Item = SpItems.PELVIS
    private fun getParticleParameters(): ParticleEffect =
        ItemStackParticleEffect(ParticleTypes.ITEM, this.defaultItem.defaultStack)

    private fun spawnParticles() {
        val particleEffect = getParticleParameters()
        for (ignored in 0..7) {
            world.addParticle(particleEffect, this.x, this.y, this.z, 0.0, 0.0, 0.0)
        }
    }

    override fun onEntityHit(entityHitResult: EntityHitResult) {
        super.onEntityHit(entityHitResult)
        spawnParticles()
        entityHitResult.entity.damage(this.damageSources.thrown(this, owner), 3f)
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!world.isClient) {
            spawnParticles()
            world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES)
            discard()
        }
    }
}

