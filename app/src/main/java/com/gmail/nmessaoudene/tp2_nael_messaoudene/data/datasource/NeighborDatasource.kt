package com.gmail.nmessaoudene.tp2_nael_messaoudene.data.datasource

import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

interface NeighborDatasource {

    /**
     * Get all my Neighbors
     * @return [List]
     */
    val neighbors: MutableList<Neighbor>

    /**
     * Deletes a neighbor
     * @param neighbor : Neighbor
     */
    fun deleteNeighbor(neighbor: Neighbor)

    /**
     * Create a neighbour
     * @param neighbor: Neighbor
     */
    fun createNeighbor(neighbor: Neighbor)

    /**
     * Update "Favorite status" of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateFavoriteStatus(neighbor: Neighbor)

    /**
     * Update modified fields of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateNeighbor(neighbor: Neighbor)

}