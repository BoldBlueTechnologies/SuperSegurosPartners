package com.app.boldblue.superseguros.partners.Main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_amplia_superapi
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_basica_superapi
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_limitada_superapi
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_plus_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_uno_superapi
import com.google.android.material.tabs.TabLayout

class Principal_superapi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbarMain)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.white1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish() }
        val btnCotiza: CardView = findViewById(R.id.btnCotiza)
        btnCotiza.setOnClickListener {
            val intent = Intent(this, Formulario_uno_superapi::class.java)
            startActivity(intent)
        }
        val btnConoce: CardView = findViewById(R.id.btnConoce)
        btnConoce.setOnClickListener {
            val intent = Intent(this, Formulario_uno_superapi::class.java)
            startActivity(intent)
        }
        var mTablayout : TabLayout = findViewById(R.id.tab_layout)
        var mViewPager : ViewPager = findViewById(R.id.view_pager)
        val mAdapter = MyFragmentPager(supportFragmentManager, resources.getStringArray(R.array.tiposCoberturas_superapi))
        mViewPager.adapter=mAdapter
        mTablayout.setupWithViewPager(mViewPager)
    }

    class MyFragmentPager(fm: FragmentManager?, private val mTabTitles: Array<String>) : FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
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

        override fun getCount(): Int {
            return mTabTitles.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mTabTitles[position]
        }
    }
}