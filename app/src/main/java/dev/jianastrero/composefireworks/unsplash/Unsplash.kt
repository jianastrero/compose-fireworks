package dev.jianastrero.composefireworks.unsplash

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import dev.jianastrero.composefireworks.ui.theme.Blue50
import dev.jianastrero.composefireworks.ui.theme.Blue500
import dev.jianastrero.composefireworks.util.link

object Unsplash {
    private val unsplashUserUrl = "https://unsplash.com/@anthonydelanoix?utm_content=creditCopyText&utm_medium=referral&utm_source=unsplash"
    private val unsplashPhotoUrl = "https://unsplash.com/photos/empire-state-building-under-cloudy-sky-o0pifdpvJ_o?utm_content=creditCopyText&utm_medium=referral&utm_source=unsplash"

    val shoutOutText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Blue50)) {
            append("Photo by ")
        }
        link("user", unsplashUserUrl, "Anthony DELANOIX")
        withStyle(style = SpanStyle(color = Blue50)) {
            append(" on ")
        }
        link("photo", unsplashPhotoUrl, "Unsplash")
    }
}
