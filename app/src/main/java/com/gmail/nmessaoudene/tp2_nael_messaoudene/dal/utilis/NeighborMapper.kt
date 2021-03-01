package com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.utilis

import com.gmail.nmessaoudene.tp2_nael_messaoudene.dal.room.entities.NeighborEntity
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

fun NeighborEntity.toNeighbor() = Neighbor(
    id = id,
    name = name,
    avatarUrl = avatarUrl,
    address = address,
    phoneNumber = phoneNumber,
    aboutMe = aboutMe,
    favorite = favorite,
    webSite = webSite ?: ""
)