package com.example.felipe00.aula03

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var edtNome: EditText? = null
    private var edtEmail: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNome = findViewById(R.id.edtNome)
        edtEmail = findViewById(R.id.edtEmail)
    }

    fun next (view :View){
        val intent = Intent(this, Main2Activity::class.java)
        val nome = edtNome?.text.toString()
        val email = edtEmail?.text.toString()

        intent.putExtra("nome", nome)
        intent.putExtra("email", email)

        //startActivity(intent)

        startActivityForResult(intent, 10)

       // Toast.makeText(this, "Nome = $nome e E-mail: #email", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // tratamento dos dados quem veem da activity fechada


        if(resultCode == 10){
            var mens = data?.getStringExtra("mensagem")
            var txtMensagem = findViewById<TextView>(R.id.txtMensagem)
            txtMensagem.text = mens
        }else{
            var txtMensagem = findViewById<TextView>(R.id.txtMensagem)
            txtMensagem.text = "Error resiltCode"
        }


    }
}
