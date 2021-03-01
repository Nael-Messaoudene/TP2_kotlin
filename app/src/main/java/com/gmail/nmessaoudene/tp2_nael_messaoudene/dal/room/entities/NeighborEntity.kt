package com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

@Entity(tableName = "neighbors")
class NeighborEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String,
    var avatarUrl: String,
    val address: String,
    var phoneNumber: String,
    var aboutMe: String,
    var favorite: Boolean = false,
    var webSite: String? = null
)