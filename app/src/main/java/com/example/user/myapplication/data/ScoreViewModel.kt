package com.example.user.myapplication.data

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ScoreViewModel(finalScore: Int): ViewModel() {
    val score = finalScore
    init {
        Timber.i("FinalScore is $finalScore")
    }
}