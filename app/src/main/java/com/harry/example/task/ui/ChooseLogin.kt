package com.harry.example.task.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.harry.example.task.R
import com.harry.example.task.databinding.ChooseLoginBinding

class ChooseLogin : AppCompatActivity() {
    lateinit var chooseLoginBinding: ChooseLoginBinding
    companion object {
        val TAG = "TAG"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chooseLoginBinding = DataBindingUtil.setContentView(this@ChooseLogin,R.layout.activity_choose_login)
        chooseLoginBinding.listener = this@ChooseLogin
    }
    fun toLoginActivity() {
        val intent : Intent = Intent(this@ChooseLogin,LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
        startActivity(intent)
    }
}