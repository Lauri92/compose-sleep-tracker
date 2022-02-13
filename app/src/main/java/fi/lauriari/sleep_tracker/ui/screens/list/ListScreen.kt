package fi.lauriari.sleep_tracker.ui.screens.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold

import androidx.compose.runtime.*
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@RequiresApi(Build.VERSION_CODES.N)
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


