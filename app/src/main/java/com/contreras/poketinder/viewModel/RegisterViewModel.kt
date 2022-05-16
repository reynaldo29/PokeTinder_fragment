package com.contreras.poketinder.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.contreras.poketinder.data.model.User
import com.contreras.poketinder.util.SharedPreferenceUtil

class RegisterViewModel(private val context:Context):ViewModel() {
    private lateinit var SharedPreferenceUtil:SharedPreferenceUtil

    val emptyField = MutableLiveData<Boolean>()
    val registerFielsdError = MutableLiveData<Boolean>()
    val goSuccesActivity = MutableLiveData<Boolean>()

    fun onCreate(){
        SharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }
    fun validateInputs(email:String,password:String,password2:String,username:String){
        if(email.isEmpty() || password.isEmpty() || password2.isEmpty() ||
            username.isEmpty()){
            emptyField.postValue(true)
        }
        val user = User(
            "1",
            username,
            email,
            password)
        SharedPreferenceUtil.saveFacebookUser(user)

        if(email.isNotEmpty() && password.isNotEmpty() &&
            username.isNotEmpty() && password2.isNotEmpty()  && password.length>5){
            goSuccesActivity.postValue(true)
        }else{
            registerFielsdError.postValue(true)
        }
    }
}