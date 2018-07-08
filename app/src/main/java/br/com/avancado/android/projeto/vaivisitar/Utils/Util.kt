package br.com.avancado.android.projeto.vaivisitar.Utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.util.Log
import br.com.avancado.android.projeto.vaivisitar.MainActivity
import br.com.avancado.android.projeto.vaivisitar.R

object Util {

    var TAG: String = "Vai Visitar"

    fun notificarNovaImagem(titulo: String, mensagem: String, context: Context){

        Log.i(TAG,"notificarNovaImagem")

        //Para rodar no 8 a api minima tem que ser 26 no Gradle
        var manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel("","", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }

        var intent = Intent(context, MainActivity::class.java)


        var pendingIntent = PendingIntent.getActivity(context,0,intent, PendingIntent.FLAG_ONE_SHOT)

        var notification = NotificationCompat.Builder(context, "notificar")
                .setContentIntent(pendingIntent)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setSmallIcon(R.mipmap.ic_launcher,2)
                .setStyle(NotificationCompat.BigTextStyle().bigText(mensagem
                ).setBigContentTitle(titulo))
                .build()

        manager.notify(1,notification)
    }

}