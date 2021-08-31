package com.example.mycalculatorapplication.repository

import com.example.mycalculatorapplication.api.ApiClient
import com.example.mycalculatorapplication.api.ApiInterface
import com.example.mycalculatorapplication.model.AdditionRequest
import com.example.mycalculatorapplication.model.AdditionResponse
import retrofit2.Response

class UserRepository {
    var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun addition(additionRequest: AdditionRequest):Response<AdditionRequest> =
        withContext(Dispatchers.IO){
            var response = retrofit.addition(additionRequest)
            return@withContext response
        }

}