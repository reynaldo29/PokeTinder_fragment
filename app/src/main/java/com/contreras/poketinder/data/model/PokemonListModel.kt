package com.contreras.poketinder.data.model

import com.google.gson.annotations.SerializedName
data class PokemonListModel (
    @SerializedName("count") val count:Int,
    @SerializedName("results") val results:List<PokemonModel>)
