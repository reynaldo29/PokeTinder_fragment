package com.contreras.poketinder.domain.usercase

import com.contreras.poketinder.data.PokemonRepository
import com.contreras.poketinder.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository:PokemonRepository) {
    suspend operator fun invoke():List<Pokemon>{
        return repository.getAllPokemonFromApi()
    }
}