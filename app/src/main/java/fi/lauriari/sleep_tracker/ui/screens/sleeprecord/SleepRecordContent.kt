package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import fi.lauriari.sleep_tracker.models.SleepRecord

@Composable
fun SleepRecordContent(
    sleepQuality: String,
    onSleepQualitySelected: (String) -> Unit,
    sleepHours: Int,
    onSleepHoursChanged: (Int) -> Unit,
    sleepMinutes: Int,
    onSleepMinutesChanged: (Int) -> Unit,
    sleepDate: Long,
    onSleepDateChanged: (Long) -> Unit
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
            onSleepDateChanged = onSleepDateChanged
        )

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
                val sleepRecord = SleepRecord(
                    sleepQuality = sleepQuality,
                    sleepHours = sleepHours,
                    sleepMinutes = sleepMinutes,
                    sleepDate = sleepDate
                )
                Log.d("sleepRecordtest", sleepRecord.toString())
            }) {
            Text(
                fontSize = 25.sp,
                text = "Insert Sleep Record"
            )
        }

    }
}