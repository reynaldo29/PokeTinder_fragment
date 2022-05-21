package com.contreras.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.contreras.poketinder.data.model.User
import com.contreras.poketinder.util.SharedPreferenceUtil

class LoginViewModel(private val context:Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldError = MutableLiveData<Boolean>()
    val fieldsAuthenticateError = MutableLiveData<Boolean>()
    val goSuccesActivity = MutableLiveData<Boolean>()

    fun onCreate(){

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(email:String,password:String){
        if(email.isEmpty() && password.isEmpty()){
            emptyFieldError.postValue(true)
        }

        val user: User? = sharedPreferenceUtil.getUser()

        if(email.equals(user?.email) && password.equals(user?.password)){
            goSuccesActivity.postValue(true)
        }else{
            fieldsAuthenticateError.postValue(true)
        }
    }
}