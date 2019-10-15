package com.example.projetoavaliaoii.views.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetoavaliaoii.R
import com.example.projetoavaliaoii.views.model.Tarefa
import kotlinx.android.synthetic.main.activity_cadastra_tarefa.*

class CadastraTarefaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra_tarefa)



        btnCadastrarTarefa.setOnClickListener {

            var descricao = edtDescricaoTarefa.text.toString()
            var titl = edtTituloTarefa.text.toString()

            var tarefa = Tarefa(titl, descricao)
            tarefa.id = intent.getLongExtra("id", 0)
            var intent = Intent()
            intent.putExtra("tarefa", tarefa)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }
}
