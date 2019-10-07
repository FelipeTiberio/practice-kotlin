package com.e.revisaounidadeii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("user", 0)
        val edit = pref.edit()

        if (pref.getString("email", null) != null){
            email_editText.text = pref.getString("email", null) as Editable
        }

        if(pref.getString("senha", null ) != null){
            senha_editText.text = pref.getString("senha", null) as Editable
        }

        login_button.setOnClickListener {

        }

        novo_cadastro_button.setOnClickListener {
            edit.putString("email", email_editText.text.toString())
            edit.putString("senha", senha_editText.text.toString())
        }

    }

}
