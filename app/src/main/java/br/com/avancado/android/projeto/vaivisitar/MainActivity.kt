package br.com.avancado.android.projeto.vaivisitar

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.avancado.android.projeto.vaivisitar.Utils.Util
import br.com.avancado.android.projeto.vaivisitar.services.BaixarImagens_IntentService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TODO: aqui deve haver a logica de carregar a imagem que foi salva em algum diretorio do aparelho

        if (intent.hasExtra("imagemString")) {
            Log.i(Util.TAG, "chegou a imagem")

        }else{
            startService(Intent(this, BaixarImagens_IntentService::class.java)
                    .putExtra("url", "https://media-cdn.tripadvisor.com/media/photo-s/07/aa/1a/ba/lugar-incrivel.jpg"))
        }

    }
}
