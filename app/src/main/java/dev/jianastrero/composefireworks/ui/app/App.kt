package dev.jianastrero.composefireworks.ui.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.jianastrero.composefireworks.enumeration.Screens
import dev.jianastrero.composefireworks.ui.nav_graph.mainNavGraph


@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Main.route,
        modifier = modifier
    ) {
        mainNavGraph(
            onBack = {
                navController.popBackStack()
            },
            onNavigate = { screen ->
                navController.navigate(screen.route)
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}
