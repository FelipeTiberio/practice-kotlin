package com.example.projetobroadcastatividadeairplane

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.projetonotificaon12.NotificationUtils

class TarefaDelateBroadCast: BroadcastReceiver() {
    override fun onReceive(ctx: Context, intent: Intent) {

        //var on:Boolean = intent.getBooleanExtra("state",false)
        var on : String? = intent.getStringExtra("delete_tarefa")

        if(on !=null ){

            Toast.makeText(ctx,"Modo Avião Ligado!", Toast.LENGTH_LONG).show()
            NotificationUtils.notificationSimple(ctx,"Modo Avião Ligado!")

        }/*else{

            Toast.makeText(ctx,"Modo Avião Desligado!", Toast.LENGTH_LONG).show()
            NotificationUtils.notificationSimple(ctx,"Modo Avião Desligado!")
        }*/

    }

}