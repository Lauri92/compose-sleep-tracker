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
import java.text.SimpleDateFormat
import java.util.*

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

    val now = Calendar.getInstance()
    var mYear by remember { mutableStateOf(now.get(Calendar.YEAR)) }
    var mMonth by remember { mutableStateOf(now.get(Calendar.MONTH)) }
    var mDay by remember { mutableStateOf(now.get(Calendar.DAY_OF_MONTH)) }
    val dateMilliseconds = remember { mutableStateOf<Long>(0) }

    val datePickerDialog = DatePickerDialog(context)
        .also { datePickerDialog ->
            datePickerDialog.datePicker.maxDate = Calendar.getInstance().timeInMillis
            datePickerDialog.setOnDateSetListener { datePicker, year: Int, month: Int, dayOfMonth: Int ->
                mDay = dayOfMonth
                mMonth = month + 1
                mYear = year
                // TODO: SET date to milliseconds as a value which will eventually be added to Room

                val formatter = SimpleDateFormat("dd MM yyyy", Locale.getDefault()).also {
                    it.timeZone = TimeZone.getTimeZone("UTC")
                }
                val calendarTime = formatter.parse("$mDay $mMonth $mYear")?.time!!.toLong()

                dateMilliseconds.value = calendarTime

                Log.d("millisecondstest", dateMilliseconds.value.toString())
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
        Button(
            modifier = Modifier
                .padding(15.dp),
            onClick = {
                datePickerDialog.show()
            }) {
            Text(text = "Select a date")
        }
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = "Selected date: $mDay.$mMonth.$mYear\nTime in millis: ${dateMilliseconds.value}",
            color = Color.Green,
            fontSize = 20.sp
        )
    }
}