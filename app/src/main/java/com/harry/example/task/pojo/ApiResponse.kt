package com.harry.example.task.pojo

import com.google.gson.annotations.SerializedName

data class ApiResponse(@SerializedName("status") val response:Boolean?) {
}