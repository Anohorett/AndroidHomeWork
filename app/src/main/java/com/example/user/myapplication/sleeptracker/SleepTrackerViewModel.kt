package com.example.user.myapplication.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.user.myapplication.database.SleepDatabaseDao

class SleepTrackerViewModel(
    val database: SleepDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

}