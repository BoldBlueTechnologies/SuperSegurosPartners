package com.app.boldblue.superseguros.partners.Main.coberturas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class fragment_coverage_superapi (fragmentActivity: FragmentActivity, private val mTabTitles : Array<String>, private val tabFragment: Array<Fragment>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return mTabTitles.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                tabFragment[0]
            }
            1 -> {
                tabFragment[1]
            }
            2 -> {
                tabFragment[2]
            }
            3 -> {
                tabFragment[3]
            }
            else -> {
                tabFragment[0]
            }
        }
    }
}