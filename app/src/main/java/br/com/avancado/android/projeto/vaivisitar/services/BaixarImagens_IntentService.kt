package br.com.avancado.android.projeto.vaivisitar.services

import android.app.AlarmManager
import android.app.IntentService
import android.app.PendingIntent
import android.content.Intent
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.squareup.picasso.Picasso

private const val BAIXAR_IMAGEM = "baixar_imagem"

private const val EXTRA_PARAM_URL = "url"

class BaixarImagens_IntentService : IntentService("BaixarImagens_IntentService") {

    override fun onHandleIntent(intent: Intent?) {

        //val param1 = intent.getStringExtra(EXTRA_PARAM_URL)
        //baixarImagem(param1)

        val pIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        val alarme = getSystemService(ALARM_SERVICE) as AlarmManager
        //alarme.setRepeating(AlarmManager.RTC_WAKEUP, 1, 86400000, pIntent)
        alarme.setRepeating(AlarmManager.RTC_WAKEUP, 1, 86400000, pIntent)

        /*when (intent?.action) {

            BAIXAR_IMAGEM -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM_URL)
                baixarImagem(param1)

                val pIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

                val alarme = getSystemService(ALARM_SERVICE) as AlarmManager
                //alarme.setRepeating(AlarmManager.RTC_WAKEUP, 1, 86400000, pIntent)
                alarme.setRepeating(AlarmManager.RTC_WAKEUP, 1, 86400000, pIntent)
            }

        }*/
    }



    private fun baixarImagem(url: String) {

        var imagem: Bitmap = Picasso.get().load(Uri.parse(url)).get()

    }
}
