package com.gmail.nmessaoudene.tp2_nael_messaoudene

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

interface NavigationListener {
    fun showFragment(fragment: Fragment)
    fun updateTitle(@StringRes title: Int)

}