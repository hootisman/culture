package io.hootisman.autrevie.pop.client

import com.mojang.blaze3d.vertex.PoseStack
import io.hootisman.autrevie.pop.Pop
import net.minecraft.client.model.PlayerModel
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
    MobRenderer<Pop, PlayerModel<Pop>>(pContext, PlayerModel(pContext.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5F) {
    private val TEMP_SKIN: ResourceLocation = ResourceLocation("textures/entity/player/slim/alex.png")

    override fun scale(pLivingEntity: Pop, pPoseStack: PoseStack, pPartialTickTime: Float) {
        val s = 0.9375f
        pPoseStack.scale(s, s, s)
    }

    override fun getTextureLocation(pEntity: Pop): ResourceLocation {
        return TEMP_SKIN
    }
}