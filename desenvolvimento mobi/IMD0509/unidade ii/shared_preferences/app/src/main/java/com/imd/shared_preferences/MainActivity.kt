package com.imd.shared_preferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("config", 0)

        val edit = pref.edit()


        salvar_button.setOnClickListener {

            edit.putString("usuario", usuario_editText.text.toString())
            edit.putString("email", email_editText.text.toString())
            edit.commit()

            Toast.makeText(this,"Dados salvos", Toast.LENGTH_SHORT).show()
        }

        carregar_informacoes_btn.setOnClickListener {

            usuario_txt.text = pref.getString("usuario", "padrão")
            usuario_txt.visibility = View.VISIBLE
            email_txt.text = pref.getString("email", "padrão")
            email_txt.visibility = View.VISIBLE
        }


    }


}
