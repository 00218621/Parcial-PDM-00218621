package com.example.repasoparcial.ui.pokemon.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.repasoparcial.data.model.ActorModel
import com.example.repasoparcial.databinding.ItemActorBinding

class ActorRecyclerViewHolder(private val binding: ItemActorBinding): RecyclerView.ViewHolder(binding.root)
{
    fun bind(actor: ActorModel, clickListener: (ActorModel)-> Unit){
    binding.nameActor.text= actor.name
    binding.ageText.text=actor.age
    binding.actorItemCardView.setOnClickListener {
        clickListener(actor)
    }
}
}

