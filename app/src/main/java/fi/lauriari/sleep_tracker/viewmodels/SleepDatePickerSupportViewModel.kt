package fi.lauriari.sleep_tracker.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import java.util.*

class SleepDatePickerSupportViewModel : ViewModel() {


    private val now: Calendar = Calendar.getInstance()
    var mYear: MutableState<Int> = mutableStateOf(now.get(Calendar.YEAR))
    var mMonth: MutableState<Int> = mutableStateOf(now.get(Calendar.MONTH))
    var mDay: MutableState<Int> = mutableStateOf(now.get(Calendar.DAY_OF_MONTH))


}