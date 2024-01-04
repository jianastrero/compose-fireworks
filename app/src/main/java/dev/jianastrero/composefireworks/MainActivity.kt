package dev.jianastrero.composefireworks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jianastrero.composefireworks.ui.app.App
import dev.jianastrero.composefireworks.ui.theme.ComposeFireworksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFireworksTheme(modifier = Modifier.fillMaxSize()) {
                App(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
