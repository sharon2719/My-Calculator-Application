package com.example.mycalculatorapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycalculatorapplication.model.AdditionRequest
import com.example.mycalculatorapplication.model.AdditionResponse
import com.example.mycalculatorapplication.repository.UserRepository

class AdditionViewModel:ViewModel(){

    var userRepository=UserRepository()
    var additionLiveData= MutableLiveData<AdditionResponse>()
    var errorLiveData= MutableLiveData<String>()

    fun addition(additionRequest: AdditionRequest){
        viewModelScope.launch{
            var response=userRepository.addition(additionRequest)
            if (response.isSuccessful){

               additionLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }

        }
    }
}
}