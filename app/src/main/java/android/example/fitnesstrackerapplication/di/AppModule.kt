package android.example.fitnesstrackerapplication.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import android.example.fitnesstrackerapplication.data.RunDao
import android.example.fitnesstrackerapplication.data.RunDB
import android.example.fitnesstrackerapplication.other.Constants.Companion.DATABASE_NAME
import android.example.fitnesstrackerapplication.other.Constants.Companion.KEY_FIRST_TIME_TOGGLE
import android.example.fitnesstrackerapplication.other.Constants.Companion.KEY_NAME
import android.example.fitnesstrackerapplication.other.Constants.Companion.KEY_WEIGHT
import android.example.fitnesstrackerapplication.other.Constants.Companion.SHARED_PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDb(app: Application): RunDB {
        return Room.databaseBuilder(app, RunDB::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRunDao(db: RunDB): RunDao {
        return db.getRunDao()
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(app: Application) =
        app.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(sharedPreferences: SharedPreferences) =
        sharedPreferences.getString(KEY_NAME, "") ?: ""

    @Singleton
    @Provides
    fun provideWeight(sharedPreferences: SharedPreferences) =
        sharedPreferences.getFloat(KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPreferences: SharedPreferences) = sharedPreferences.getBoolean(
        KEY_FIRST_TIME_TOGGLE, true
    )


}