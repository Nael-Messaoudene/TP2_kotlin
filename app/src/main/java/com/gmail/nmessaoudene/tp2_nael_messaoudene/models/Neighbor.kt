package com.gmail.nmessaoudene.tp2_nael_messaoudene.models

import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.entities.NeighborEntity

data class Neighbor (
    val id: Long,
    val name: String,
    val avatarUrl: String,
    val address: String,
    val phoneNumber: String,
    val aboutMe: String,
    val favorite: Boolean,
    val webSite: String
    ) {
    fun toEntity(): NeighborEntity {
        return NeighborEntity( id, name, avatarUrl, address, phoneNumber, aboutMe, favorite, webSite)
    }
}