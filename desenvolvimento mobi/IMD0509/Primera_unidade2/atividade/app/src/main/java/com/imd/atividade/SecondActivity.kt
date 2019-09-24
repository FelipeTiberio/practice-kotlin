package com.imd.atividade

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.exemplodialogskotlin.MyEditDialog
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    lateinit var newNote: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        newNote = intent.getSerializableExtra("note") as Note
        var id : Int = intent.getSerializableExtra("id") as Int

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "New Note"
        textNote_editText.setText( newNote.text)

        button_gravar.setOnClickListener {
            newNote.text = textNote_editText.text.toString()
            var intentToReturn: Intent = Intent()
            intentToReturn.putExtra("newNote", newNote)
            intentToReturn.putExtra("id", id)

            openEditDialog(it)

            setResult(Activity.RESULT_OK, intentToReturn)
            finish()
        }

        button_cancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }


    fun openEditDialog(view: View) {
        newNote.title = "fuuuuuuuuuu"
        MyEditDialog.show(supportFragmentManager, object : MyEditDialog.OnTextListener {
            override fun onSetText(text: String) {
                Toast.makeText(this@SecondActivity, "Texto: $text", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
