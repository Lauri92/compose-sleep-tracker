package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fi.lauriari.sleep_tracker.components.SleepQualityDropDown

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SleepRecordScreen() {


    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                SleepQualityDropDown(
                    sleepQualityList = listOf("Poor", "Fair", "Average", "Good", "Very Good")
                )

                Spacer(modifier = Modifier.height(10.dp))

                SleepDuration()

                Spacer(modifier = Modifier.height(10.dp))

                SleepDatePicker()

            }
        }
    )

}