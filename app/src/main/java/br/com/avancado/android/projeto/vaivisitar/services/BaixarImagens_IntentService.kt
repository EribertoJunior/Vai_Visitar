package br.com.avancado.android.projeto.vaivisitar.services

import android.app.AlarmManager
import android.app.IntentService
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import br.com.avancado.android.projeto.vaivisitar.Utils.Util
import com.squareup.picasso.Picasso

private const val BAIXAR_IMAGEM = "baixar_imagem"

private const val EXTRA_PARAM_URL = "url"

class BaixarImagens_IntentService : IntentService("BaixarImagens_IntentService") {

    override fun onHandleIntent(intent: Intent?) {

        Log.i(Util.TAG, "BaixarImagens_IntentService")
        Log.i(Util.TAG, "Seriço rodando")

        var intencao = Intent("NovaImagem")
        intencao.putExtra("imagemString", baixarImagem(intent!!.getStringExtra("url")))
        intencao.putExtra("titulo", "Nova Imagem")
        intencao.putExtra("mensagem", "Veja esse novo lugar incrivel!!")

        val pIntent = PendingIntent.getBroadcast(this, 0, intencao, PendingIntent.FLAG_ONE_SHOT)

        val alarme = getSystemService(ALARM_SERVICE) as AlarmManager
        alarme.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 86400000, pIntent) //1 dia

    }

    private fun baixarImagem(url: String): Bitmap? {

        var imagem: Bitmap = Picasso.get().load(Uri.parse(url)).get()

        Log.i(Util.TAG, imagem.toString())

        return imagem

    }
}