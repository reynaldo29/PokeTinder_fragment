package com.contreras.poketinder.data

import androidx.lifecycle.MutableLiveData
import com.contreras.poketinder.R
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get

class FirebaseRemoteConfigRepository {

    val instance = FirebaseRemoteConfig.getInstance()
    val getUrlPokemonLiveData: MutableLiveData<String> = MutableLiveData()
    val isUnderMaintanceLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun init(){
        instance.setDefaultsAsync(R.xml.remote_config_defaults)
        instance.fetchAndActivate().addOnCompleteListener{task ->
            if(task.isSuccessful){
                getUrlPokemonLiveData.value = getUrlPokemonLive()
                isUnderMaintanceLiveData.value = getIsUnderMaintance()

            }
        }
    }

    private fun getIsUnderMaintance(): Boolean? {
        return instance["is_under_maintance"].asBoolean()

    }

    private fun getUrlPokemonLive(): String? {
        return instance["url_pokemon_live"].asString()

    }

}