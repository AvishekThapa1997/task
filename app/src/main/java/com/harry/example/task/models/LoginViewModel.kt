package com.harry.example.task.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harry.example.task.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private var dataRepository: DataRepository
    private var resposne: String? = null

    init {
        dataRepository = DataRepository()
    }

    var mobilenumber: String? = null
    var password: String? = null
    var resposneMessage: LiveData<String> = MutableLiveData()

    fun loginUser() {
        viewModelScope.launch(Dispatchers.IO) {
            if (!mobilenumber.isNullOrEmpty() && !password.isNullOrEmpty()) {
                resposne = dataRepository.loginUser(mobilenumber, password)
            } else {
                resposne = "INVAID DATA"
            }
            (resposneMessage as MutableLiveData<String>).postValue(resposne)
        }
    }
}