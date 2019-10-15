package com.example.projetoavaliaoii.views.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoavaliaoii.R
import com.example.projetoavaliaoii.views.adapter.TarefaAdapter
import com.example.projetoavaliaoii.views.model.Tarefa
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private  var tarefas = mutableListOf<Tarefa>()
    private  var adapter = TarefaAdapter(tarefas, this::onMessageItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        initReciclerView()
    }

    private fun onMessageItemClick(tarefa: Tarefa){

    }

    private  fun  initReciclerView(){
        rvTarefas.adapter = adapter
        val linearLayout = LinearLayoutManager(this)
        rvTarefas.layoutManager = linearLayout

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        var actioncadastrar = R.id.action_cadastrar
        var actionSair = R.id.action_sair
        var actionConcluir = R.id.action_concluida


        if(id == actioncadastrar){

            var intent = Intent(this, CadastraTarefaActivity::class.java)
            intent.putExtra("id", tarefas.lastIndex)
            startActivityForResult(intent, 40)
            return true

        }else if(id == actionSair){
            finish()

        }else if(id == actionConcluir){
            //@TODO


        }


        else{
            return super.onOptionsItemSelected(item)
        }
        return false
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data != null) {
            if (requestCode == 40 && resultCode == Activity.RESULT_OK)
            {
                // objeto retornado pela segunda activity
                var returnTarefa = data.getSerializableExtra("tarefa") as Tarefa
                // id de returnNote no banco
                //var id : Long? = noteSqlHelper.insert(returnNote)
                //returnNote.id = id
                tarefas.add(returnTarefa)
                adapter.notifyItemInserted(tarefas.lastIndex)

                Toast.makeText(this, "Nova nota salva", Toast.LENGTH_SHORT).show()
            }


            else {
                Toast.makeText(
                    this, "Algum erro ocorreu, saõ foi possivel salva a tarefa", Toast.LENGTH_LONG
                ).show()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actions ,menu)
        return true
    }

}
