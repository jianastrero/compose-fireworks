package dev.jianastrero.composefireworks.ui.nav_graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.jianastrero.composefireworks.ui.enumeration.Screens
import dev.jianastrero.composefireworks.ui.screen.FireworkDesignerScreen
import dev.jianastrero.composefireworks.ui.screen.MainScreen

fun NavGraphBuilder.mainNavGraph(
    onNavigate: (Screens) -> Unit
) {
    // Main
    composable(Screens.Main.route) {
        MainScreen(
            onNavigate = onNavigate,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        )
    }

    // Firework Designer
    composable(Screens.FireworkDesigner.route) {
        FireworkDesignerScreen(modifier = Modifier.fillMaxSize())
    }
}
