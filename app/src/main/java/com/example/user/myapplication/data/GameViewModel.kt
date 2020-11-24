package com.example.user.myapplication.data

import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel: ViewModel() {

    init {
        Timber.i("GameViewModel created ")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("destroyed")
    }


}