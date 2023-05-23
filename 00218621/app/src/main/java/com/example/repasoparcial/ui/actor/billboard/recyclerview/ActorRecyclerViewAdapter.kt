package com.example.repasoparcial.ui.pokemon.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repasoparcial.data.model.ActorModel
import com.example.repasoparcial.databinding.ItemActorBinding

class ActorRecyclerViewAdapter(private val clickListener: (ActorModel) -> Unit
): RecyclerView.Adapter<ActorRecyclerViewHolder>() {
    private val actors = ArrayList<ActorModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorRecyclerViewHolder {
        val binding = ItemActorBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ActorRecyclerViewHolder(binding)
    }

    //TODO: Count of Item Actor
    override fun getItemCount(): Int {
        return actors.size
    }

    override fun onBindViewHolder(holder: ActorRecyclerViewHolder, position: Int) {
        var pokemon = actors[position]
        holder.bind(pokemon,clickListener)
    }

    //TODO: List of Actors
    fun setData(actorList: List<ActorModel>){
        actors.clear()
        actors.addAll(actorList)
    }

}

