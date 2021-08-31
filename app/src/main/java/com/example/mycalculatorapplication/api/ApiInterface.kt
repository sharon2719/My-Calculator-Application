package com.example.mycalculatorapplication.api

import com.example.mycalculatorapplication.model.AdditionRequest
import com.example.mycalculatorapplication.model.AdditionResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/calculator/add")
    suspend fun addition(@Body additionRequest: AdditionRequest): Response<AdditionResponse>

//    @POST("/students/login")
//    fun logInStudent(@Body loginRequest:LoginRequest): Response<LoginResponse>

}