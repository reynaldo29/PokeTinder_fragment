package com.contreras.poketinder.domain.usercase

import com.contreras.poketinder.data.PokemonRepository
import com.contreras.poketinder.data.database.entities.toDatabase
import com.contreras.poketinder.domain.model.MyPokemon
import javax.inject.Inject


class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository){

    suspend operator fun invoke(myPokemon: MyPokemon){
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }
}