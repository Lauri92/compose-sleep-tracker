package fi.lauriari.sleep_tracker.navigation.destinations

import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import fi.lauriari.sleep_tracker.util.Constants.LIST_SCREEN
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

fun NavGraphBuilder.listComposable(
    mainViewModel: MainViewModel
) {
    composable(
        route = LIST_SCREEN
    ) {
        Text("Hello list screen")
    }
}