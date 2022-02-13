package fi.lauriari.sleep_tracker.ui.screens.sleeprecord

import android.app.DatePickerDialog
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.lauriari.sleep_tracker.viewmodels.SleepDatePickerSupportViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SleepDatePicker(
    sleepDate: Long,
    onSleepDateChanged: (Long) -> Unit,
    sleepDatePickerSupportViewModel: SleepDatePickerSupportViewModel
) {

    val context = LocalContext.current

    Spacer(modifier = Modifier.height(10.dp))

    Text(
        fontSize = 32.sp,
        text = "Date",
        color = Color.Cyan
    )

    onSleepDateChanged(
        formatDateToMilliseconds(
            sleepDatePickerSupportViewModel.mDay.value,
            sleepDatePickerSupportViewModel.mMonth.value,
            sleepDatePickerSupportViewModel.mYear.value
        )
    )

    val datePickerDialog =
        DatePickerDialog(
            context,
            null,
            sleepDatePickerSupportViewModel.mYear.value,
            sleepDatePickerSupportViewModel.mMonth.value,
            sleepDatePickerSupportViewModel.mDay.value
        ).also { datePickerDialog ->
            datePickerDialog.datePicker.maxDate = Calendar.getInstance().timeInMillis
            datePickerDialog.setOnDateSetListener { _, year: Int, month: Int, dayOfMonth: Int ->
                sleepDatePickerSupportViewModel.mYear.value = year
                sleepDatePickerSupportViewModel.mMonth.value = month
                sleepDatePickerSupportViewModel.mDay.value = dayOfMonth

                onSleepDateChanged(
                    formatDateToMilliseconds(
                        dayOfMonth,
                        month,
                        year,
                    )
                )
            }
        }

    Column(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(5.dp)
            )
            .background(Color.Gray)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(15.dp),
            text = if (sleepDate != 0L) "Selected date: ${formatMillisecondsToDate(sleepDate)}" else "",
            color = Color.Green,
            fontSize = 25.sp
        )
        Button(
            modifier = Modifier
                .padding(15.dp),
            onClick = {
                datePickerDialog.show()
            }) {
            Text(text = "Select a date")
        }
    }
}

private fun formatDateToMilliseconds(mDay: Int, mMonth: Int, mYear: Int): Long {
    val formatter = SimpleDateFormat("dd MM yyyy", Locale.getDefault()).also {
        it.timeZone = TimeZone.getTimeZone("UTC")
    }
    return formatter.parse("$mDay ${mMonth + 1} $mYear")?.time!!.toLong()
}

@Composable
private fun formatMillisecondsToDate(milliseconds: Long): String {
    return DateFormat.getDateInstance().format(milliseconds)
}