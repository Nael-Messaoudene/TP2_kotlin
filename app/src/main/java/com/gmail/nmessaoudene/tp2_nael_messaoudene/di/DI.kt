package com.gmail.nmessaoudene.tp2_nael_messaoudene.di

import android.app.Application
import com.gmail.nmessaoudene.tp2_nael_messaoudene.repositories.NeighborRepository

object DI {
    lateinit var repository: NeighborRepository
    fun inject(application: Application) {
        repository = NeighborRepository.getInstance(application)
    }
}