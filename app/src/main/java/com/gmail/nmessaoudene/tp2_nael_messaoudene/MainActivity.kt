package com.gmail.nmessaoudene.tp2_nael_messaoudene

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gmail.nmessaoudene.tp2_nael_messaoudene.databinding.ActivityMainBinding
import com.gmail.nmessaoudene.tp2_nael_messaoudene.fragments.ListNeighborsFragment

class MainActivity : AppCompatActivity() {





    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        changeFragment(ListNeighborsFragment())
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }
}
