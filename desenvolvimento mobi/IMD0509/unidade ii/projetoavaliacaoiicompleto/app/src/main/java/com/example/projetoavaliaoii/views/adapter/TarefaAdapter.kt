package com.example.projetoavaliaoii.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoavaliaoii.R
import com.example.projetoavaliaoii.views.model.Tarefa
import kotlinx.android.synthetic.main.item_tarefa.view.*


class TarefaAdapter(private val tarefas: List<Tarefa>, private val callback: (Tarefa)-> Unit)
    : RecyclerView.Adapter<TarefaAdapter.LocalViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return LocalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    override fun onBindViewHolder(holder: LocalViewHolder, position: Int) {
        holder.bindView(tarefas[position])

        holder.itemView.setOnClickListener {
            val note = tarefas[holder.adapterPosition]
            callback(note)
        }
    }



    class LocalViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Tarefa) {
            //this.itemView.titleItem_textview.text = note.title
            this.itemView.txtId.text = note.id.toString()
            this.itemView.txtDescricao.text = note.text
            this.itemView.txtTitulo.text = note.title

        }
    }
}