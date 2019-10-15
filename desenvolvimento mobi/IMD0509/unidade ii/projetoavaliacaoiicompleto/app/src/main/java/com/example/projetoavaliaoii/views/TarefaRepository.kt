package com.example.projetoavaliaoii.views

import com.example.projetoavaliaoii.views.model.Tarefa

interface TarefaRepository {

    abstract val TABBLE_NAME: String?

    fun save(tarefa: Tarefa)
    fun remove (vararg tarefa: Tarefa)
    fun noteById(id:Long, callback: (Tarefa?) -> Unit)
    fun search(term : String , callback: (List<Tarefa>) -> Unit)
}