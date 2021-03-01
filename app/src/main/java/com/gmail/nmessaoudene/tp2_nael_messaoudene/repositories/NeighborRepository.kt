package com.gmail.nmessaoudene.tp2_nael_messaoudene.repositories

import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.memory.InMemoryNeighborDataSource
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.NeighborDatasource
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

class NeighborRepository {
    private val dataSource: NeighborDatasource

    init {
        dataSource =
            InMemoryNeighborDataSource()
    }

    // Méthode qui retourne la liste des voisins
    fun getNeighbours(): MutableList<Neighbor> = dataSource.neighbors

    companion object {
        private var instance: NeighborRepository? = null

        // On crée un méthode qui retourne l'instance courante du repository si elle existe ou en crée une nouvelle sinon
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }

    fun delete(neighbor: Neighbor){
        dataSource.deleteNeighbor(neighbor)
    }

    fun createNeighbor(neighbor: Neighbor) = dataSource.createNeighbor(neighbor)

}