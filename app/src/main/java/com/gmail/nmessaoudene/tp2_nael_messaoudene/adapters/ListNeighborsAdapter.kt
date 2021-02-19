package com.gmail.nmessaoudene.tp2_nael_messaoudene.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gmail.nmessaoudene.tp2_nael_messaoudene.R
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ActivityMainBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ListNeighborsFragmentBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.NeighborItemBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

class ListNeighborsAdapter(
    items: List<Neighbor>
) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {
    private val mNeighbours: List<Neighbor> = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: NeighborItemBinding = NeighborItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour: Neighbor = mNeighbours[position]
        // Display Neighbour Name
        holder.binding.itemListName.text = neighbour.name
        val context = holder.binding.root.context

        Glide.with(context)
            .load(neighbour.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_person)
            .error(R.drawable.ic_person)
            .skipMemoryCache(false)
            .into(holder.binding.itemListAvatar)

    }

    override fun getItemCount(): Int {
        return mNeighbours.size
    }

    class ViewHolder(val binding: NeighborItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}