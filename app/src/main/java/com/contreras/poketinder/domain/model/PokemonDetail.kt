package com.contreras.poketinder.domain.model

import com.contreras.poketinder.data.model.PokemonDetailModel
import com.google.gson.annotations.SerializedName

data class PokemonDetail(
     val id: Int,
     val base_experience: Int,
     val height: Int,
     val weight: Int,
     val stats: List<Stats>,
     val types: List<Types>,
     val abilities: List<Abilities>
) {


}
