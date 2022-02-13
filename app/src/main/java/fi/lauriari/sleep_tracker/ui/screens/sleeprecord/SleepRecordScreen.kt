package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SleepRecordScreen(
    mainViewModel: MainViewModel
) {

    val sleepQuality: String by mainViewModel.sleepQuality

    Scaffold(
        content = {
            SleepRecordContent(
                sleepQuality = sleepQuality,
                onSleepQualitySelected = {
                    mainViewModel.sleepQuality.value = it
                }
            )
        }
    )

}