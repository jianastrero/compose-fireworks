package dev.jianastrero.composefireworks.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jianastrero.composefireworks.R
import dev.jianastrero.composefireworks.ui.component.Firework
import dev.jianastrero.composefireworks.ui.theme.ComposeFireworksTheme
import dev.jianastrero.composefireworks.ui.theme.Pink200
import dev.jianastrero.composefireworks.unsplash.Unsplash
import dev.jianastrero.composefireworks.util.onClick
import dev.jianastrero.composefireworks.util.openUrl

@Composable
fun FireworkDesignerScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val backgroundPainter = painterResource(id = R.drawable.skyline)

    Box(modifier = Modifier
        .background(Pink200)
        .then(modifier)) {
        Image(
            painter = backgroundPainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        IconButton(
            onClick = onBack,
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
        ClickableText(
            text = Unsplash.shoutOutText,
            onClick = { offset ->
                Unsplash.shoutOutText.onClick("user", offset) {
                    context.openUrl(it)
                }

                Unsplash.shoutOutText.onClick("photo", offset) {
                    context.openUrl(it)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
        )

        Firework(
            modifier = Modifier
                .align(Alignment.Center)
                .size(128.dp)
        )
    }
}

@Preview(
    device = Devices.PIXEL_4_XL,
    name = "Firework Designer Screen",
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun FireworkDesignerScreenPreview() {
    ComposeFireworksTheme(modifier = Modifier.fillMaxSize()) {
        FireworkDesignerScreen(
            onBack = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
