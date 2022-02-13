package fi.lauriari.sleep_tracker.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fi.lauriari.sleep_tracker.models.SleepRecord
import fi.lauriari.sleep_tracker.repository.SleepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: SleepRepository,
) : ViewModel() {


    val sleepQuality: MutableState<String> = mutableStateOf("Select Sleep Quality")
    val sleepHours: MutableState<Int> = mutableStateOf(3)
    val sleepMinutes: MutableState<Int> = mutableStateOf(0)
    val sleepDate: MutableState<Long> = mutableStateOf(0)

    fun addSleepRecord() {
        viewModelScope.launch(context = Dispatchers.IO) {
            /*repository.addSleepRecord(
                SleepRecord(
                    sleepQuality = sleepQuality.value,
                    sleepHours = sleepHours.value,
                    sleepMinutes = sleepMinutes.value
                )
            )

             */
        }
    }


}
