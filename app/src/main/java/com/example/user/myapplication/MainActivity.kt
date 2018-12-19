package com.example.user.myapplication

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        coordinatorLayout = findViewById(R.id.coordinatorLayout) as CoordinatorLayout
    }

    fun showMessage(v: View) {
        Snackbar.make(findViewById(R.id.coordinatorLayout), "puff puff!", Snackbar.LENGTH_LONG)
            .show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }
}
