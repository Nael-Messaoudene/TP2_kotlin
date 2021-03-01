package com.gmail.nmessaoudene.tp2_nael_messaoudene.dal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

interface NeighborDatasource {

    /**
     * Get all my Neighbors
     * @return [List]
     */
    val neighbours: MutableLiveData<List<Neighbor>>

    /**
     * Deletes a neighbor
     * @param neighbor : Neighbor
     */
    fun deleteNeighbour(neighbor: Neighbor)

    /**
     * Create a neighbour
     * @param neighbor: Neighbor
     */
    fun createNeighbour(neighbor: Neighbor)

    /**
     * Update "Favorite status" of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateFavoriteStatus(neighbor: Neighbor)

    /**
     * Update modified fields of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateNeighbour(neighbor: Neighbor)
}