package com.contreras.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.contreras.poketinder.data.FirebaseRemoteConfigRepository

class SplashViewModel:ViewModel() {

    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }

    fun getIsUnderMaintance(): MutableLiveData<Boolean>{
        return firebaseRemoteConfigRepository.isUnderMaintanceLiveData
    }
}