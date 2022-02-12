package fi.lauriari.sleep_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import fi.lauriari.sleep_tracker.navigation.SetupNavigation
import fi.lauriari.sleep_tracker.ui.theme.SleepTrackerTheme
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SleepTrackerTheme {
                navController = rememberNavController()
                SetupNavigation(
                    navController = navController,
                    mainViewModel = mainViewModel
                )
            }
        }
    }
}