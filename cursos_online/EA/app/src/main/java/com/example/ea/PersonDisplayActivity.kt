package com.example.ea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PersonDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_display)

        val person : Person = intent.getSerializableExtra("person") as Person

        val firsnameTextView : TextView = findViewById(R.id.name_textview)
        val lastnameTextView : TextView = findViewById(R.id.last_name_etext)
        val ageTextView : TextView = findViewById(R.id.age_etext)

        firsnameTextView.text = person.firsName
        lastnameTextView.text = person.lastName
        ageTextView.text = person.age.toString()

    }
}
