package com.harry.example.task.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harry.example.task.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Thread(object : Runnable {
            override fun run() {
                Thread.sleep(3000)
                val intent: Intent? = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }).start()
    }
}