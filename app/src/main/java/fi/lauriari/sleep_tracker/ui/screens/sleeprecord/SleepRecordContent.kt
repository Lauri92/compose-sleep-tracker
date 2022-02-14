package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.lauriari.sleep_tracker.components.SleepQualityDropDown
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@Composable
fun SleepRecordContent(
    mainViewModel: MainViewModel,
    sleepQuality: String,
    onSleepQualitySelected: (String) -> Unit,
    sleepHours: Int,
    onSleepHoursChanged: (Int) -> Unit,
    sleepMinutes: Int,
    onSleepMinutesChanged: (Int) -> Unit,
    sleepDate: Long,
    onSleepDateChanged: (Long) -> Unit,
    addSleepRecord: () -> Unit,
    updateSleepRecord: () -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        SleepQualityDropDown(
            onSleepQualitySelected = onSleepQualitySelected,
            sleepQuality = sleepQuality,
        )

        Spacer(modifier = Modifier.height(10.dp))

        SleepDuration(
            sleepHours = sleepHours,
            onSleepHoursChanged = onSleepHoursChanged,
            sleepMinutes = sleepMinutes,
            onSleepMinutesChanged = onSleepMinutesChanged
        )

        Spacer(modifier = Modifier.height(10.dp))

        SleepDatePicker(
            sleepDate = sleepDate,
            onSleepDateChanged = onSleepDateChanged,
            mainViewModel = mainViewModel
        )

        if (mainViewModel.id.value == 0) {
            AddButton(sleepQuality, addSleepRecord)
        } else {
            UpdateButton(updateSleepRecord)
        }
    }
}

@Composable
fun UpdateButton(updateSleepRecord: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .padding(
                vertical = 50.dp,
                horizontal = 20.dp
            )
            .fillMaxWidth()
            .height(100.dp),
        onClick = {
            updateSleepRecord()
        }) {
        Text(
            fontSize = 25.sp,
            text = "Update Sleep Record"
        )
    }
}

@Composable
fun AddButton(
    sleepQuality: String,
    addSleepRecord: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .padding(
                vertical = 50.dp,
                horizontal = 20.dp
            )
            .fillMaxWidth()
            .height(100.dp),
        enabled = sleepQuality != "Select Sleep Quality",
        onClick = {
            addSleepRecord()
        }) {
        Text(
            fontSize = 25.sp,
            text = "Insert Sleep Record"
        )
    }
}