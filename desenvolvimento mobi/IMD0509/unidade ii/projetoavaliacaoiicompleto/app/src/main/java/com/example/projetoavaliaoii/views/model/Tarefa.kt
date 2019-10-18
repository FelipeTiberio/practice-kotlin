package com.example.projetoavaliaoii.views.model

import java.io.Serializable

class Tarefa(var title : String, var  text : String): Serializable{
    var id : Long? = null
    var completa = false
}