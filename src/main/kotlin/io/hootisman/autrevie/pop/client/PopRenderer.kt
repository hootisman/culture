package io.hootisman.autrevie.pop.client

import io.hootisman.autrevie.pop.Pop
import net.minecraft.client.model.VillagerModel
import net.minecraft.client.model.geom.ModelLayers
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.entity.MobRenderer
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer
import net.minecraft.client.renderer.entity.layers.VillagerProfessionLayer
import net.minecraft.resources.ResourceLocation
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
class PopRenderer(pContext: EntityRendererProvider.Context) :
    MobRenderer<Pop, VillagerModel<Pop>>(pContext, VillagerModel(pContext.bakeLayer(ModelLayers.VILLAGER)), 0.5F) {
    private val TEMP_SKIN: ResourceLocation = ResourceLocation("textures/entity/villager/villager.png")
    init {
        this.addLayer(CustomHeadLayer(this, pContext.modelSet, pContext.itemInHandRenderer))
        this.addLayer(CrossedArmsItemLayer(this, pContext.itemInHandRenderer))
    }

    override fun getTextureLocation(pEntity: Pop): ResourceLocation {
        return TEMP_SKIN
    }
}