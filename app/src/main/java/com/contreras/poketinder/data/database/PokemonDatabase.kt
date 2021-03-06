package com.contreras.poketinder.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.contreras.poketinder.data.database.dao.PokemonDao
import com.contreras.poketinder.data.database.entities.MyPokemonEntity

//AGREGAR LA VERSION 2, SI SE MODIFICA ENTITIES
@Database(entities = [MyPokemonEntity:: class], version =1)
abstract class PokemonDatabase: RoomDatabase(){
    abstract fun getPokemonDao(): PokemonDao
}