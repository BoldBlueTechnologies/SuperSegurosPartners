package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.R

class Formulario_uno_superapi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_uno_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar)
        myToolbar.setTitle(R.string.vacio_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.white1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish() }
        val btnCotiza: CardView = findViewById(R.id.btnCotiza)
        btnCotiza.setOnClickListener {

        }
    }
}