package com.example.repasoparcial.ui.pokemon.newpokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.repasoparcial.databinding.FragmentNewActorBinding
import com.example.repasoparcial.ui.actor.viewmodel.ActorViewModel


class NewActorFragment : Fragment() {

    private val actorViewModel: ActorViewModel by activityViewModels {
        ActorViewModel.Factory
    }

    private lateinit var binding: FragmentNewActorBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPokemon()
        observerStatus()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewActorBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun setViewPokemon(){
        binding.viewModel = actorViewModel
    }
    companion object {
        const val APP_TAG = "APP TAG"
    }
    //TODO: Insert New Actor
    private fun observerStatus(){
        actorViewModel.status.observe(viewLifecycleOwner){ status ->
            when{
                status.equals(ActorViewModel.WRONG_INFORMATION) -> {
                    Toast.makeText(requireContext(), ActorViewModel.WRONG_INFORMATION, Toast.LENGTH_LONG).show()
                    Log.d(APP_TAG,status)
                    actorViewModel.clearStatus()
                }
                status.equals(ActorViewModel.ACTOR_CREATED) -> {
                    Toast.makeText(requireContext(), ActorViewModel.ACTOR_CREATED, Toast.LENGTH_LONG).show()
                    Log.d(APP_TAG,status)
                    Log.d(APP_TAG,actorViewModel.getActors().toString())
                    actorViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }


}

