package fi.lauriari.sleep_tracker.navigation.destinations

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import fi.lauriari.sleep_tracker.ui.screens.sleeprecord.SleepRecordScreen
import fi.lauriari.sleep_tracker.util.Constants.SLEEP_RECORD_KEY
import fi.lauriari.sleep_tracker.util.Constants.SLEEP_RECORD_SCREEN
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel
import fi.lauriari.sleep_tracker.viewmodels.SleepDatePickerSupportViewModel
import kotlin.coroutines.coroutineContext

@RequiresApi(Build.VERSION_CODES.N)
fun NavGraphBuilder.sleepRecordComposable(
    mainViewModel: MainViewModel,
    sleepDatePickerSupportViewModel: SleepDatePickerSupportViewModel
) {
    composable(
        route = SLEEP_RECORD_SCREEN,
        arguments = listOf(navArgument(SLEEP_RECORD_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->

        val context = LocalContext.current

        val sleepRecordId = navBackStackEntry.arguments!!.getInt(SLEEP_RECORD_KEY)
        Toast.makeText(context, sleepRecordId.toString(), Toast.LENGTH_SHORT).show()

        SleepRecordScreen(
            mainViewModel = mainViewModel,
            sleepDatePickerSupportViewModel = sleepDatePickerSupportViewModel
        )
    }
}