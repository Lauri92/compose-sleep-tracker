package fi.lauriari.sleep_tracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fi.lauriari.sleep_tracker.database.SleepRecordDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        SleepRecordDatabase::class.java,
        "sleep_record_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: SleepRecordDatabase) = database.sleepRecordDao()
}