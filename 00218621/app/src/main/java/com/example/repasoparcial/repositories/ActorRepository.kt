package com.example.repasoparcial.repositories

import com.example.repasoparcial.data.model.ActorModel


// TODO: Implement Repository
class ActorRepository(private val actors: MutableList<ActorModel>) {
    fun getActor()= actors
    fun addActors(actor: ActorModel)=actors.add(index = 0, actor)
}

/*
//TODO:Implement Repository
class PokemonRepository(private val pokemons: MutableList<PokemonModel>) {
    fun getPokemons()= pokemons
    fun addPokemons(pokemon: PokemonModel)=pokemons.add(index = 0,pokemon)
}
* */