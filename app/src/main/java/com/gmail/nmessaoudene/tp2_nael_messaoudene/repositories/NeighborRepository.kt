package com.gmail.nmessaoudene.tp2_nael_messaoudene.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.memory.InMemoryNeighborDataSource
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.NeighborDatasource
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.RoomNeighborDataSource
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

class NeighborRepository private constructor(application: Application) {
    private val dataSource: NeighborDatasource

    init {
        dataSource = RoomNeighborDataSource(application)
    }

    // Méthode qui retourne la liste des voisins
    fun getNeighbors(): LiveData<List<Neighbor>> = dataSource.neighbours

    fun delete(neighbor: Neighbor) = dataSource.deleteNeighbour(neighbor)
    fun createNeighbor(neighbor: Neighbor) = dataSource.createNeighbour(neighbor)

    companion object {
        private var instance: NeighborRepository? = null

        // On crée un méthode qui retourne l'instance courante du repository si elle existe ou en crée une nouvelle sinon
        fun getInstance(application: Application): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository(application)
            }
            return instance!!
        }
    }
}

