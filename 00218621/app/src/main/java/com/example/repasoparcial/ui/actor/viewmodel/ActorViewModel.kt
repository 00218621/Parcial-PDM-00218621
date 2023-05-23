package com.example.repasoparcial.ui.actor.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.repasoparcial.ActorReviewerApplication
import com.example.repasoparcial.data.model.ActorModel
import com.example.repasoparcial.repositories.ActorRepository

class ActorViewModel(private val repository: ActorRepository): ViewModel() {
    var name = MutableLiveData("")
    var age = MutableLiveData("")
    var status = MutableLiveData("")

    //TODO: List actors
    fun getActors()= repository.getActor()
    //TODO: Insert actors
    fun addActors(actor: ActorModel)=repository.addActors(actor)
    //TODO: Validator Data Insert
    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            age.value.isNullOrEmpty() -> return false
        }
        return true
    }
    //TODO: Clear content
    fun clearData(){
        name.value = ""
        age.value = ""
    }
    //TODO: Clear status
    fun clearStatus(){
        status.value = INACTIVE
    }
    //TODO: Select Actor
    fun setSelectedActor(actor: ActorModel){
        name.value = actor.name
        age.value = actor.age
    }
    //TODO: Create new Actor
    fun createActor(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val actor = ActorModel(
            name.value!!,
            age.value!!,
        )
        addActors(actor)
        clearData()
        status.value= ACTOR_CREATED
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ActorReviewerApplication
                ActorViewModel(app.actorReposity)
            }
        }
        const val ACTOR_CREATED = "Actor created"
        const val WRONG_INFORMATION = "Wring information"
        const val INACTIVE = ""
    }
}
