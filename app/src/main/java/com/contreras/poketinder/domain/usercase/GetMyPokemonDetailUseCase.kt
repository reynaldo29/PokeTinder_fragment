package com.contreras.poketinder.domain.usercase

import com.contreras.poketinder.data.PokemonRepository
import com.contreras.poketinder.data.model.PokemonDetailModel
import com.contreras.poketinder.domain.model.MyPokemon
import com.contreras.poketinder.domain.model.Pokemon
import com.contreras.poketinder.ui.view.PokemonDetailActivity
import javax.inject.Inject

class GetMyPokemonDetailUseCase @Inject constructor(
    private val repository:PokemonRepository) {

    suspend operator fun invoke(id:String):PokemonDetailModel{
        return repository.getPokemonDetailFromApi(id)

    }
}