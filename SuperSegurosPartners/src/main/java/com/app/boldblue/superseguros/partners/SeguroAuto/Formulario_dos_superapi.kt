package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.Methods.models_list_insurance_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi
import java.util.HashMap

class Formulario_dos_superapi : AppCompatActivity() {

    lateinit var recyclerAseguradoras_superapi : RecyclerView
    lateinit var cardClean_superapi : CardView
    private lateinit var cardNuevoAuto_superapi : CardView
    var arrayInsurance = ArrayList<models_list_insurance_superapi>()
    lateinit var modelsDataPolicySuperapi: models_data_policy_superapi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_dos_superapi)
        val helperConnectSuperApi = HelperConnectSuperApi()
        modelsDataPolicySuperapi = models_data_policy_superapi()
        modelsDataPolicySuperapi.vehicleType= intent.getStringExtra("vehicleType").toString()
        modelsDataPolicySuperapi.description= intent.getStringExtra("description").toString()
        modelsDataPolicySuperapi.model= intent.getStringExtra("model").toString()
        modelsDataPolicySuperapi.nameBrand= intent.getStringExtra("nameBrand").toString()
        modelsDataPolicySuperapi.brand= intent.getStringExtra("brand").toString()
        modelsDataPolicySuperapi.nameSubBrand= intent.getStringExtra("nameSubBrand").toString()
        modelsDataPolicySuperapi.subBrand= intent.getStringExtra("subBrand").toString()
        modelsDataPolicySuperapi.internalKey= intent.getStringExtra("internalKey").toString()
        modelsDataPolicySuperapi.autoDescription= intent.getStringExtra("autoDescription").toString()
        modelsDataPolicySuperapi.ZIPCode= intent.getStringExtra("ZIPCode").toString()
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
        cardNuevoAuto_superapi.setOnClickListener {
            val resultadoIntent = Intent()
            resultadoIntent.putExtra("tipoSuperApi",28)
            setResult(RESULT_OK, resultadoIntent)
            finish()
        }
        val map: HashMap<String, Any> = HashMap()
        map["vehicleType"]= modelsDataPolicySuperapi.vehicleType
        map["model"]= modelsDataPolicySuperapi.model
        map["brand"]= modelsDataPolicySuperapi.brand
        map["subBrand"]= modelsDataPolicySuperapi.subBrand
        map["internalKey"]= modelsDataPolicySuperapi.internalKey
        map["zipCode"]= modelsDataPolicySuperapi.ZIPCode
        helperConnectSuperApi.getBasicQuotation(this,map)
    }
}