package br.com.avancado.android.projeto.vaivisitar.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import br.com.avancado.android.projeto.vaivisitar.Utils.Util
import com.squareup.picasso.Picasso

class NovaImagemCompleta_Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.i(Util.TAG, "NovaImagemCompleta_Receiver")

        //Nova imagem baixada
        var imagemBaixada: Bitmap = intent.getParcelableExtra("imagemString")

        Log.i("imagem baixada", imagemBaixada.toString())

        Util.notificarNovaImagem(intent.getStringExtra("titulo"), intent.getStringExtra("mensagem"), context)

    }

}
