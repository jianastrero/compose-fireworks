package dev.jianastrero.composefireworks.ui.nav_graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.jianastrero.composefireworks.enumeration.Screens
import dev.jianastrero.composefireworks.ui.screen.FireworkDesignerScreen
import dev.jianastrero.composefireworks.ui.screen.MainScreen
import dev.jianastrero.composefireworks.ui.theme.ComposeFireworksTheme

fun NavGraphBuilder.mainNavGraph(
    onBack: () -> Unit,
    onNavigate: (Screens) -> Unit,
    modifier: Modifier = Modifier
) {
    // Main
    composable(Screens.Main.route) {
        ComposeFireworksTheme(modifier = modifier) {
            MainScreen(
                onNavigate = onNavigate,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            )
        }
    }

    // Firework Designer
    composable(Screens.FireworkDesigner.route) {
        ComposeFireworksTheme(modifier = modifier) {
            FireworkDesignerScreen(
                onBack = onBack,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
