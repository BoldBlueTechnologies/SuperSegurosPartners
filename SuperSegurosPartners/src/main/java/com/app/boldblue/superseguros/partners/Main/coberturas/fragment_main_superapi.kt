package com.app.boldblue.superseguros.partners.Main.coberturas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class fragment_main_superapi (fragmentActivity: FragmentActivity, private val mTabTitles: Array<String>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return mTabTitles.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                fragment_plus_superapi()
            }
            1 -> {
                fragment_amplia_superapi()
            }
            2 -> {
                fragment_limitada_superapi()
            }
            3 -> {
                fragment_basica_superapi()
            }
            else -> {
                fragment_plus_superapi()
            }
        }
    }
}