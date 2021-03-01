package com.gmail.nmessaoudene.tp2_nael_messaoudene.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gmail.nmessaoudene.tp2_nael_messaoudene.di.DI
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor
import com.gmail.nmessaoudene.tp2_nael_messaoudene.repositories.NeighborRepository

class NeighborViewModel : ViewModel() {
    private val repository: NeighborRepository = DI.repository

    // On fait passe plat sur le résultat retourné par le repository
    val neighbors: LiveData<List<Neighbor>>
        get() = repository.getNeighbors()
}