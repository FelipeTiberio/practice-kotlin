package com.example.projetoavaliaoii.views.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetoavaliaoii.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val pref = getSharedPreferences("user", 0)
       //  val edit = pref.edit()


        if (pref.getString("email", null) != null && pref.getString("senha", null ) != null ){

            edtEmailLogin.setText(pref.getString("email",null))
            edtSenhaLogin.setText(pref.getString("senha",null))

        }


        btnEntrarLogin.setOnClickListener {

            var senha = pref.getString("senha", null)
            var email = pref.getString("email",null)

            if ( edtSenhaLogin.text.toString() == senha && edtEmailLogin.text.toString() == email
            ){

                var intent = Intent(this, ListActivity::class.java)
                startActivityForResult(intent, 20)

            }else{
                Toast.makeText(this, "usuaria não cadastrado", Toast.LENGTH_SHORT).show()
            }
        }

        btnCadastrarLogin.setOnClickListener {

            var intent = Intent(this, CadastroActivity::class.java)
            startActivityForResult(intent, 10)
        }
    }


}
