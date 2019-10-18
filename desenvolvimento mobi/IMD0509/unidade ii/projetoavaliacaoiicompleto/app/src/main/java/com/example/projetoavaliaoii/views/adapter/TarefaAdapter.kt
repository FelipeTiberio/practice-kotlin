package com.example.projetoavaliaoii.views.adapter

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoavaliaoii.R
import com.example.projetoavaliaoii.views.model.Tarefa
import kotlinx.android.synthetic.main.item_tarefa.view.*


class TarefaAdapter(private val tarefas: List<Tarefa>,
                    private val callback: (Tarefa)-> Unit,
                    private val longClick: (Int) -> Boolean)
    : RecyclerView.Adapter<TarefaAdapter.LocalViewHolder>()
{
    private var check  = false

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

            if ( note.completa == false){
                holder.itemView.setBackgroundColor(Color.TRANSPARENT)
                holder.itemView.txtTitulo.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                tarefas[holder.adapterPosition].completa = true
                holder.itemView.checked.isChecked = true

            }else{
                holder.itemView.setBackgroundColor(Color.WHITE)
                holder.itemView.txtTitulo.paintFlags = 0
                tarefas[holder.adapterPosition].completa = false
                holder.itemView.checked.isChecked = false
            }
            callback(note)
        }

        holder.itemView.setOnLongClickListener {
            longClick( holder.adapterPosition)
        }
    }



    class LocalViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Tarefa) {

            this.itemView.txtId.text = note.id.toString()
            this.itemView.txtDescricao.text = note.text
            this.itemView.txtTitulo.text = note.title

            if( note.completa){
                this.itemView.setBackgroundColor(Color.TRANSPARENT)
                this.itemView.txtTitulo.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.itemView.checked.isChecked = true
            }else{
                this.itemView.setBackgroundColor(Color.WHITE)
                this.itemView.txtTitulo.paintFlags = 0
                this.itemView.checked.isChecked = false
            }

        }
    }
}