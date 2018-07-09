package br.com.avancado.android.projeto.vaivisitar.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import br.com.avancado.android.projeto.vaivisitar.Utils.Util
import br.com.avancado.android.projeto.vaivisitar.services.BaixarImagens_IntentService

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (Intent.ACTION_BOOT_COMPLETED == intent.action){
            Log.i(Util.TAG, "MyReceiver (systema iniciado)")

            context.startService(Intent(context, BaixarImagens_IntentService::class.java)
                    .putExtra("url", "https://i2.wp.com/blog.venturas.com.br/wp-content/uploads/2016/09/Skogarfoss.jpg"))

        }

    }
}
