package com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.entities.NeighborEntity
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

@Dao
interface NeighborDao {
    @Query("SELECT * from neighbors")
    fun getNeighbors(): LiveData<List<NeighborEntity>>
}