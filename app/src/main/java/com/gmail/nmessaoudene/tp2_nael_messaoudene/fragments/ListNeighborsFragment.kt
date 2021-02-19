package com.gmail.nmessaoudene.tp2_nael_messaoudene.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ActivityMainBinding.inflate
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ListNeighborsFragmentBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ListNeighborsFragmentBinding.inflate

class ListNeighborsFragment : Fragment(){


    // lateinit permet d'indiquer au compilateur que la variable sera initialisé plus tard -> Dans le onCreateView
    private lateinit var binding: ListNeighborsFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListNeighborsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}