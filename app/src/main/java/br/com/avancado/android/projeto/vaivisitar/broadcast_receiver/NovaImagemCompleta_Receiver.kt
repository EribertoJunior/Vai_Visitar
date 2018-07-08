package br.com.avancado.android.projeto.vaivisitar.broadcast_receiver

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.util.Log
import br.com.avancado.android.projeto.vaivisitar.Utils.Util


class NovaImagemCompleta_Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.i(Util.TAG, "NovaImagemCompleta_Receiver")

        //Nova imagem baixada
        var imagemBaixada: Bitmap = intent.getParcelableExtra("imagemString")

        Log.i("imagem baixada", imagemBaixada.toString())

        //Verificar existe o arquivo, se tiver deleta e salva uma nova que chegou.
        //se não tiver, cria um novo com a imagem.
        //var imagemSalva = MainActivity().saveImageToInternalStorage(imagemBaixada as Int)

        Util.notificarNovaImagem(intent.getStringExtra("titulo"), intent.getStringExtra("mensagem"), context)

    }

//    fun mudarImagem(){
//
//
//
//    }

}
