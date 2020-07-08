package com.harry.example.task.repository

import android.util.Log
import com.harry.example.task.network.ClientApi
import com.harry.example.task.network.ClientApiImpl
import com.harry.example.task.pojo.ApiResponse
import retrofit2.Response
import retrofit2.Retrofit
import java.net.UnknownHostException


class DataRepository {
    var clientApi: ClientApi
    init {
        val retrofit: Retrofit = ClientApiImpl.getClient()
        clientApi = retrofit.create(ClientApi::class.java)
    }

    suspend fun loginUser(mobileNumber: String?, password: String?): String? {
        var response: Response<ApiResponse>? = null
        if (!mobileNumber.isNullOrEmpty() && !password.isNullOrBlank()) {
            try{
                response = clientApi.loginUser(mobileNumber, password)
            }catch (exception:UnknownHostException){
               return "No Internet"
            }
        }
        if (response != null) {
            if (response.isSuccessful) {
                return response.body()?.response.toString()
            }
        }
        return null
    }
}
