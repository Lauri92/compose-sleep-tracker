package fi.lauriari.sleep_tracker.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fi.lauriari.sleep_tracker.models.SleepRecord
import fi.lauriari.sleep_tracker.repository.SleepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: SleepRepository,
) : ViewModel() {

    init {
        getAllSleepRecords()
    }

    val id: MutableState<Int> = mutableStateOf(0)
    val sleepQuality: MutableState<String> = mutableStateOf("Select Sleep Quality")
    val sleepHours: MutableState<Int> = mutableStateOf(3)
    val sleepMinutes: MutableState<Int> = mutableStateOf(0)
    val sleepDate: MutableState<Long> = mutableStateOf(0)

    private val now: Calendar = Calendar.getInstance()
    var year: MutableState<Int> = mutableStateOf(now.get(Calendar.YEAR))
    var month: MutableState<Int> = mutableStateOf(now.get(Calendar.MONTH))
    var day: MutableState<Int> = mutableStateOf(now.get(Calendar.DAY_OF_MONTH))

    fun addSleepRecord() {
        viewModelScope.launch(context = Dispatchers.IO) {
            repository.addSleepRecord(
                SleepRecord(
                    sleepQuality = sleepQuality.value,
                    sleepHours = sleepHours.value,
                    sleepMinutes = sleepMinutes.value,
                    sleepDate = sleepDate.value
                )
            )
        }
    }

    private val _allSleepRecords = MutableStateFlow<List<SleepRecord>>(emptyList())
    val allSleepRecords: StateFlow<List<SleepRecord>> = _allSleepRecords

    private fun getAllSleepRecords() {
        viewModelScope.launch {
            repository.getAllSleepRecords.collect { sleepRecordList ->
                _allSleepRecords.value = sleepRecordList
            }
        }
    }

    private val _selectedSleepRecord: MutableStateFlow<SleepRecord?> = MutableStateFlow(null)
    val selectedSleepRecord: StateFlow<SleepRecord?> = _selectedSleepRecord

    fun getSelectedSleepRecord(sleepRecordId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getSelectedSleepRecord(sleepRecordId).collect { sleepRecord ->
                _selectedSleepRecord.value = sleepRecord
            }
        }
    }

    fun updateSleepRecord() {
        viewModelScope.launch(context = Dispatchers.IO) {
            repository.updateSleepRecord(
                SleepRecord(
                    id = id.value,
                    sleepQuality = sleepQuality.value,
                    sleepHours = sleepHours.value,
                    sleepMinutes = sleepMinutes.value,
                    sleepDate = sleepDate.value
                )
            )
        }
    }

    fun updateSleepRecordInputs(selectedSleepRecord: SleepRecord?) {
        Log.d("updatetest", "${selectedSleepRecord?.sleepDate}")
        if (selectedSleepRecord != null) {
            id.value = selectedSleepRecord.id
            sleepQuality.value = selectedSleepRecord.sleepQuality
            sleepHours.value = selectedSleepRecord.sleepHours
            sleepMinutes.value = selectedSleepRecord.sleepMinutes
            sleepDate.value = selectedSleepRecord.sleepDate
            setSleepRecordDateValues(sleepDate.value)
        } else {
            id.value = 0
            sleepQuality.value = "Select Sleep Quality"
            sleepHours.value = 3
            sleepMinutes.value = 0
            sleepDate.value = 0
            year.value = now.get(Calendar.YEAR)
            month.value = now.get(Calendar.MONTH)
            day.value = now.get(Calendar.DAY_OF_MONTH)
        }
    }

    private fun setSleepRecordDateValues(milliseconds: Long) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliseconds
        year.value = calendar[Calendar.YEAR]
        month.value = calendar[Calendar.MONTH]
        day.value = calendar[Calendar.DAY_OF_MONTH]
    }
}
