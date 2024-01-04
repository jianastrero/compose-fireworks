package dev.jianastrero.composefireworks.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Main Screen")
    }
}
