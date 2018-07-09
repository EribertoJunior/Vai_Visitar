package br.com.avancado.android.projeto.vaivisitar.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Environment
import android.util.Log
import br.com.avancado.android.projeto.vaivisitar.Utils.Util
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class NovaImagemCompleta_Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.i(Util.TAG, "NovaImagemCompleta_Receiver")

        //Nova imagem baixada
        var imagemBaixada: Bitmap = intent.getParcelableExtra("imagemString")

        Log.i("imagem baixada", imagemBaixada.toString())

        //Verificar existe o arquivo, se tiver deleta e salva uma nova que chegou.
        //se não tiver, cria um novo com a imagem.

        val imgFile = File(Environment.getExternalStorageDirectory().absolutePath + File.separator + "imagem.jpg")

        if (imgFile.exists()) {
            Log.i(Util.TAG, "Existe um arquivo com esse nome")
            Log.i(Util.TAG, "deleta imagem existente")
            imgFile.delete() //deleta imagem existente
            salvarImagem(imagemBaixada) // salva a imagim baixada

        } else {
            Log.i(Util.TAG, "Não existe um arquivo com esse nome")
            salvarImagem(imagemBaixada)// salva a imagim baixada
        }

        Util.notificarNovaImagem(intent.getStringExtra("titulo"), intent.getStringExtra("mensagem"), context)

    }

    fun salvarImagem(imagem: Bitmap) {
        Log.i(Util.TAG, "Salvando nova Imagem")
        try {
            val stream = ByteArrayOutputStream()
            imagem.compress(Bitmap.CompressFormat.PNG, 100, stream)

            val bytes = stream.toByteArray()
            val nomeArquivo = Environment.getExternalStorageDirectory().absolutePath + File.separator + "imagem.jpg"

            val fos = FileOutputStream(nomeArquivo)
            fos.write(bytes)
            fos.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
