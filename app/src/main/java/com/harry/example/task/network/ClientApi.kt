package com.harry.example.task.network

import com.harry.example.task.pojo.ApiResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ClientApi {

    @POST("api/android_intern_task")
    @FormUrlEncoded
    suspend fun loginUser(
        @Field("mobile") mobile_number: String, @Field("password") password: String
    ): Response<ApiResponse>?
}