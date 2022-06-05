package com.contreras.poketinder.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.contreras.poketinder.databinding.ItemPokemonSavedBinding
import com.contreras.poketinder.domain.model.MyPokemon
import com.contreras.poketinder.util.formatNumberto3Digits

class MyPokemonsHolder(view:View): RecyclerView.ViewHolder(view){
    private val binding = ItemPokemonSavedBinding.bind(view)

    fun bind(pokemon:MyPokemon){
        with(binding){
            tvIndex.text= formatNumberto3Digits(pokemon.idPokemon.toInt())
            tvName.text = pokemon.name
            tvType.text=if(pokemon.isLegendary) "Legendary" else "Normal"
            Glide
                .with(itemView)
                .load(pokemon.image)
                .into(binding.ivPokemonLogo)
        }
    }
}