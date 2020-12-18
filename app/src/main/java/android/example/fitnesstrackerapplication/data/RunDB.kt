package android.example.fitnesstrackerapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Run::class],
    version = 1
)
@TypeConverters(ImgConverters::class)
abstract class RunDB : RoomDatabase() {

    abstract fun getRunDao(): RunDao
}