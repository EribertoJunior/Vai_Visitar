package br.com.avancado.android.projeto.vaivisitar

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.action)){
            
        }

    }
}
