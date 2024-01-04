package dev.jianastrero.composefireworks.ui.nav_graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.jianastrero.composefireworks.ui.enumeration.Screens
import dev.jianastrero.composefireworks.ui.screen.FireworkDesignerScreen
import dev.jianastrero.composefireworks.ui.screen.MainScreen

fun NavGraphBuilder.mainNavGraph() {
    // Main
    composable(Screens.Main.route) {
        MainScreen(modifier = Modifier.fillMaxSize())
    }

    // Firework Designer
    composable(Screens.FireworkDesigner.route) {
        FireworkDesignerScreen(modifier = Modifier.fillMaxSize())
    }
}
