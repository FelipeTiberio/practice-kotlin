package com.e.revisaounidadeii


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.senha_editText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("user", 0)
        val edit = pref.edit()

        if (pref.getString("email", null) != null){
            email_editText.setText(pref.getString("email", ""))
        }

        if(pref.getString("senha", null ) != null){
            senha_editText.setText(pref.getString("senha", ""))
        }

        login_button.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }

        novo_cadastro_button.setOnClickListener {


            var intent = Intent(this , CadastroActivity::class.java)
            intent.putExtra("email", email_editText.text.toString())
            intent.putExtra("senha", senha_editText.text.toString())

            startActivity(intent)
        }

    }

}
