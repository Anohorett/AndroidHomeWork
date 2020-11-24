package com.example.user.myapplication

import android.app.Application
import timber.log.Timber

class AhwApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}