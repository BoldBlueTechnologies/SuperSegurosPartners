package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.Adapters.AdapterBusqueda_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi

class Listados : AppCompatActivity() {

    var arrayAuto = ArrayList<String>()
    private lateinit var toolbarSheet : Toolbar
    private lateinit var txtSheet : TextView
    private lateinit var imgBorrar : ImageView
    private lateinit var recyclerSheet : RecyclerView
    lateinit var adapter : AdapterBusqueda_superapi
    var tipoSuperApi = -1
    private var tokenSuperApi = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_superapi)
        val helperConnectSuperApi = HelperConnectSuperApi()

        tokenSuperApi= intent.getStringExtra("tokenSuperApi").toString()
        tipoSuperApi = intent.getIntExtra("tipoSuperApi",-1)
        helperConnectSuperApi.pickerBrand(tokenSuperApi,this)

        toolbarSheet = findViewById(R.id.toolbarSheet_superapi)
        txtSheet = findViewById(R.id.txtSheet_superapi)
        imgBorrar = findViewById(R.id.imgBorrar_superapi)
        recyclerSheet = findViewById(R.id.recyclerSheet_superapi)
        when (tipoSuperApi) {
            0 -> {
                toolbarSheet.setTitle(R.string.seleccionaUnTipoDeAuto_superapi)
            }
            1 -> {
                toolbarSheet.setTitle(R.string.seleccionaUnAno_superapi)
            }
            2 -> {
                toolbarSheet.setTitle(R.string.seleccionaUnaMarca_superapi)
            }
            3 -> {
                toolbarSheet.setTitle(R.string.seleccionaUnModelo_superapi)
            }
            4 -> {
                toolbarSheet.setTitle(R.string.seleccionaUnaVersion_superapi)
            }
            else -> {
                // Acción por defecto
            }
        }
        toolbarSheet.setNavigationIcon(R.drawable.back_purple_superapi)
        toolbarSheet.setTitleTextColor(getColor(R.color.purple1_superapi))
        toolbarSheet.setBackgroundColor(getColor(R.color.white1_superapi))
        setSupportActionBar(toolbarSheet)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarSheet.setNavigationOnClickListener {
            finish()
        }
        recyclerSheet.layoutManager = LinearLayoutManager(this)
        recyclerSheet.hasFixedSize()
        adapter = AdapterBusqueda_superapi(arrayAuto,this)
        recyclerSheet.adapter = adapter

        imgBorrar.setOnClickListener {
            txtSheet.text=""
        }

        txtSheet.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val textoIngresado = s.toString()
                val listafiltrada = arrayAuto.filter {
                    it.contains(textoIngresado, ignoreCase = true)
                }
                adapter.actualizarLista(ArrayList(listafiltrada))
            }
        })

    }
}