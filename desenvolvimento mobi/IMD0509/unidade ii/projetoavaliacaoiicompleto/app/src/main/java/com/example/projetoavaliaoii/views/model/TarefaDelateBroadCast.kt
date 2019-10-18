package com.example.projetobroadcastatividadeairplane

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.projetoavaliaoii.views.model.Tarefa
import com.example.projetonotificaon12.NotificationUtils

class TarefaDelateBroadCast: BroadcastReceiver() {
    override fun onReceive(ctx: Context, intent: Intent) {

        var action = intent.action
        var tarefa= intent.getSerializableExtra("tarefa") as Tarefa
        var txt = "Tarefa: ${tarefa.id}, Titulo: ${tarefa.title}"

        if ( action == "delete_tarefa"){
            NotificationUtils.notificationSimple(ctx, "Tafera não pode ser deletada", txt)
        }else if ( action == "tarefa_cadastrada"){
            NotificationUtils.notificationSimple(ctx, "Nova tarefa cadastrada.", txt)
        }

    }

}