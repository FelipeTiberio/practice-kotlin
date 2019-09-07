package com.felipe.ea_02

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import javax.xml.transform.Result

class DisplayPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_person)


        val new_person = intent.getSerializableExtra("person") as Person

        val firstNameTextVarargs : TextView = findViewById(R.id.name_textview)
        val lastNameTextView : TextView = findViewById(R.id.last_name_textview)
        val ageTextView : TextView = findViewById(R.id.age_textview)


        firstNameTextVarargs.text = new_person.nome
        lastNameTextView.text = new_person.lastname
        ageTextView.text = new_person.age.toString()

        val saveButton : Button = findViewById(R.id.saveButton_button)
        val cancelButton : Button = findViewById(R.id.cancel_button)

        saveButton.setOnClickListener {
            new_person.nome = " first name"
            new_person.lastname = " this is the lastname"

            val return_sintent : Intent = Intent()
            return_sintent.putExtra("new_person", new_person)
            setResult(Activity.RESULT_OK, return_sintent)

            finish()
        }

        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }
}
