package com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.memory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.InMemory_NeighborS
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.NeighborDatasource
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

class InMemoryNeighborDataSource :
    NeighborDatasource {

    private val _neighbors = MutableLiveData<List<Neighbor>>()

    init {
        _neighbors.postValue(InMemory_NeighborS)
    }


    override val neighbours: LiveData<List<Neighbor>>
        get() = _neighbors

    override fun deleteNeighbour(neighbor: Neighbor) {
        InMemory_NeighborS.remove(neighbor)
        _neighbors.postValue(InMemory_NeighborS)
    }

    override fun createNeighbour(neighbor: Neighbor) {
        InMemory_NeighborS.add(neighbor)
        _neighbors.postValue(InMemory_NeighborS)
    }


    override fun updateFavoriteStatus(neighbor: Neighbor) {
    }

    override fun updateNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }





    // Liste initial des voisins

}