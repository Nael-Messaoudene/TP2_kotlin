package com.gmail.nmessaoudene.tp2_nael_messaoudene.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.gmail.nmessaoudene.tp2_nael_messaoudene.NavigationListener
import com.gmail.nmessaoudene.tp2_nael_messaoudene.R
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.AddNeighborBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.models.Neighbor


class AddNeighbourFragment: Fragment() {

    private lateinit var binding: AddNeighborBinding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? NavigationListener)?.let {
            it.updateTitle(R.string.addNeighborsTitle)
        }



        val etUserName = binding.name as EditText
        val strUserName = etUserName.text.toString()

        val etUserAvatar = binding.image as EditText
        val strUserAvatar = etUserName.text.toString()

        val etUserPhone = binding.phone as EditText
        val strUserPhone = etUserName.text.toString()

        val etUserWebsite = binding.website as EditText
        val strUserWebsite = etUserName.text.toString()

        val etUserAdress = binding.adress as EditText
        val strUserAdress = etUserName.text.toString()

        val etUserAbout = binding.image as EditText
        val strUserAbout = etUserName.text.toString()

       /* if (TextUtils.isEmpty(strUserName)|| TextUtils.isEmpty(strUserAvatar)||TextUtils.isEmpty(strUserPhone)||
            TextUtils.isEmpty(strUserWebsite)||TextUtils.isEmpty(strUserAdress)||TextUtils.isEmpty(strUserAbout)){*/
            binding.addNeighborButton.isEnabled = false


        binding.addNeighborButton.setOnClickListener {
            var neighbor = Neighbor(
                id = Math.random().toLong(),
                name = binding.name.text.toString(),
                avatarUrl = binding.image.text.toString(),
                phoneNumber = binding.phone.text.toString(),
                webSite = binding.website.text.toString(),
                address = binding.adress.text.toString(),
                aboutMe = binding.about.text.toString(),
                favorite = false
            )


       /*     if (TextUtils.isEmpty(strUserName)) {
                etUserName.error = "Your message"

            } else{
                NeighborRepository.getInstance().createNeighbor(neighbor)
                activity?.onBackPressed()
            } */



        }


    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AddNeighborBinding.inflate(inflater, container, false)

        return binding.root
    }

}