package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * Esta atividade permite ao usuário lançar um dado e ver o resultado  na tela
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Lance os dados e actualize a tela com o resultado.
     */
    private fun rollDice() {
        //Crie um novo objeto de Dados com 6 lados e role-o
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Atualize a tela com o lançamento dos dados
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}