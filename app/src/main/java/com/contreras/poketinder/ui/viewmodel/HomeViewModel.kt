package com.contreras.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contreras.poketinder.domain.model.MyPokemon
import com.contreras.poketinder.domain.model.Pokemon
import com.contreras.poketinder.domain.usercase.GetPokemonsUseCase
import com.contreras.poketinder.domain.usercase.SaveMyPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val saveMyPokemonUseCase: SaveMyPokemonUseCase
):ViewModel(){

    val pokemonList = MutableLiveData<List<Pokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonsUseCase()
            pokemonList.postValue(result)
            isLoading.postValue(false)
        }
    }

    fun savePokemonUseCase(myPokemon: MyPokemon){
        viewModelScope.launch {
            isLoading.postValue(true)
            saveMyPokemonUseCase.invoke(myPokemon)
            isLoading.postValue(false)
        }
    }
}
