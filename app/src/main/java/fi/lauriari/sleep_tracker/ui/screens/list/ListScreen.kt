package fi.lauriari.sleep_tracker.ui.screens.list

import android.os.Build
import android.util.Log
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

    val allSleepRecords by mainViewModel.allSleepRecords.collectAsState()

    Scaffold(
        content = {
            ListContent(allSleepRecords = allSleepRecords)
        },
        floatingActionButton = {
            AddSleepRecordFab(
                navigateToSleepRecordScreen = navigateToSleepRecordScreen
            )
        }
    )
}


