package com.contreras.poketinder.util

fun formatNumberto3Digits(number:Int):String ="#${"%03d".format(number)}"

fun getIdPokemonFromUrl(url:String): String = url.split("/").toTypedArray()[6]