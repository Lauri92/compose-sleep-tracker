package fi.lauriari.sleep_tracker.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import fi.lauriari.sleep_tracker.ui.screens.list.ListScreen
import fi.lauriari.sleep_tracker.util.Constants.LIST_SCREEN
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

fun NavGraphBuilder.listComposable(
    mainViewModel: MainViewModel,
    navigateToSleepRecordScreen: (Int) -> Unit
) {
    composable(
        route = LIST_SCREEN
    ) {
        ListScreen(
            mainViewModel = mainViewModel,
            navigateToSleepRecordScreen = navigateToSleepRecordScreen
        )
    }
}