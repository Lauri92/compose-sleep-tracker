package fi.lauriari.sleep_tracker.daos

import androidx.room.*
import fi.lauriari.sleep_tracker.models.SleepRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepRecordDao {

    @Query("SELECT * FROM sleep_record_table ORDER BY sleepDate")
    fun getAllSleepRecords(): Flow<List<SleepRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSleepRecord(sleepRecord: SleepRecord)

    @Delete
    suspend fun deleteSleepRecord(sleepRecord: SleepRecord)

    @Update
    fun updateSleepRecord(sleepRecord: SleepRecord)

}