package fi.lauriari.sleep_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import fi.lauriari.sleep_tracker.navigation.SetupNavigation
import fi.lauriari.sleep_tracker.ui.theme.SleepTrackerTheme
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel
import fi.lauriari.sleep_tracker.viewmodels.SleepDatePickerSupportViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val mainViewModel: MainViewModel by viewModels()
    private val sleepDatePickerSupportViewModel: SleepDatePickerSupportViewModel by viewModels() {
        SavedStateViewModelFactory(application, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SleepTrackerTheme {
                navController = rememberNavController()
                SetupNavigation(
                    navController = navController,
                    mainViewModel = mainViewModel,
                    sleepDatePickerSupportViewModel = sleepDatePickerSupportViewModel
                )
            }
        }
    }
}