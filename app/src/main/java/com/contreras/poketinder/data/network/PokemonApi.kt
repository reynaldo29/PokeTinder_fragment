package com.contreras.poketinder.data.network

import com.contreras.poketinder.data.model.PokemonDetailModel
import com.contreras.poketinder.data.model.PokemonListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("?limit=20")
    suspend fun getPokemons(): Response<PokemonListModel>

    @GET("{pokemon_id}")
    suspend fun getDetailPokemon(
        @Path("pokemon_id") pokemonId:String
    ):Response<PokemonDetailModel>
}