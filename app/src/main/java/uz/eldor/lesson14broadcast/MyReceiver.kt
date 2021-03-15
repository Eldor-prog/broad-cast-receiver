package uz.eldor.lesson14broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    private var  TAG = "MyReceiver"
    private var listener : ((Boolean)->Unit)? = null

    fun setOnChangeListener(block:(Boolean)->Unit){
        listener = block
    }

    override fun onReceive(context: Context?, intent: Intent) {
        Log.d(TAG, "onReceive: ${intent.getStringExtra("NAME")}")

       /*val toast = Toast.makeText(context,"MyReceiver",Toast.LENGTH_SHORT)
        toast.show()*/
       /* Log.d(TAG, "onReceive: MyReceiver")
        val state = intent.getBooleanExtra("state",false)

        listener?.invoke(state)*/
    }
}