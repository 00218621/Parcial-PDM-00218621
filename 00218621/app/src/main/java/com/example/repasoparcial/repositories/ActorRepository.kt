package com.example.repasoparcial.repositories

import com.example.repasoparcial.data.model.ActorModel


// TODO: Implement Repository
class ActorRepository(private val actors: MutableList<ActorModel>) {
    fun getActor()= actors
    fun addActors(actor: ActorModel)=actors.add(index = 0, actor)
}
