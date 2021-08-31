package com.example.mycalculatorapplication.model

import com.google.gson.annotations.SerializedName

data class AdditionRequest(
    @SerializedName("number_one") var number1:Int,
    @SerializedName("number_two") var number2:Int,
)
