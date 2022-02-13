package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chargemap.compose.numberpicker.NumberPicker

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SleepDuration(
    sleepHours: Int,
    onSleepHoursChanged: (Int) -> Unit,
    sleepMinutes: Int,
    onSleepMinutesChanged: (Int) -> Unit
) {

    Spacer(modifier = Modifier.height(10.dp))

    Text(
        fontSize = 32.sp,
        text = "Sleep Duration",
        color = Color.Cyan
    )

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
                    dividersColor = Color.Green,
                    modifier = Modifier
                        .background(Color.Gray),
                    value = sleepHours,
                    range = 3..12,
                    onValueChange = { selectedHours ->
                        onSleepHoursChanged(selectedHours)
                        if (selectedHours == 12) {
                            onSleepMinutesChanged(0)
                        }
                    }
                )

                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = "Hours"
                )
            }
        }
        AnimatedVisibility(
            visible = sleepHours <= 11
        ) {
            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    NumberPicker(
                        dividersColor = Color.Green,
                        modifier = Modifier
                            .background(Color.Gray),
                        value = sleepMinutes,
                        range = 0..59,
                        onValueChange = { selectedMinutes ->
                            onSleepMinutesChanged(selectedMinutes)
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
}