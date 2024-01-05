package dev.jianastrero.composefireworks.model

import androidx.compose.ui.graphics.Color
import dev.jianastrero.composefireworks.ui.theme.Pink400

data class FireworkExplosion(
    val color: Color = Pink400,
    val arms: Int = 20,
    val delay: Int = 0,
    val duration: Int = 1_000,
    val rotation: Float = 0f,
    val fadeStart: Float = 0.6f,
    val shift: Float = 0f,
)
