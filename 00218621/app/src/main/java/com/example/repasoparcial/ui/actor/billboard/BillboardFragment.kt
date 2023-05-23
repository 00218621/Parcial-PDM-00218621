package com.example.repasoparcial.ui.pokemon.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repasoparcial.R
import com.example.repasoparcial.data.model.ActorModel
import com.example.repasoparcial.databinding.FragmentBillboardBinding
import com.example.repasoparcial.ui.actor.viewmodel.ActorViewModel
import com.example.repasoparcial.ui.pokemon.billboard.recyclerview.ActorRecyclerViewAdapter


class BillboardFragment : Fragment() {

    private val actorViewModel: ActorViewModel by activityViewModels{
        ActorViewModel.Factory
    }
    private lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter: ActorRecyclerViewAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBillboardBinding.inflate(inflater,container,false)
        return  binding.root
    }
    private  fun showSelectedItem(pokemon:ActorModel){
        actorViewModel.setSelectedActor(pokemon)
        findNavController().navigate(R.id.action_billboardFragment_to_actorFragment)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavNewActor.setOnClickListener {
            actorViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newActorFragment)
        }
    }


    private fun displayActors(){
        adapter.setData(actorViewModel.getActors())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = ActorRecyclerViewAdapter{ selectedActor ->
            showSelectedItem(selectedActor)
        }
        binding.recyclerView.adapter = adapter
        displayActors()
    }
    companion object{
        const val INTENT_="OBJECT"
    }

}

