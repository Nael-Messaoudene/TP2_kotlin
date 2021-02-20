package com.gmail.nmessaoudene.tp2_nael_messaoudene.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.nmessaoudene.tp2_nael_messaoudene.NavigationListener
import com.gmail.nmessaoudene.tp2_nael_messaoudene.R
import com.gmail.nmessaoudene.tp2_nael_messaoudene.adapters.ListNeighborHandler
import com.gmail.nmessaoudene.tp2_nael_messaoudene.adapters.ListNeighborsAdapter
import com.gmail.nmessaoudene.tp2_nael_messaoudene.data.NeighborRepository
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ListNeighborsFragmentBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor


class ListNeighborsFragment : ListNeighborHandler, NavigationListener,Fragment(){


    // lateinit permet d'indiquer au compilateur que la variable sera initialisé plus tard -> Dans le onCreateView
    private lateinit var binding: ListNeighborsFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListNeighborsFragmentBinding.inflate(inflater, container, false)
        binding.neighborsList.layoutManager = LinearLayoutManager(context)
        binding.neighborsList.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors,this)
        binding.neighborsList.adapter = adapter


        binding.addNeighbor.setOnClickListener(View.OnClickListener {
            //callback.onDeleteNeibor(mNeighbours[position])
            //notifyDataSetChanged()
            // displayAlertDialog(neighbour)
            //showAlertDialog(position)
            Log.v("switch neighbors","ekip ekip")

            showFragment(AddNeighbourFragment())
            //showFr
        })

    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        NeighborRepository.getInstance().delete(neighbor)
    }

    override fun showFragment(fragment: Fragment) {
        //

       // fragmentManager

        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }?.commit()
    }


}