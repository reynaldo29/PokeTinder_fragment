package com.contreras.poketinder.domain.usercase

import com.contreras.poketinder.data.PokemonRepository
import javax.inject.Inject

class DeleteAllMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(){
        pokemonRepository.deleteAllmyPokemon()
    }
}