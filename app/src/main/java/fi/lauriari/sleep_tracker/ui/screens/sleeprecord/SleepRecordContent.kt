package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.lauriari.sleep_tracker.components.DuplicateAlertDialog
import fi.lauriari.sleep_tracker.components.SleepQualityDropDown
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel

@Composable
fun SleepRecordContent(
    navigateToListScreen: () -> Unit,
    mainViewModel: MainViewModel,
    sleepQuality: String,
    onSleepQualitySelected: (String) -> Unit,
    sleepHours: Int,
    onSleepHoursChanged: (Int) -> Unit,
    sleepMinutes: Int,
    onSleepMinutesChanged: (Int) -> Unit,
    sleepDate: Long,
    onSleepDateChanged: (Long) -> Unit,
    addSleepRecord: () -> Unit,
    updateSleepRecord: () -> Unit,
    sleepRecordId: Int,
) {

    val context = LocalContext.current

    DuplicateAlertDialog(
        title = "Duplicate",
        message = "Check your date input, duplicate dates are not allowed!",
        openDialog = mainViewModel.openDuplicateDialog.value,
        closeDialog = { mainViewModel.openDuplicateDialog.value = false }
    )


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
            onSleepDateChanged = onSleepDateChanged,
            mainViewModel = mainViewModel,
            sleeprecordId = sleepRecordId
        )

        if (mainViewModel.id.value == 0) {
            AddButton(sleepQuality, addSleepRecord, navigateToListScreen, mainViewModel)
        } else {
            UpdateButton(updateSleepRecord, navigateToListScreen, mainViewModel)
        }
    }
}

@Composable
fun UpdateButton(
    updateSleepRecord: () -> Unit,
    navigateToListScreen: () -> Unit,
    mainViewModel: MainViewModel
) {

    val context = LocalContext.current

    OutlinedButton(
        modifier = Modifier
            .padding(
                vertical = 50.dp,
                horizontal = 20.dp
            )
            .fillMaxWidth()
            .height(100.dp),
        onClick = {
            updateSleepRecord()
            navigateToListScreen()
            Toast.makeText(
                context,
                "Updated ${mainViewModel.day.value}.${mainViewModel.month.value + 1}.${mainViewModel.year.value}",
                Toast.LENGTH_LONG
            ).show()
        }) {
        Text(
            fontSize = 25.sp,
            text = "Update Sleep Record"
        )
    }
}

@Composable
fun AddButton(
    sleepQuality: String,
    addSleepRecord: () -> Unit,
    navigateToListScreen: () -> Unit,
    mainViewModel: MainViewModel
) {

    val context = LocalContext.current

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
            val isDuplicate = mainViewModel.checkDuplicate()
            if (!isDuplicate) {
                addSleepRecord()
                navigateToListScreen()
                Toast.makeText(
                    context,
                    "Inserted ${mainViewModel.day.value}.${mainViewModel.month.value}.${mainViewModel.year.value}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }) {
        Text(
            fontSize = 25.sp,
            text = "Insert Sleep Record"
        )
    }
}