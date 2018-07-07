package br.com.avancado.android.projeto.vaivisitar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.avancado.android.projeto.vaivisitar.services.BaixarImagens_IntentService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startService(Intent(this, BaixarImagens_IntentService::class.java)
                .putExtra("url","https://media-cdn.tripadvisor.com/media/photo-s/07/aa/1a/ba/lugar-incrivel.jpg"))
    }
}
