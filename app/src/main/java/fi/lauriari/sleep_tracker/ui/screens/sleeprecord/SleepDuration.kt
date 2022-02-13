package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chargemap.compose.numberpicker.NumberPicker

@Composable
fun SleepDuration() {

    Spacer(modifier = Modifier.height(10.dp))

    Text(
        fontSize = 32.sp,
        text = "Sleep Duration",
        color = Color.Cyan
    )

    var hourPickerValue by remember { mutableStateOf(0) }
    var minutePickerValue by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(5.dp)
            )
            .fillMaxWidth()
            .background(Color.Gray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                NumberPicker(
                    modifier = Modifier
                        .background(Color.Gray),
                    value = hourPickerValue,
                    range = 3..12,
                    onValueChange = {
                        hourPickerValue = it
                    }
                )

                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = "Hours"
                )
            }
        }
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                NumberPicker(
                    modifier = Modifier
                        .background(Color.Gray),
                    value = minutePickerValue,
                    range = 0..59,
                    onValueChange = {
                        minutePickerValue = it
                    }
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = "Minutes"
                )
            }
        }
    }
}