package com.example.ea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Estou cirando alguns variaveis para armazenar os widts que estão na activity main
        val button : Button = findViewById(R.id.display_button )
        val firstNameEditText  : EditText = findViewById(R.id.first_name_etext)
        val lastNameEditText : EditText = last_name_etext
        val ageEditText: EditText = age_etext

        // O que fazer quando button for precionado
        button.setOnClickListener {
            val person: Person = Person(
                firstNameEditText.text.toString(),
                lastNameEditText.text.toString(),
                ageEditText.text.toString().toInt(),Date())

            val intent : Intent = Intent(this, PersonDisplayActivity::class.java)
            // Passado a classe person pela intente, person a o hash para peron
            intent.putExtra("person", person)

            startActivity(intent)
        }


    }

}
