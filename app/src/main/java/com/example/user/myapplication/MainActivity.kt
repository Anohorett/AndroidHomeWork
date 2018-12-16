package com.example.user.myapplication

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    lateinit var textView: TextView
    lateinit var btn: View

    var gameState: String? = null
    val GAME_STATE_KEY = "asdasda"
    val TEXT_VIEW_KEY = "asdasda2"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gameState = savedInstanceState?.getString(GAME_STATE_KEY)

        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_console)
        btn = findViewById(R.id.button1)
        btn.setOnClickListener { view ->
          Toast.makeText(this, "пиздец!",Toast.LENGTH_LONG)
              .show()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        textView.text = savedInstanceState?.getString(TEXT_VIEW_KEY)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putString(GAME_STATE_KEY, gameState)
            putString(TEXT_VIEW_KEY, textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }


}
