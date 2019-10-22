package com.y.cathandler

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.y.handler_library.Handler
import com.y.handler_library.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("onCreate", "onCreate")

        val mHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                Log.e("handleMessage:${Thread.currentThread().id}", msg.obj.toString())
            }
        }

        btn1.setOnClickListener {
            Thread(Runnable {
                Log.e("Message:${Thread.currentThread().id}", "send")
                    val msg = Message()
                    msg.obj = "params"
                    mHandler.sendMessage(msg)
            }).start()
        }
    }
}
