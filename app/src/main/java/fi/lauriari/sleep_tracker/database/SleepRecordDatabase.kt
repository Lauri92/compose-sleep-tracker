package fi.lauriari.sleep_tracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fi.lauriari.sleep_tracker.daos.SleepRecordDao
import fi.lauriari.sleep_tracker.models.SleepRecord

@Database(entities = [SleepRecord::class], version = 1, exportSchema = false)
abstract class SleepRecordDatabase : RoomDatabase() {
    abstract fun sleepRecordDao(): SleepRecordDao
}