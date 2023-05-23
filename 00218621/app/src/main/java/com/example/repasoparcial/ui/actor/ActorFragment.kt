package com.example.repasoparcial.ui.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.repasoparcial.databinding.FragmentActorBinding
import com.example.repasoparcial.ui.actor.viewmodel.ActorViewModel


class ActorFragment : Fragment() {

    private val actorViewModel: ActorViewModel by activityViewModels{
        ActorViewModel.Factory
    }

    private lateinit var binding: FragmentActorBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewActor()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentActorBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun setViewActor(){
        binding.viewModel = actorViewModel

    }

}