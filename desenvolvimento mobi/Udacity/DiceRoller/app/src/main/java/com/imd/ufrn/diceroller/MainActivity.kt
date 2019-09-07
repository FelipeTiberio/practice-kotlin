package com.imd.ufrn.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    /*Utilizo durante o código varias vezes a busca pela a imageView
    * Quem está no centro da activity, para não precisar sempre ficar busando
    * por sua referencia, irei utilizar essa variavel goblal */
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Pegando a referencia para o botão que está no xml
        val roll_button :Button = findViewById(R.id.roll_button)

        // Usando função labda para implementar setOnClikListener de Button
        roll_button.setOnClickListener { rollDice()}

        // Pegando a referencia do imageView que estava no xml
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt : Int = Random().nextInt(6) + 1

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val dice_image : ImageView = diceImage

        dice_image.setImageResource(drawableResource)

    }
}

