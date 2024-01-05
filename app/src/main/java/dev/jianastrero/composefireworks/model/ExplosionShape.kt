package dev.jianastrero.composefireworks.model

sealed class ExplosionShape {

    data object Line : ExplosionShape()

    data class Circle(val radius: Float) : ExplosionShape()

}
