package com.app.boldblue.superseguros.partners.SeguroAuto

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
import com.app.boldblue.superseguros.partners.Methods.models_list_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi
import java.util.HashMap

class Listados : AppCompatActivity() {

    var arrayAuto = ArrayList<models_list_superapi>()
    private lateinit var toolbarSheet : Toolbar
    private lateinit var txtSheet : TextView
    private lateinit var imgBorrar : ImageView
    private lateinit var recyclerSheet : RecyclerView
    lateinit var adapter : AdapterBusqueda_superapi
    var tipoSuperApi = -1

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_superapi)
        val helperConnectSuperApi = HelperConnectSuperApi()
        toolbarSheet = findViewById(R.id.toolbarSheet_superapi)
        txtSheet = findViewById(R.id.txtSheet_superapi)
        imgBorrar = findViewById(R.id.imgBorrar_superapi)
        recyclerSheet = findViewById(R.id.recyclerSheet_superapi)
        tipoSuperApi = intent.getIntExtra("tipoSuperApi",-1)
        toolbarSheet.setNavigationIcon(R.drawable.back_purple_superapi)
        toolbarSheet.setTitleTextColor(getColor(R.color.purple1_superapi))
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
                    it.Descripcion.contains(textoIngresado, ignoreCase = true)
                }
                adapter.actualizarLista(ArrayList(listafiltrada))
            }
        })

        when (tipoSuperApi) {
            0 -> {
                helperConnectSuperApi.vehicle(this)
                toolbarSheet.setTitle(R.string.seleccionaUnTipoDeAuto_superapi)
            }
            1-> {
                val map: HashMap<String, Any> = HashMap()
                map["vehicleType"]= intent.getStringExtra("vehicleType")!!
                helperConnectSuperApi.carModel(this,map)
                toolbarSheet.setTitle(R.string.seleccionaUnAno_superapi)
            }
            2 -> {
                val map: HashMap<String, Any> = HashMap()
                map["vehicleType"]= intent.getStringExtra("vehicleType")!!
                map["model"]= intent.getStringExtra("model")!!
                helperConnectSuperApi.carBrands(this,map)
                toolbarSheet.setTitle(R.string.seleccionaUnaMarca_superapi)
            }
            3 -> {
                val map: HashMap<String, Any> = HashMap()
                map["vehicleType"]= intent.getStringExtra("vehicleType")!!
                map["model"]= intent.getStringExtra("model")!!
                map["brand"]= intent.getStringExtra("brand")!!
                helperConnectSuperApi.carSubBrands(this,map)
                toolbarSheet.setTitle(R.string.seleccionaUnModelo_superapi)
            }
            4 -> {
                val map: HashMap<String, Any> = HashMap()
                map["vehicleType"]= intent.getStringExtra("vehicleType")!!
                map["model"]= intent.getStringExtra("model")!!
                map["brand"]= intent.getStringExtra("brand")!!
                map["subBrand"]= intent.getStringExtra("subBrand")!!
                helperConnectSuperApi.descriptions(this,map)
                toolbarSheet.setTitle(R.string.seleccionaUnaVersion_superapi)
            }
            else -> {
                // Acción por defecto
            }
        }
        setSupportActionBar(toolbarSheet)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarSheet.setNavigationOnClickListener {
            finish()
        }
    }
}