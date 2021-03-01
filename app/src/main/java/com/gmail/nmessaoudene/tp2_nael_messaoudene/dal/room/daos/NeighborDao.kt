package com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.entities.NeighborEntity

@Dao
interface NeighborDao {
    @Query("SELECT * from neighbors")
    fun getNeighbors(): LiveData<List<NeighborEntity>>
    @Insert
    fun add(neighbor: NeighborEntity)
}