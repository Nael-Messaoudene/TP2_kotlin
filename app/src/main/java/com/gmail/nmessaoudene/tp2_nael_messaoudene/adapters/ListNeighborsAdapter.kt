package com.gmail.nmessaoudene.tp2_nael_messaoudene.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gmail.nmessaoudene.tp2_nael_messaoudene.R
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.NeighborItemBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor

class ListNeighborsAdapter(
    items: MutableList<Neighbor>,
    val callback: ListNeighborHandler
) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {

    //private val context: Context? = null
    private var context: Context? = null

    private val mNeighbours: MutableList<Neighbor> = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: NeighborItemBinding = NeighborItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.getContext();
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour: Neighbor =  mNeighbours[position]
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

        holder.binding.itemListDeleteButton.setOnClickListener(View.OnClickListener {
            //callback.onDeleteNeibor(mNeighbours[position])
            //notifyDataSetChanged()
           // displayAlertDialog(neighbour)
            showAlertDialog(position)
        })


    }


    private fun showAlertDialog(position: Int) {

        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
        alertDialog.setTitle("AlertDialog")
        alertDialog.setMessage("T'es sur de vouloir supprimer ?")
        alertDialog.setPositiveButton(
            "yes"
        ) { _, _ ->
            Toast.makeText(context, "Alert dialog closed.", Toast.LENGTH_LONG).show()
            callback.onDeleteNeibor(mNeighbours[position])
            notifyDataSetChanged()
        }
        alertDialog.setNegativeButton(
            "No"
        ) { _, _ -> }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }

    override fun getItemCount(): Int {
        return mNeighbours.size
    }

    class ViewHolder(val binding: NeighborItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}