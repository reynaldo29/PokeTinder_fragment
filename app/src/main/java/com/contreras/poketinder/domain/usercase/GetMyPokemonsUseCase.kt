package com.contreras.poketinder.domain.usercase

import com.contreras.poketinder.data.PokemonRepository
import com.contreras.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository){
    suspend operator fun invoke():List<MyPokemon>{
        return pokemonRepository.getMyPokemonsFromDatabase()
    }

}
