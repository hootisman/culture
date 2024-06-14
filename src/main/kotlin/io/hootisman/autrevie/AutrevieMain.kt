package io.hootisman.autrevie

import io.hootisman.autrevie.pop.client.PopRenderer
import io.hootisman.autrevie.registries.EntityRegistry
import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.neoforged.bus.api.IEventBus
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.client.event.EntityRenderersEvent
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent

@Mod(AutrevieMain.MOD_ID)
class AutrevieMain(bus: IEventBus) {
    init {
        EntityRegistry.ENTITY_TYPES.register(bus)
        bus.addListener(::onEntityRendererEvent)
        bus.addListener(::onEntityAttributeCreate)
    }

    companion object {
        const val MOD_ID = "autrevie"
    }

    private fun onEntityRendererEvent(event: EntityRenderersEvent.RegisterRenderers){
        event.registerEntityRenderer(EntityRegistry.POP.get(), ::PopRenderer)
    }

    private fun onEntityAttributeCreate(event: EntityAttributeCreationEvent){
        event.put(EntityRegistry.POP.get(), Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED).add(Attributes.ATTACK_KNOCKBACK).build())
    }
}