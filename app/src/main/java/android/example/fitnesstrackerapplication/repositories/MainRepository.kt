package android.example.fitnesstrackerapplication.repositories

import android.example.fitnesstrackerapplication.data.Run
import android.example.fitnesstrackerapplication.data.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByDate()


}