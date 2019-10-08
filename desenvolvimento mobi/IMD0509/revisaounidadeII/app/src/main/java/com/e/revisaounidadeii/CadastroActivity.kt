package com.e.revisaounidadeii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_cadastro.email_editText
import kotlinx.android.synthetic.main.activity_cadastro.senha_editText
import kotlinx.android.synthetic.main.activity_main.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val pref = getSharedPreferences("user", 0)
        val edit = pref.edit()

        val actionBar  = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        carregarTxtInEditText()

        cadastrar_button.setOnClickListener {
            edit.putString("email", email_editText.text.toString())
            edit.putString("senha", senha_editText.text.toString())
            edit.commit()
            Toast.makeText(this, "Novo usuário cadastrado", Toast.LENGTH_SHORT).show()
            this.finish()
        }

        limpar_button.setOnClickListener {
            email_editText.setText("")
            senha_editText.setText("")

        }
    }

    fun carregarTxtInEditText(){

        email_editText.setText(intent.getStringExtra("email"))
        senha_editText.setText(intent.getStringExtra("senha"))
    }
}
