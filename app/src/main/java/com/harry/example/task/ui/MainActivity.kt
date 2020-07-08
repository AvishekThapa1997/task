package com.harry.example.task.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.harry.example.task.R
import com.harry.example.task.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityBinding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding =
            DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        mainActivityBinding.listener = this@MainActivity
    }

    fun toLoginActivity() {
        val intent : Intent = Intent(this@MainActivity,ChooseLogin::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
        startActivity(intent)
    }
}