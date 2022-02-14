package fi.lauriari.sleep_tracker.repository

import dagger.hilt.android.scopes.ViewModelScoped
import fi.lauriari.sleep_tracker.daos.SleepRecordDao
import fi.lauriari.sleep_tracker.models.SleepRecord
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class SleepRepository @Inject constructor(
    private val sleepRecordDao: SleepRecordDao
) {

    val getAllSleepRecords: Flow<List<SleepRecord>> = sleepRecordDao.getAllSleepRecords()

    suspend fun addSleepRecord(sleepRecord: SleepRecord) {
        sleepRecordDao.addSleepRecord(sleepRecord = sleepRecord)
    }

    fun getSelectedSleepRecord(sleepRecordId: Int): Flow<SleepRecord> {
        return sleepRecordDao.getSelectedSleepRecord(sleepRecordId)
    }

    fun getSleepRecordBySleepDate(sleepDate: Long): SleepRecord? {
        return sleepRecordDao.getSleepRecordBySleepDate(sleepDate)
    }

    suspend fun updateSleepRecord(sleepRecord: SleepRecord) {
        sleepRecordDao.updateSleepRecord(sleepRecord)
    }

    suspend fun deleteSleepRecord(sleepRecord: SleepRecord) {
        sleepRecordDao.deleteSleepRecord(sleepRecord)
    }
}