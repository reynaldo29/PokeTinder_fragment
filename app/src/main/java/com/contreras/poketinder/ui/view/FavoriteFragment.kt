package com.contreras.poketinder.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.contreras.poketinder.R
import com.contreras.poketinder.databinding.FragmentFavoriteBinding
import com.contreras.poketinder.domain.model.MyPokemon
import com.contreras.poketinder.ui.adapter.MyPokemonsAdapater
import com.contreras.poketinder.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment:BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    private var listMyPokemon = mutableListOf<MyPokemon>()
    private val adapter by lazy{MyPokemonsAdapater(listMyPokemon)}
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        binding.rvPokemons.adapter=adapter

        viewModel.myPokemonList.observe(this){
            listMyPokemon.clear()
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }
        binding.floatingActionDelete.setOnClickListener{
            viewModel.deleteAllPokemon()
            listMyPokemon.clear()
            adapter.notifyDataSetChanged()
        }
    }
}