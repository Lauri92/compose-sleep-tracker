package fi.lauriari.sleep_tracker.navigation.destinations

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import fi.lauriari.sleep_tracker.ui.screens.sleeprecord.SleepRecordScreen
import fi.lauriari.sleep_tracker.util.Constants.SLEEP_RECORD_KEY
import fi.lauriari.sleep_tracker.util.Constants.SLEEP_RECORD_SCREEN
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@RequiresApi(Build.VERSION_CODES.N)
fun NavGraphBuilder.sleepRecordComposable(
    mainViewModel: MainViewModel,
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SLEEP_RECORD_SCREEN,
        arguments = listOf(navArgument(SLEEP_RECORD_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->

        val context = LocalContext.current

        val sleepRecordId = navBackStackEntry.arguments!!.getInt(SLEEP_RECORD_KEY)

        LaunchedEffect(key1 = sleepRecordId) {
            mainViewModel.getSelectedSleepRecord(sleepRecordId = sleepRecordId)
        }

        val selectedSleepRecord by mainViewModel.selectedSleepRecord.collectAsState()

        LaunchedEffect(key1 = selectedSleepRecord) {
            if (selectedSleepRecord != null || sleepRecordId == -1) {
                mainViewModel.updateSleepRecordInputs(selectedSleepRecord = selectedSleepRecord)
            }
        }


        SleepRecordScreen(
            navigateToListScreen = navigateToListScreen,
            mainViewModel = mainViewModel,
        )
    }
}