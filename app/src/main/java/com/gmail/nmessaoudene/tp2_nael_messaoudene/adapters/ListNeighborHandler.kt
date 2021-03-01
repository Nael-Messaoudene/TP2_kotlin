package com.gmail.nmessaoudene.tp2_nael_messaoudene.adapters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

interface ListNeighborHandler {

    fun onDeleteNeibor(neighbor: Neighbor)

    //fun onCreate

}