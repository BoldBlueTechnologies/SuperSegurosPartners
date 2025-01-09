package com.app.boldblue.superseguros.partners.Main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_main_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_uno_superapi
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Principal_superapi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbarMain_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.white1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish() }
        val btnCotiza: CardView = findViewById(R.id.btnCotiza_superapi)
        btnCotiza.setOnClickListener {
            val intent = Intent(this, Formulario_uno_superapi::class.java)
            startActivity(intent)
        }
        val btnConoce: CardView = findViewById(R.id.btnConoce_superapi)
        btnConoce.setOnClickListener {
            val intent = Intent(this, Formulario_uno_superapi::class.java)
            startActivity(intent)
        }
        var mViewPager : ViewPager2 = findViewById(R.id.view_pager_superapi)
        var mTablayout : TabLayout = findViewById(R.id.tab_layout_superapi)
        val tabTitles = resources.getStringArray(R.array.tiposCoberturas_superapi)
        mViewPager.adapter= fragment_main_superapi(this, tabTitles)
        TabLayoutMediator(mTablayout, mViewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}