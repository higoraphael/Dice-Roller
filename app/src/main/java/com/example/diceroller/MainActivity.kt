package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


/**
 * Esta atividade permite ao usuário lançar um dado e ver o resultado  na tela
 */

class MainActivity : AppCompatActivity() {

    /**
     * Este método é chamado quando a atividade é criada
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Encontre o botão no layout
        val rollButton: Button = findViewById(R.id.button)

        //Defina um ouvinte de cliques no botão para lançar os dados quando o usuário tocar no botão
        rollButton.setOnClickListener { rollDice() }

        // Faça um lançamento de dados quando o aplicativo iniciar
        rollDice()
    }

    /**
     * Lance os dados e actualize a tela com o resultado.
     */
    private fun rollDice() {
        //Crie um novo objeto de Dados com 6 lados e role-o
        val dice = Dice(6)
        val diceRoll = dice.roll()


        // Atualize a tela com o lançamento dos dados
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Encontre o ImageView no layout
        diceImage.setImageResource(R.drawable.dice_2)

        // Determine qual ID de recurso drawable usar com base na jogada de dados
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Atualize o ImageView com o ID de recurso drawable correto
        diceImage.setImageResource(drawableResource)

        // Atualize a descrição do conteúdo
        diceImage.contentDescription = diceRoll.toString()


    }

    /**
     * Dados com um número fixo de lados.
     */

    class Dice(private val numSides: Int) {
        /**
         *Faça uma jogada de dados aleatória e retorne o resultado
         */

        fun roll(): Int {
            return (1..numSides).random()

        }

    }
}