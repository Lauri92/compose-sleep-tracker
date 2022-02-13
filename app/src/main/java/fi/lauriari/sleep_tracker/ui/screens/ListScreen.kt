package fi.lauriari.sleep_tracker.ui.screens

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chargemap.compose.numberpicker.NumberPicker
import fi.lauriari.sleep_tracker.viewmodels.MainViewModel
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ListScreen(
    mainViewModel: MainViewModel,
    navigateToSleepRecordScreen: () -> Unit
) {

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                SleepDuration()

                Spacer(modifier = Modifier.height(10.dp))

                SleepDatePicker()
            }
        },
        floatingActionButton = {
            AddSleepRecordFab(
                navigateToSleepRecordScreen = navigateToSleepRecordScreen
            )
        }
    )
}

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

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SleepDatePicker() {

    val context = LocalContext.current

    Spacer(modifier = Modifier.height(10.dp))

    Text(
        fontSize = 32.sp,
        text = "Date",
        color = Color.Cyan
    )

    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val now = Calendar.getInstance()
    mYear = now.get(Calendar.YEAR)
    mMonth = now.get(Calendar.MONTH)
    mDay = now.get(Calendar.DAY_OF_MONTH)
    now.time = Date()
    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
        }, mYear, mMonth, mDay
    ).also { datePickerDialog ->
        datePickerDialog.datePicker.maxDate = Calendar.getInstance().timeInMillis
        datePickerDialog.setOnDateSetListener { datePicker, year: Int, month: Int, dayOfMonth: Int ->
            Toast.makeText(context, "$year, ${month + 1}, $dayOfMonth", Toast.LENGTH_SHORT).show()
        }
    }


    Column(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            datePickerDialog.show()
        }) {
            Text(text = "Select a date")
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            modifier = Modifier.clickable {
                Toast.makeText(
                    context,
                    "Year: $mYear, Month: $mMonth, Day: $mDay",
                    Toast.LENGTH_SHORT
                ).show()
            },
            text = "Selected date: ${date.value}",
            color = Color.Magenta
        )
    }
}
