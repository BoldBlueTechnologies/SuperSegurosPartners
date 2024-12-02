package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.R

class Formulario_seis_superapi: AppCompatActivity() {

    private lateinit var txtNombreSuperApi : TextView
    private lateinit var txtApellidoPaternoSuperApi : TextView
    private lateinit var txtApellidoMaternoSuperApi : TextView
    private lateinit var cardFechaNacimiento_superapi : CardView
    private lateinit var btnContinuarSuperApi : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_seis_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        txtNombreSuperApi = findViewById(R.id.txtNombreSuperApi)
        txtApellidoPaternoSuperApi = findViewById(R.id.txtApellidoPaternoSuperApi)
        txtApellidoMaternoSuperApi = findViewById(R.id.txtApellidoMaternoSuperApi)
        cardFechaNacimiento_superapi = findViewById(R.id.cardFechaNacimiento_superapi)
        btnContinuarSuperApi = findViewById(R.id.btnContinuarSuperApi)
        btnContinuarSuperApi.setOnClickListener {
            val intent = Intent(this, Formulario_siete_superapi::class.java)
            startActivity(intent)
        }
    }
}