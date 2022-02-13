package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fi.lauriari.sleep_tracker.components.SleepQualityDropDown

@Composable
fun SleepRecordContent(
    onSleepQualitySelected: (String) -> Unit,
    sleepQuality: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        SleepQualityDropDown(
            onSleepQualitySelected = onSleepQualitySelected,
            sleepQuality = sleepQuality,
        )

        Spacer(modifier = Modifier.height(10.dp))

        SleepDuration()

        Spacer(modifier = Modifier.height(10.dp))

        SleepDatePicker()

    }
}