package com.imd.atividade

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var newNote = intent.getSerializableExtra("note") as Note
        var id : Int = intent.getSerializableExtra("id") as Int

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "New Note"
        textNote_editText.setText( newNote.text)

        button_gravar.setOnClickListener {
            newNote.text = textNote_editText.text.toString()
            newNote.title = "title retornado"
            var returnIntent : Intent = Intent()
            returnIntent.putExtra("newNote", newNote)
            returnIntent.putExtra("id", id)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        button_cancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
