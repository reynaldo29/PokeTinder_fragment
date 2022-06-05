package com.contreras.poketinder.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contreras.poketinder.R
import com.contreras.poketinder.domain.model.MyPokemon
import com.contreras.poketinder.ui.holder.MyPokemonsHolder
import com.contreras.poketinder.util.inflate

class MyPokemonsAdapater(val list:List<MyPokemon>) :
    RecyclerView.Adapter<MyPokemonsHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = parent.inflate(R.layout.item_pokemon_saved)
        return MyPokemonsHolder(view)
    }

    override fun onBindViewHolder(holder: MyPokemonsHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount():Int = list.size
    }
