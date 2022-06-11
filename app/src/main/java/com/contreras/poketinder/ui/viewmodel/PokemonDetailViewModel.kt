package com.contreras.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contreras.poketinder.data.model.PokemonDetailModel
import com.contreras.poketinder.domain.usercase.GetMyPokemonDetailUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getMyPokemonDetailUseCase: GetMyPokemonDetailUseCase
):ViewModel(){
    val pokemonDetailModel = MutableLiveData<PokemonDetailModel>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate(idPokemon:String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMyPokemonDetailUseCase.invoke(idPokemon)
            pokemonDetailModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}