package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.Adapters.AdapterAseguradoras_superapi
import com.app.boldblue.superseguros.partners.Adapters.AdapterBusqueda_superapi
import com.app.boldblue.superseguros.partners.Methods.models_aseguradoras_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi

class Formulario_dos_superapi : AppCompatActivity() {

    private var marcaSuperApi = ""
    private var anoSuperApi = ""
    private var modeloSuperApi = ""
    private var versionSuperApi = ""
    private var cpSuperApi = ""
    private var tokenSuperApi = ""
    lateinit var recyclerAseguradoras_superapi : RecyclerView
    lateinit var cardClean_superapi : CardView
    private lateinit var cardNuevoAuto_superapi : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_dos_superapi)
        tokenSuperApi= intent.getStringExtra("tokenSuperApi").toString()
        marcaSuperApi= intent.getStringExtra("marcaSuperApi").toString()
        anoSuperApi= intent.getStringExtra("anoSuperApi").toString()
        modeloSuperApi= intent.getStringExtra("modeloSuperApi").toString()
        versionSuperApi= intent.getStringExtra("versionSuperApi").toString()
        cpSuperApi= intent.getStringExtra("cpSuperApi").toString()
        val helperConnectSuperApi = HelperConnectSuperApi()
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        recyclerAseguradoras_superapi = findViewById(R.id.recyclerAseguradoras_superapi)
        cardClean_superapi = findViewById(R.id.cardClean_superapi)
        cardNuevoAuto_superapi = findViewById(R.id.cardNuevoAuto_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish() }
        recyclerAseguradoras_superapi.layoutManager = LinearLayoutManager(this)
        recyclerAseguradoras_superapi.hasFixedSize()
        helperConnectSuperApi.pharmaweeklyPromotion(tokenSuperApi,this)
        cardNuevoAuto_superapi.setOnClickListener {
            val resultadoIntent = Intent()
            resultadoIntent.putExtra("tipoSuperApi",28)
            setResult(RESULT_OK, resultadoIntent) // Enviar resultado
            finish()
        }
    }

}