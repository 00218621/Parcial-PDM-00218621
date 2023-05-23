package com.example.repasoparcial

import android.app.Application
import com.example.repasoparcial.data.actors
import com.example.repasoparcial.repositories.ActorRepository


class ActorReviewerApplication: Application() {
    val actorReposity : ActorRepository by lazy {
        ActorRepository(actors)
    }
}
