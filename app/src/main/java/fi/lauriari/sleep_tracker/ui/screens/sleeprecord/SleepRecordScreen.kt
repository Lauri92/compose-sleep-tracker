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
    mainViewModel: MainViewModel,
    navigateToListScreen: () -> Unit,
    sleepRecordId: Int,
) {

    val sleepQuality: String by mainViewModel.sleepQuality
    val sleepHours: Int by mainViewModel.sleepHours
    val sleepMinutes: Int by mainViewModel.sleepMinutes
    val sleepDate: Long by mainViewModel.sleepDate


    Scaffold(
        content = {
            SleepRecordContent(
                navigateToListScreen = navigateToListScreen,
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
                },
                sleepDate = sleepDate,
                onSleepDateChanged = {
                    mainViewModel.sleepDate.value = it
                },
                mainViewModel = mainViewModel,
                addSleepRecord = {
                    mainViewModel.addSleepRecord()
                },
                updateSleepRecord = {
                    mainViewModel.updateSleepRecord()
                },
                sleepRecordId = sleepRecordId
            )
        }
    )

}