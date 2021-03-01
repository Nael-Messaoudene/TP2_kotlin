package com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.NeighborDatasource
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.daos.NeighborDao
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.utilis.toNeighbor
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

class RoomNeighborDataSource(application: Application) : NeighborDatasource {
    private val database: NeighborDataBase = NeighborDataBase.getDataBase(application)
    private val dao: NeighborDao = database.neighborDao()

    private val _neighors = MediatorLiveData<List<Neighbor>>()

    init {
        _neighors.addSource(dao.getNeighbors()) { entities ->
            _neighors.value = entities.map { entity ->
                entity.toNeighbor()
            }
        }
    }

    override val neighbours: MutableLiveData<List<Neighbor>>
        get() = _neighors

    override fun deleteNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }

    override fun createNeighbour(neighbor: Neighbor) {
      //database.neighborDao().add(neighbor = neighbor)
        dao.add(neighbor.toEntity())
    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }

    override fun updateNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }
}