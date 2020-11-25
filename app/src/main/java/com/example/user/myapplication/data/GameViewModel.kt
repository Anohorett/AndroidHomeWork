package com.example.user.myapplication.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {

    val word = MutableLiveData<String>()
    val score = MutableLiveData<Int>()
    private lateinit var wordList: MutableList<String>

    init {

        word.value = ""
        score.value = 0
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
        score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }

    private fun nextWord() {
        if (wordList.isNotEmpty()) word.value = wordList.removeAt(0)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("destroyed")
    }


}