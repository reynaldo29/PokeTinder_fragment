package com.contreras.poketinder.data

import com.contreras.poketinder.data.model.PokemonListModel
import com.contreras.poketinder.data.model.PokemonModel
import com.contreras.poketinder.data.network.PokemonService
import com.contreras.poketinder.domain.model.Pokemon
import com.contreras.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi():List<Pokemon>{
        val listResponse : PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }
}