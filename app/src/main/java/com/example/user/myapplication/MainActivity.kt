package com.example.user.myapplication

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var textConsole: TextView
    lateinit var clearBtn: ImageButton
    lateinit var snackbar: Snackbar
    lateinit var rollButton: Button
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        coordinatorLayout = findViewById(R.id.coordinatorLayout) as CoordinatorLayout
        textConsole = findViewById(R.id.textConsole) as TextView
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
    }

    private fun rollDice() {
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = (1..6).random()

        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    fun showMessage(v: View) {
        Snackbar.make(coordinatorLayout,"${double(2)}", Snackbar.LENGTH_LONG)
            .show()
    }

    fun outInConsole(v: View){
        textConsole.text = "${double(2)}"
    }

    fun clearConsole(v: View) {
        textConsole.text = ""
    }

    fun powerOf(number: Int, exponent: Int): Int {
        return number + exponent
    }

    fun double(x: Int) = x * 2

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }
}
