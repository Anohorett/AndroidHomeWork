package com.example.user.myapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {

    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private lateinit var wordList: MutableList<String>

    init {

        _word.value = ""
        _score.value = 0
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
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (_score.value)?.plus(1)
        nextWord()
    }

    private fun nextWord() {
        if (wordList.isNotEmpty()) _word.value = wordList.removeAt(0)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("destroyed")
    }
}