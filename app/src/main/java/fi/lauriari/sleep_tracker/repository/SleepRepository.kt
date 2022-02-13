package fi.lauriari.sleep_tracker.repository

import dagger.hilt.android.scopes.ViewModelScoped
import fi.lauriari.sleep_tracker.daos.SleepRecordDao
import fi.lauriari.sleep_tracker.models.SleepRecord
import javax.inject.Inject

@ViewModelScoped
class SleepRepository @Inject constructor(
    private val sleepRecordDao: SleepRecordDao
) {

    suspend fun addSleepRecord(sleepRecord: SleepRecord) {
        sleepRecordDao.addSleepRecord(sleepRecord = sleepRecord)
    }

}