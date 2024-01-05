package dev.jianastrero.composefireworks.ext

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


fun DrawScope.drawStar(color: Color, size: Float, center: Offset) {
    val halfSize = size / 2
    val quarterSize = size / 4

    drawLine(
        color = color,
        start = center.copy(y = center.y - size),
        end = center.copy(x = center.x + quarterSize, y = center.y - quarterSize),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(x = center.x + quarterSize, y = center.y - quarterSize),
        end = center.copy(x = center.x + size, y = center.y - quarterSize),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(x = center.x + size, y = center.y - quarterSize),
        end = center.copy(x = center.x + quarterSize, y = center.y + quarterSize),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(x = center.x + quarterSize, y = center.y + quarterSize),
        end = center.copy(x = center.x + halfSize, y = center.y + size),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(x = center.x + halfSize, y = center.y + size),
        end = center.copy(y = center.y + quarterSize),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(y = center.y + quarterSize),
        end = center.copy(x = center.x - halfSize, y = center.y + size),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(x = center.x - halfSize, y = center.y + size),
        end = center.copy(x = center.x - quarterSize, y = center.y + quarterSize),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(x = center.x - quarterSize, y = center.y + quarterSize),
        end = center.copy(x = center.x - size, y = center.y - quarterSize),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(x = center.x - size, y = center.y - quarterSize),
        end = center.copy(x = center.x - quarterSize, y = center.y - quarterSize),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
    drawLine(
        color = color,
        start = center.copy(x = center.x - quarterSize, y = center.y - quarterSize),
        end = center.copy(y = center.y - size),
        strokeWidth = 2.dp.toPx(),
        cap = Stroke.DefaultCap
    )
}
