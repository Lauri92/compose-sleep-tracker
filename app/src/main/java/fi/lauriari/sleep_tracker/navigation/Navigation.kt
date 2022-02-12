package fi.lauriari.sleep_tracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import fi.lauriari.sleep_tracker.navigation.destinations.listComposable
import fi.lauriari.sleep_tracker.util.Constants.LIST_SCREEN
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@Composable
fun SetupNavigation(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {

    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            mainViewModel = mainViewModel
        )
    }

}