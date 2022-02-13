package fi.lauriari.sleep_tracker.navigation.destinations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import fi.lauriari.sleep_tracker.ui.screens.sleeprecord.SleepRecordScreen
import fi.lauriari.sleep_tracker.util.Constants.SLEEP_RECORD_SCREEN
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@RequiresApi(Build.VERSION_CODES.N)
fun NavGraphBuilder.sleepRecordComposable(
    mainViewModel: MainViewModel
) {
    composable(
        route = SLEEP_RECORD_SCREEN
    ) {
        SleepRecordScreen(
            mainViewModel = mainViewModel
        )
    }
}