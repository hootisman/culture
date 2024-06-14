package io.hootisman.autrevie.registries

import io.hootisman.autrevie.AutrevieMain
import io.hootisman.autrevie.pop.Pop
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object EntityRegistry {
    val ENTITY_TYPES: DeferredRegister<EntityType<*>> = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AutrevieMain.MOD_ID)
    val POP = register("pop", EntityType.Builder.of(::Pop, MobCategory.MISC).sized(0.6F, 1.95F).eyeHeight(1.62F).clientTrackingRange(10))

    fun <T: Entity> register(id: String, builder: EntityType.Builder<T>): DeferredHolder<EntityType<*>, EntityType<T>> {
        return ENTITY_TYPES.register(id, fun(): EntityType<T> { return builder.build(AutrevieMain.MOD_ID + ":" + id) })
    }
}