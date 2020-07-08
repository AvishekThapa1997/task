package com.harry.example.task.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ClientApiImpl {
    private val BASE_URL = "https://mekvahan.com/"
    fun getClient(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}