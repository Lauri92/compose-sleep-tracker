package fi.lauriari.sleep_tracker.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fi.lauriari.sleep_tracker.repository.SleepRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: SleepRepository,
) : ViewModel() {


    val sleepQuality: MutableState<String> = mutableStateOf("Select Sleep Quality")


}
