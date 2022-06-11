package com.contreras.poketinder.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.contreras.poketinder.databinding.ActivityPokemonDetailBinding
import com.contreras.poketinder.ui.viewmodel.PokemonDetailViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity: BaseActivity<ActivityPokemonDetailBinding>(ActivityPokemonDetailBinding::inflate) {
    private val pokemonDetailViewModel : PokemonDetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pokemonDetailViewModel.isLoading.observe(this) {
            binding.progressBar2.isVisible = it
        }
        pokemonDetailViewModel.pokemonDetailModel.observe(this){

            val imge: String =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${it.id}.png"

            Glide
                .with(this)
                .load(imge)
                .into(binding.ivPokemonLogo)

            binding.tvPosition.text = "#000"+it.id.toString()
            binding.tvName.text = it.name
            binding.tvAltura.text = it.height.toString()
            binding.tvPeso.text = it.weight.toString()
            binding.tvExperienciaBase.text = it.base_experience.toString()
            binding.tvHabilidades.text = it.abilities.elementAt(0)
                .ability.name+ ","+ it.abilities.elementAt(1).ability.name

            binding.tvEstadisticas.text = it.stats.elementAt(0).base_stat.toString()

            binding.tvTipo.text = it.types.elementAt(0).type.name

        }

        val pokemonId = intent?.extras?.getString("ID_POKEMON",null)

        if (pokemonId != null) {
            pokemonDetailViewModel.onCreate(pokemonId)
        }

        if(pokemonId != null){
            Toast.makeText(this,"PokemonId:$pokemonId",Toast.LENGTH_SHORT).show()
        }
    }
}