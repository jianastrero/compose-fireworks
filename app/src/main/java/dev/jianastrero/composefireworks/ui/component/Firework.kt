package dev.jianastrero.composefireworks.ui.component

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import dev.jianastrero.composefireworks.model.ExplosionShape
import dev.jianastrero.composefireworks.model.FireworkExplosion

@Composable
fun Firework(
    modifier: Modifier = Modifier,
    vararg explosions: FireworkExplosion
) {
    val anim = rememberInfiniteTransition(label = "Firework")
    val outwardAnims = explosions.mapIndexed { index, explosion ->
        anim.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    delayMillis = explosion.delay,
                    durationMillis = explosion.duration,
                    easing = EaseInOutCubic
                )
            ),
            label = "Outward $index"
        )
    }
    val explosionAnims by remember(explosions) {
        derivedStateOf {
            explosions.zip(outwardAnims)
        }
    }

    Box(
        modifier = modifier
            .drawWithCache {
                onDrawWithContent {
                    explosionAnims.forEach { explosion ->
                        drawExplosion(explosion)
                    }
                }
            }
    )
}

private fun ContentDrawScope.drawExplosion(explosion: Pair<FireworkExplosion, State<Float>>) {
    val (fireworkExplosion, outwardAnim) = explosion
    val maxLength = size.minDimension / 2f
    val head = center.copy(
        x = center.x + maxLength * outwardAnim.value,
        y = center.y
    )
    val tail = center.copy(
        x =
        if (outwardAnim.value <= 0.5f)
            center.x
        else
            center.x + maxLength * (outwardAnim.value - 0.5f) * 2f,
        y = center.y - fireworkExplosion.rotation * outwardAnim.value
    )
    val newColor = fireworkExplosion.color
        .copy(
            alpha =
            if (outwardAnim.value <= fireworkExplosion.fadeStart)
                1f
            else
                1f - (outwardAnim.value - fireworkExplosion.fadeStart) / (1f - fireworkExplosion.fadeStart)
        )

    for (i in 0 until 360 step (360 / fireworkExplosion.arms)) {
        rotate(i.toFloat() + fireworkExplosion.shift) {
            when (fireworkExplosion.shape) {
                ExplosionShape.Line -> {
                    drawLine(
                        color = newColor,
                        start = head,
                        end = tail,
                        strokeWidth = 2.dp.toPx(),
                        cap = Stroke.DefaultCap
                    )
                }
                is ExplosionShape.Circle -> {
                    drawCircle(
                        color = newColor,
                        radius = fireworkExplosion.shape.radius,
                        center = tail
                    )
                }
            }
        }
    }
}
