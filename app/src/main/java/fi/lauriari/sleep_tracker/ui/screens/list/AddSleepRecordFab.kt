package fi.lauriari.sleep_tracker.ui.screens.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddSleepRecordFab(
    navigateToSleepRecordScreen: (Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            navigateToSleepRecordScreen(-1)
        },
        backgroundColor = Color.DarkGray
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            tint = Color.Magenta
        )
    }
}