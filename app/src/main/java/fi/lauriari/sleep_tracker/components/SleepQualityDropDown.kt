package fi.lauriari.sleep_tracker.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.lauriari.sleep_tracker.util.Constants
import fi.lauriari.sleep_tracker.util.Constants.SLEEP_QUALITY_VALUES

@Composable
fun SleepQualityDropDown(
    onSleepQualitySelected: (String) -> Unit,
    sleepQuality: String
) {
    Text(
        fontSize = 32.sp,
        text = "Sleep Quality",
        color = Color.Cyan
    )

    var expanded by remember { mutableStateOf(false) }
    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f
    )

    var parentSize by remember { mutableStateOf(IntSize.Zero) }

    Row(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(5.dp)
            )
            .fillMaxWidth()
            .onGloballyPositioned {
                parentSize = it.size
            }
            .background(Color.Gray)
            .height(60.dp)
            .clickable { expanded = true }
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
                shape = MaterialTheme.shapes.small
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            fontSize = 17.sp,
            modifier = Modifier
                .padding(8.dp)
                .weight(8f),
            text = sleepQuality,
            style = MaterialTheme.typography.subtitle2
        )
        IconButton(
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .rotate(degrees = angle)
                .weight(weight = 1.5f),
            onClick = { expanded = true }
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null
            )
        }
        DropdownMenu(
            modifier = Modifier
                .width(with(LocalDensity.current) { parentSize.width.toDp() })
                .height(250.dp),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            SLEEP_QUALITY_VALUES.forEach { sleepQualityValue ->
                DropdownMenuItem(
                    onClick = {
                        onSleepQualitySelected(sleepQualityValue)
                        expanded = false
                    })
                {
                    SleepQualityItem(
                        sleepQualityString = sleepQualityValue
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun SleepQualityDropDownPreview() {
    SleepQualityDropDown(
        onSleepQualitySelected = { },
        sleepQuality = "Something"
    )
}
