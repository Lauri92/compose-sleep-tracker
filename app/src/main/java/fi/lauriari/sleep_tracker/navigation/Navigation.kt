package fi.lauriari.sleep_tracker.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import fi.lauriari.sleep_tracker.navigation.destinations.listComposable
import fi.lauriari.sleep_tracker.navigation.destinations.sleepRecordComposable
import fi.lauriari.sleep_tracker.util.Constants.SLEEP_RECORD_SCREEN
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel
import fi.lauriari.sleep_tracker.viewmodels.SleepDatePickerSupportViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SetupNavigation(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    sleepDatePickerSupportViewModel: SleepDatePickerSupportViewModel
) {

    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = SLEEP_RECORD_SCREEN
    ) {
        listComposable(
            navigateToSleepRecordScreen = screen.sleepRecord,
            mainViewModel = mainViewModel
        )
        sleepRecordComposable(
            mainViewModel = mainViewModel,
            sleepDatePickerSupportViewModel = sleepDatePickerSupportViewModel
        )
    }

}