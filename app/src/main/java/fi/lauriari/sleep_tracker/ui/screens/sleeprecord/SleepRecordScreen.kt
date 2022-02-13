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
    val sleepHours: Int by mainViewModel.sleepHours
    val sleepMinutes: Int by mainViewModel.sleepMinutes


    Scaffold(
        content = {
            SleepRecordContent(
                sleepQuality = sleepQuality,
                onSleepQualitySelected = {
                    mainViewModel.sleepQuality.value = it
                },
                sleepHours = sleepHours,
                onSleepHoursChanged = {
                    mainViewModel.sleepHours.value = it
                },
                sleepMinutes = sleepMinutes,
                onSleepMinutesChanged = {
                    mainViewModel.sleepMinutes.value = it
                }
            )
        }
    )

}