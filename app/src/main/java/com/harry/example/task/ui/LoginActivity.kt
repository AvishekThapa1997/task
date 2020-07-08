package com.harry.example.task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.harry.example.task.R
import com.harry.example.task.databinding.LoginActivityBinding
import com.harry.example.task.models.LoginViewModel
import es.dmoral.toasty.Toasty

class LoginActivity : AppCompatActivity() {
    lateinit var loginActivityBinding: LoginActivityBinding
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginActivityBinding =
            DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)
        initViewModel()
        loginActivityBinding.loginViewmodelListener = loginViewModel
    }

    private fun initViewModel() {
        loginViewModel = ViewModelProvider(this@LoginActivity).get(LoginViewModel::class.java)
        loginViewModel.resposneMessage.observe(this, Observer {
            if (it == "true") {
                Toasty.success(
                    applicationContext,
                    applicationContext.resources.getString(R.string.success),
                    Toast.LENGTH_LONG
                ).show()
                initViews()
            } else if (it == "false")
                Toasty.error(
                    applicationContext,
                    applicationContext.resources.getString(R.string.failure),
                    Toast.LENGTH_LONG
                ).show()
            else if (it == "No Internet")
                Toasty.warning(
                    applicationContext,
                    applicationContext.resources.getString(R.string.connection),
                    Toast.LENGTH_LONG
                ).show()
            else
                Toasty.warning(
                    applicationContext,
                    applicationContext.resources.getString(R.string.invalid_credentials),
                    Toast.LENGTH_LONG
                ).show()

        })
    }

    private fun initViews() {
        loginActivityBinding.mobileNumber.setText("")
        loginActivityBinding.userPassword.setText("")
    }
}