package fi.lauriari.sleep_tracker.navigation.destinations

import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import fi.lauriari.sleep_tracker.util.Constants.SLEEP_RECORD_SCREEN

fun NavGraphBuilder.sleepRecordComposable() {
    composable(
        route = SLEEP_RECORD_SCREEN
    ) {
        Text("This is sleep record screen")
    }
}