package com.example.projetoavaliaoii.views.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetoavaliaoii.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        val pref = getSharedPreferences("user", 0)
        val edit = pref.edit()

        //"@+id/btnCadastrarCad"
        btnCadastrarCad.setOnClickListener {

            edit.putString("senha", edtSenhaCad.text.toString())
            edit.putString("email", edtEmailCad.text.toString())
            edit.putString("nomeuse", edtNomeCompletoCad.text.toString())
            edit.commit()
            Toast.makeText(this, "Novo usuário cadastrado", Toast.LENGTH_SHORT).show()
            this.finish()

        }


    }
}
