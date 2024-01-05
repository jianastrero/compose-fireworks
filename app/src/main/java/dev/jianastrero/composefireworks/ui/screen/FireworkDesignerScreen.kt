package dev.jianastrero.composefireworks.ui.screen

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jianastrero.composefireworks.R
import dev.jianastrero.composefireworks.model.ExplosionShape
import dev.jianastrero.composefireworks.model.FireworkExplosion
import dev.jianastrero.composefireworks.ui.component.Firework
import dev.jianastrero.composefireworks.ui.theme.ComposeFireworksTheme
import dev.jianastrero.composefireworks.ui.theme.Orange300
import dev.jianastrero.composefireworks.ui.theme.Orange500
import dev.jianastrero.composefireworks.ui.theme.Pink200
import dev.jianastrero.composefireworks.ui.theme.Red500
import dev.jianastrero.composefireworks.ui.theme.Yellow300
import dev.jianastrero.composefireworks.ui.theme.Yellow400
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

        FireworkSample(
            modifier = Modifier
                .align(Alignment.Center)
                .size(128.dp)
        )
    }
}

@Composable
private fun FireworkSample(modifier: Modifier = Modifier) {
    val density = LocalDensity.current

    Firework(
        explosions = arrayOf(
            FireworkExplosion(
                arms = 8,
                color = Orange500,
                duration = 1_000,
            ),
            FireworkExplosion(
                arms = 20,
                color = Yellow300,
                delay = 300,
                duration = 700,
                fadeStart = 0f,
                rotation = 30f,
                shape = ExplosionShape.Circle(with(density) { 2.dp.toPx() }),
                shift = 45f
            ),
            FireworkExplosion(
                arms = 8,
                color = Yellow400,
                delay = 350,
                duration = 650,
                fadeStart = 0f,
                rotation = 45f,
                shape = ExplosionShape.Circle(with(density) { 4.dp.toPx() }),
                shift = 45f
            ),
            FireworkExplosion(
                delay = 400,
                color = Red500,
                duration = 600,
                arms = 8
            ),
            FireworkExplosion(
                arms = 24,
                color = Orange300,
                delay = 550,
                duration = 450,
                fadeStart = 0f,
                rotation = 30f,
                shift = 45f
            ),
        ),
        modifier = modifier
    )
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

@Preview(
    device = Devices.PIXEL_4_XL,
    name = "Firework",
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun FireworkPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        FireworkSample(
            modifier = Modifier
                .align(Alignment.Center)
                .size(128.dp)
        )
    }
}
