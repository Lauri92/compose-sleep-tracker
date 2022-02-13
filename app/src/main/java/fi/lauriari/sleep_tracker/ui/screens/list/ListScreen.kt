package fi.lauriari.sleep_tracker.ui.screens.list

import android.app.DatePickerDialog
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chargemap.compose.numberpicker.NumberPicker
import fi.lauriari.sleep_tracker.components.SleepQualityDropDown
import fi.lauriari.sleep_tracker.ui.screens.sleeprecord.SleepDatePicker
import fi.lauriari.sleep_tracker.ui.screens.sleeprecord.SleepDuration
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ListScreen(
    mainViewModel: MainViewModel,
    navigateToSleepRecordScreen: () -> Unit
) {

    Scaffold(
        content = {

        },
        floatingActionButton = {
            AddSleepRecordFab(
                navigateToSleepRecordScreen = navigateToSleepRecordScreen
            )
        }
    )
}


