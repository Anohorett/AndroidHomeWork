package com.example.user.myapplication

import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.*


class DicesActivity : AppCompatActivity() {

    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var textConsole: TextView
//    private lateinit var clearBtn: ImageButton
//    private lateinit var snackbar: Snackbar
    private lateinit var rollButton: Button
    private lateinit var diceImage: ImageView
    private lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dices)

        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        textConsole = findViewById(R.id.textConsole)
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
    }

    private fun rollDice() {
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {

        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    fun outInConsole(){
        textConsole.text = "${double(2)}"
    }

    fun clearConsole() {
        textConsole.text = ""
    }

    private fun double(x: Int) = x * 2

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    }

}
