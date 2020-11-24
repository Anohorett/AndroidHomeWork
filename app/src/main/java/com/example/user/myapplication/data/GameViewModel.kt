package com.example.user.myapplication.data

import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {

    var word = ""
    var score = 0
    private lateinit var wordList: MutableList<String>

    init {
        resetList()
        nextWord()
    }

    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )

        wordList.shuffle()
    }

    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    private fun nextWord() {
        if (wordList.isNotEmpty()) word = wordList.removeAt(0)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("destroyed")
    }


}