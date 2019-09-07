package com.felipe.ea_02

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  buttonDisplay :Button = findViewById(R.id.button)
        val  firstname : EditText = findViewById(R.id.name_editText)
        val  lastname : EditText= findViewById(R.id.last_editText)
        val  age : EditText = findViewById(R.id.age_editText)

        buttonDisplay.setOnClickListener {
            val person: Person = Person(
                firstname.text.toString(),
                lastname.text.toString(),
                age.text.toString().toInt(), Date()
            )

            val intent = Intent(this, DisplayPersonActivity::class.java)
            intent.putExtra("person", person)

            // startActivity(intent)

            startActivityForResult(intent, 101)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ( resultCode == Activity.RESULT_OK){
            val return_person : Person = data?.getSerializableExtra("new_person") as Person
            Log.d("EA", return_person.toString())
        }else{
            Log.d("EA", "ERRO:CANCEL")

        }
    }
}
