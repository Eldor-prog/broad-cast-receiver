package uz.eldor.lesson14broadcast

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val receiver = MyReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver.setOnChangeListener {
            text_view.text = "$it"
        }

        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, IntentFilter("ACTION_NEW_MESSAGE"))
        button.setOnClickListener {
            val intent = Intent("ACTION_NEW_MESSAGE")
            intent.putExtra("NAME", "Salom")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
//        registerReceiver(receiver, IntentFilter("ACTION_NEW_MESSAGE"))

    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver)
    }
}