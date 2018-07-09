package br.com.avancado.android.projeto.vaivisitar.broadcast_receiver

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Environment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.ImageView
import br.com.avancado.android.projeto.vaivisitar.MainActivity
import br.com.avancado.android.projeto.vaivisitar.R
import br.com.avancado.android.projeto.vaivisitar.Utils.Util
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.net.URI


class NovaImagemCompleta_Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.i(Util.TAG, "NovaImagemCompleta_Receiver")

        //Nova imagem baixada
        var imagemBaixada: Bitmap = intent.getParcelableExtra("imagemString")

        Log.i("imagem baixada", imagemBaixada.toString())

        //Verificar existe o arquivo, se tiver deleta e salva uma nova que chegou.
        //se não tiver, cria um novo com a imagem.
        val filePath = Environment.getExternalStorageDirectory()
                .absolutePath + File.separator + "imagem.jpg"

        val imgFile = File(filePath + "imagem.jpg")

        if (filePath == null){

            var imagemsSalva = MainActivity().saveImageToInternalStorage(imagemBaixada as Int)

            val myImage = R.id.imageView  as ImageView     //your image view in the recycler view
            myImage.setImageURI(imagemsSalva)                         //image set to the image view


        } else {

            val bitmap : Bitmap = BitmapFactory.decodeFile(filePath)

            val myImage = (R.id.imageView) as ImageView

            myImage.setImageBitmap(bitmap)

        }

        Util.notificarNovaImagem(intent.getStringExtra("titulo"), intent.getStringExtra("mensagem"), context)

    }
    

}
