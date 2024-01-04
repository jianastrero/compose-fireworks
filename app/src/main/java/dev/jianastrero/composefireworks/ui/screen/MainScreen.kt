package dev.jianastrero.composefireworks.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import dev.jianastrero.composefireworks.ui.enumeration.Screens
import dev.jianastrero.composefireworks.ui.theme.Blue200
import dev.jianastrero.composefireworks.ui.theme.Pink200
import dev.jianastrero.composefireworks.ui.theme.Pink50

@Composable
fun MainScreen(
    onNavigate: (Screens) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        modifier = Modifier
            .background(Pink50)
            .then(modifier)
    ) {
        Button(
            onClick = {
                onNavigate(Screens.FireworkDesigner)
            },
            elevation = ButtonDefaults.elevatedButtonElevation(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Firework Designer",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
