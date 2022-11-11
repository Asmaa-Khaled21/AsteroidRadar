package com.udacity.asteroidradar

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.udacity.asteroidradar.database.AsteroidDatabase
import retrofit2.HttpException

class Refresh (appContext: Context, params: WorkerParameters): CoroutineWorker(appContext, params) {
        companion object {
            const val WORK_NAME = "RefreshDataWorker"
        }
        override suspend fun doWork(): Result { // check if failed fetch data

            val databaseVideo =AsteroidDatabase.getDatabase(applicationContext)
            val repository = Repo(databaseVideo)
            return try {

                repository.refresh()
                repository.delete()/// delete old
                Result.success()
            } catch (e: HttpException) {
                Result.retry()// retry
            }
        }

}