package com.example.user.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*


class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun startNewActivity() {
        startActivity(Intent(
            this,
            DicesActivity::class.java
        ))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    }

}
