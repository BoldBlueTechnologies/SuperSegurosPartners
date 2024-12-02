package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.R

class Formulario_cuatro_superapi: AppCompatActivity() {

    private lateinit var txtTerminos_superapi : TextView
    private lateinit var cardContinuar_superapi : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_cuatro_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        txtTerminos_superapi = findViewById(R.id.txtTerminos_superapi)
        cardContinuar_superapi = findViewById(R.id.cardContinuar_superapi)
        cardContinuar_superapi.setOnClickListener {
            val intent = Intent(this, Formulario_cinco_superapi::class.java)
            startActivity(intent)
        }
    }
}