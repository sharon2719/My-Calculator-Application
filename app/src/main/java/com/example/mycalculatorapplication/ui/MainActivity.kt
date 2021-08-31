package com.example.mycalculatorapplication.ui

import android.app.Instrumentation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.mycalculatorapplication.R
import com.example.mycalculatorapplication.viewmodel.AdditionViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val addtionViewModel:AdditionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        addtionViewModel.additionLiveData.observe(this,{addResponse->
            if(!addResponse.result.isNullOrEmpty()){
                Toast.makeText(baseContext,"Results",Toast.LENGTH_LONG).show()
            }

        })
        addtionViewModel.errorLiveData.observe(this,{error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    fun result(){
        binding.btnAddition.setOnClickListener{
            var error=false
            if (etNumber1.text.toString()==""{
                Toast.makeText(baseContext,"Enter a number",Toast.LENGTH_LONG).show()
            }
            else if (etNumber2.text.toString()==""){
                Toast.makeText(baseContext,"Enter a number",Toast.LENGTH_LONG).show()

            }
            else{
                var number1=etNumber1.text.toString().toInt()
                var number2=etNumber2.text.toString().toint()
                var total=number1+number2
                tvAnswer.text="Answer:${addTotal}"

            }

            )
        }

    }
}
data class Results(var number1:Int,var number2:Int)