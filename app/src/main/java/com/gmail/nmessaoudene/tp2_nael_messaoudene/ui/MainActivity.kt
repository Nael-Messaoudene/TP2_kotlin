package com.gmail.nmessaoudene.tp2_nael_messaoudene.ui

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gmail.nmessaoudene.tp2_nael_messaoudene.NavigationListener
import com.gmail.nmessaoudene.tp2_nael_messaoudene.R
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ActivityMainBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.ui.fragments.ListNeighborsFragment

class MainActivity : AppCompatActivity(),
    NavigationListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.bringToFront() // z-index de la toolbar
        setContentView(binding.root)
        showFragment(ListNeighborsFragment())
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }

    override fun updateTitle(title: Int) {
        binding.toolbar.setTitle(title)
    }

}
