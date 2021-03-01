package com.gmail.nmessaoudene.tp2_nael_messaoudene.ui.fragments

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.nmessaoudene.tp2_nael_messaoudene.NavigationListener
import com.gmail.nmessaoudene.tp2_nael_messaoudene.R
import com.gmail.nmessaoudene.tp2_nael_messaoudene.adapters.ListNeighborHandler
import com.gmail.nmessaoudene.tp2_nael_messaoudene.adapters.ListNeighborsAdapter
import com.gmail.nmessaoudene.tp2_nael_messaoudene.repositories.NeighborRepository
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ListNeighborsFragmentBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.di.DI
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor
import com.gmail.nmessaoudene.tp2_nael_messaoudene.viewmodels.NeighborViewModel
import java.util.concurrent.Executors


class ListNeighborsFragment : ListNeighborHandler,Fragment(){

    // lateinit permet d'indiquer au compilateur que la variable sera initialisé plus tard -> Dans le onCreateView
    private lateinit var binding: ListNeighborsFragmentBinding
    private lateinit var viewModel: NeighborViewModel

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NeighborViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()

        binding.addNeighbor.setOnClickListener(View.OnClickListener {

            Log.v("switch neighbors","ekip ekip")
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
            }

        })

        (activity as? NavigationListener)?.let {
            it.updateTitle(R.string.neighborsList)
        }
    }

    private fun setData() {
        viewModel.neighbors.observe(
            viewLifecycleOwner,
            Observer<List<Neighbor>> { t ->
                val adapter = ListNeighborsAdapter(t, this@ListNeighborsFragment)
                binding.neighborsList.adapter = adapter
            }
        )
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        val application: Application = activity?.application ?: return

        //NeighborRepository.getInstance(application).delete(neighbor)
        if (application != null) {
            Executors.newSingleThreadExecutor().execute {
                DI.repository.delete(neighbor)
                binding.neighborsList.adapter?.notifyDataSetChanged()
            }
        }
    }

/*    override fun showFragment(fragment: Fragment) {
        //

       // fragmentManager

        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }?.commit()
    }

*/

}