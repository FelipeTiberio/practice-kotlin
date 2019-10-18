package com.example.projetoavaliaoii.views.views

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoavaliaoii.R
import com.example.projetoavaliaoii.views.adapter.TarefaAdapter
import com.example.projetoavaliaoii.views.model.Tarefa
import com.example.projetobroadcastatividadeairplane.TarefaDelateBroadCast
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private  var tarefas  = mutableListOf<Tarefa>()
    private  var adapter  = TarefaAdapter(tarefas, this::onMessageItemClick, this::onNotaItemLongClick)
    private  var receiver : TarefaDelateBroadCast? = null
    lateinit var intentFilter : IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // notification
        var receiver = TarefaDelateBroadCast()
        intentFilter  = IntentFilter()
        intentFilter.addAction("delete_tarefa")

        initReciclerView()
    }

    private fun onMessageItemClick(tarefa: Tarefa){
        //Toast.makeText(this, "vc clickou em mim ${tarefa.id}", Toast.LENGTH_LONG).show()
    }

    fun onNotaItemLongClick(posicao: Int):Boolean{
        var alertDialog = AlertDialog.Builder(this)

        alertDialog.setTitle("Excluir a tarefa ${tarefas[posicao].text}")
        alertDialog.setMessage(" Pretende excluir a tarefa ${tarefas[posicao].title} ?")

        alertDialog.setPositiveButton("Sim", {_,_->
            if( tarefas[posicao].completa == false ){
                registerReceiver(receiver, intentFilter)
                Toast.makeText(this, "Falata implementar a notificação ", Toast.LENGTH_LONG).show()

            }else{
                tarefas.removeAt(posicao)
                adapter.notifyItemRemoved(posicao)
            }
        })

        alertDialog.setNegativeButton("Não", {_,_-> })
        alertDialog.show()
        return true
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

            for ( tarefa in tarefas){
                tarefa.completa = true
                adapter.notifyItemChanged( tarefas.indexOf(tarefa) )
            }

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


    override fun onDestroy() {
        if(receiver != null){
            unregisterReceiver(receiver)
        }
        super.onDestroy()
    }

}
