package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_coberturas
import com.app.boldblue.superseguros.partners.R
import com.google.android.material.tabs.TabLayout

class Formulario_tres_superapi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_tres_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        var mTablayout : TabLayout = findViewById(R.id.tab_layout_superapi)
        var mViewPager : ViewPager = findViewById(R.id.view_pager_superapi)
        val mAdapter = MyFragmentPager(supportFragmentManager, resources.getStringArray(R.array.tiposCoberturas_superapi))
        mViewPager.adapter=mAdapter
        mTablayout.setupWithViewPager(mViewPager)
    }

    class MyFragmentPager(fm: FragmentManager?, private val mTabTitles: Array<String>) : FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    fragment_coberturas()
                }
                1 -> {
                    fragment_coberturas()
                }
                2 -> {
                    fragment_coberturas()
                }
                3 -> {
                    fragment_coberturas()
                }
                else -> {
                    fragment_coberturas()
                }
            }
        }

        override fun getCount(): Int {
            return mTabTitles.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mTabTitles[position]
        }
    }

}