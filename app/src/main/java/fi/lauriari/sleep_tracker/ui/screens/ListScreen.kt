package fi.lauriari.sleep_tracker.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@Composable
fun ListScreen(
    mainViewModel: MainViewModel,
    navigateToSleepRecordScreen: () -> Unit
) {

    Scaffold(
        content = {

        },
        floatingActionButton = {
            AddSleepRecordFab(
                navigateToSleepRecordScreen = navigateToSleepRecordScreen
            )
        }
    )

}
