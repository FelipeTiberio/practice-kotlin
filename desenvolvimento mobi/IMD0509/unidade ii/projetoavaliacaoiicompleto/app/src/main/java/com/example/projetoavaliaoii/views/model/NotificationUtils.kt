package com.example.projetonotificaon12

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.projetoavaliaoii.R


object NotificationUtils {

    val CHANNEL_ID = "default"

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotifictionChannel(context: Context){
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager

        val channelName = "Padrão"
        val channelDescription = "Canal padrão de Notificações"

        val channel = NotificationChannel(
            CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = channelDescription
            enableLights(true)
            lightColor = Color.GREEN
            vibrationPattern =
                longArrayOf(100,200,300,400,500,400,300,200,400)
        }
        notificationManager.createNotificationChannel(channel)
    }

    fun notificationSimple(context: Context, mgs :String, txt : String){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotifictionChannel(context)
        }

        val notificationBuilder =
            NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(mgs)
                .setContentText(txt)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setColor(ActivityCompat.getColor(context,R.color.colorAccent))
                .setDefaults(Notification.DEFAULT_ALL)
        val notificationManager =
            NotificationManagerCompat.from(context)
        notificationManager.notify(1,notificationBuilder.build())

    }


}



























































