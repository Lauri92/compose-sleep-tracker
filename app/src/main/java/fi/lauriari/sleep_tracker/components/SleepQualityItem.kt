package fi.lauriari.sleep_tracker.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import fi.lauriari.sleep_tracker.ui.theme.Typography

@Composable
fun SleepQualityItem(
    sleepQualityString: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = sleepQualityString,
            fontSize = 15.sp,
            style = Typography.subtitle2,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
@Preview
fun PriorityItemPreview() {
    SleepQualityItem(sleepQualityString = "Fair")
}