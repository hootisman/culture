package io.hootisman.autrevie.pop

import com.mojang.logging.LogUtils
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.PathfinderMob
import net.minecraft.world.level.Level

class Pop(pEntityType: EntityType<out PathfinderMob>, pLevel: Level) : PathfinderMob(pEntityType, pLevel) {
    val logger = LogUtils.getLogger()


}