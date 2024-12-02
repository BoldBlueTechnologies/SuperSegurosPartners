package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.R

class Formulario_siete_superapi : AppCompatActivity() {

    private lateinit var txtCalleSuperApi : TextView
    private lateinit var txtNumeroExteriorSuperApi : TextView
    private lateinit var txtNumeroInteriorSuperApi : TextView
    private lateinit var txtColoniaSuperApi : TextView
    private lateinit var txtEstadoSuperApi : TextView
    private lateinit var txtMunicipioSuperApi : TextView
    private lateinit var txtCodigoPostalSuperApi : TextView
    private lateinit var btnContinuarSuperApi : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_siete_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        txtCalleSuperApi = findViewById(R.id.txtCalleSuperApi)
        txtNumeroExteriorSuperApi = findViewById(R.id.txtNumeroExteriorSuperApi)
        txtNumeroInteriorSuperApi = findViewById(R.id.txtNumeroInteriorSuperApi)
        txtColoniaSuperApi = findViewById(R.id.txtColoniaSuperApi)
        txtEstadoSuperApi = findViewById(R.id.txtEstadoSuperApi)
        txtMunicipioSuperApi = findViewById(R.id.txtMunicipioSuperApi)
        txtCodigoPostalSuperApi = findViewById(R.id.txtCodigoPostalSuperApi)
        btnContinuarSuperApi = findViewById(R.id.btnContinuarSuperApi)
        btnContinuarSuperApi.setOnClickListener {
            val intent = Intent(this, Formulario_ocho_superapi::class.java)
            startActivity(intent)
        }
    }
}