package fi.lauriari.sleep_tracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_record_table")
data class SleepRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val sleepQuality: String,
    val sleepHours: Int,
    val sleepMinutes: Int,
    val sleepDate: Long,
)