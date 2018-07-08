package br.com.avancado.android.projeto.vaivisitar

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import br.com.avancado.android.projeto.vaivisitar.services.BaixarImagens_IntentService
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import android.os.Environment.getExternalStorageDirectory
import android.R.attr.path
import android.util.Log
import android.widget.ImageView
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TODO: aqui deve haver a logica de carregar a imagem que foi salva em algum diretorio do aparelho

        //Verificar se existe uma imagem. Se existir deverá ser exibido no imageview, se não existir, deverá ser chamado o startservice

        val filePath = getExternalStorageDirectory()
                .absolutePath + File.separator

        val imgFile = File(filePath + "imagem.jpg")

        if (imgFile.exists()) {

            val myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath() + "imagem.jpg") //this is the bitmap for the image

            val myImage = findViewById(R.id.imageView) as ImageView         //your image view in the recycler view

            myImage.setImageBitmap(myBitmap)//image set to the image view

        } else {

            startService(Intent(this, BaixarImagens_IntentService::class.java)
                    .putExtra("url", "https://media-cdn.tripadvisor.com/media/photo-s/07/aa/1a/ba/lugar-incrivel.jpg"))

        }


//        if (filePath == null){
//
//            startService(Intent(this, BaixarImagens_IntentService::class.java)
//                    .putExtra("url", "https://media-cdn.tripadvisor.com/media/photo-s/07/aa/1a/ba/lugar-incrivel.jpg"))
//
//        } else {
//
//            //saveImageToInternalStorage(R.drawable.internet)
//
//            val bitmap : Bitmap = BitmapFactory.decodeFile(filePath)
//
//            imageView.setImageBitmap(bitmap)
//
//            //ou
//
//            //val caminho : Uri = saveImageToInternalStorage(R.drawable.internet)
//            //imageView.setImageURI(caminho)
//
//        }

//        if (intent.hasExtra("imagemString")) {
//            Log.i(Util.TAG, "chegou a imagem")
//
//        } else {
//            startService(Intent(this, BaixarImagens_IntentService::class.java)
//                    .putExtra("url", "https://media-cdn.tripadvisor.com/media/photo-s/07/aa/1a/ba/lugar-incrivel.jpg"))
//        }

    }

    fun saveImageToInternalStorage(drawableId: Int) : Uri {

        val drawable = ContextCompat.getDrawable(applicationContext, drawableId)

        val bitmap = (drawable as BitmapDrawable).bitmap

        val wrapper = ContextWrapper(applicationContext)

        var file = wrapper.getDir("images", Context.MODE_PRIVATE)

        file = File(file, "imagem.jpg")

        try {

            val stream: OutputStream = FileOutputStream(file)


            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)


            stream.flush()


            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        // Retorna o caminho da imagem salvada

        return Uri.parse(file.absolutePath)
    }

}
