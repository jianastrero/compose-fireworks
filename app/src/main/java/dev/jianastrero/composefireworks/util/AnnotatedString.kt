package dev.jianastrero.composefireworks.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import dev.jianastrero.composefireworks.ui.theme.Blue500

fun AnnotatedString.Builder.link(
    tag: String,
    url: String,
    text: String
) {
    pushStringAnnotation(tag, url)
    withStyle(style = SpanStyle(color = Blue500, textDecoration = TextDecoration.Underline)) {
        append(text)
    }
    pop()
}

fun AnnotatedString.onClick(
    tag: String,
    offset: Int,
    onClick: (String) -> Unit
) {
    val url = getStringAnnotations(
        tag = tag,
        start = offset,
        end = offset
    ).firstOrNull()

    if (url == null) return

    onClick(url.item)
}
