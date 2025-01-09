package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
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
        val modelsDataPolicySuperapi = models_data_policy_superapi()
        modelsDataPolicySuperapi.vehicleType= intent.getStringExtra("vehicleType").toString()
        modelsDataPolicySuperapi.description= intent.getStringExtra("description").toString()
        modelsDataPolicySuperapi.model= intent.getStringExtra("model").toString()
        modelsDataPolicySuperapi.nameBrand= intent.getStringExtra("nameBrand").toString()
        modelsDataPolicySuperapi.brand= intent.getStringExtra("brand").toString()
        modelsDataPolicySuperapi.nameSubBrand= intent.getStringExtra("nameSubBrand").toString()
        modelsDataPolicySuperapi.subBrand= intent.getStringExtra("subBrand").toString()
        modelsDataPolicySuperapi.internalKey= intent.getStringExtra("internalKey").toString()
        modelsDataPolicySuperapi.autoDescription= intent.getStringExtra("autoDescription").toString()
        modelsDataPolicySuperapi.insurance= intent.getStringExtra("insurance").toString()
        modelsDataPolicySuperapi.ZIPCode= intent.getStringExtra("ZIPCode").toString()

        modelsDataPolicySuperapi.paymentForm= intent.getStringExtra("paymentForm").toString()
        modelsDataPolicySuperapi.applicableCoverages= intent.getStringExtra("applicableCoverages").toString()
        modelsDataPolicySuperapi.quoteNumber= intent.getStringExtra("quoteNumber").toString()
        modelsDataPolicySuperapi.totalCost= intent.getStringExtra("totalCost").toString()
        modelsDataPolicySuperapi.firstReceipt= intent.getStringExtra("firstReceipt").toString()
        modelsDataPolicySuperapi.subsequents= intent.getStringExtra("subsequents").toString()

        txtTerminos_superapi = findViewById(R.id.txtTerminos_superapi)
        cardContinuar_superapi = findViewById(R.id.cardContinuar_superapi)
        cardContinuar_superapi.setOnClickListener {
            val intent = Intent(this, Formulario_cinco_superapi::class.java)
            intent.putExtra("vehicleType",modelsDataPolicySuperapi.vehicleType)
            intent.putExtra("description",modelsDataPolicySuperapi.description)
            intent.putExtra("model",modelsDataPolicySuperapi.model)
            intent.putExtra("nameBrand",modelsDataPolicySuperapi.nameBrand)
            intent.putExtra("brand",modelsDataPolicySuperapi.brand)
            intent.putExtra("nameSubBrand",modelsDataPolicySuperapi.nameSubBrand)
            intent.putExtra("subBrand",modelsDataPolicySuperapi.subBrand)
            intent.putExtra("internalKey",modelsDataPolicySuperapi.internalKey)
            intent.putExtra("autoDescription",modelsDataPolicySuperapi.autoDescription)
            intent.putExtra("insurance",modelsDataPolicySuperapi.insurance)
            intent.putExtra("ZIPCode",modelsDataPolicySuperapi.ZIPCode)

            intent.putExtra("paymentForm", modelsDataPolicySuperapi.paymentForm)
            intent.putExtra("applicableCoverages",modelsDataPolicySuperapi.applicableCoverages)
            intent.putExtra("quoteNumber",modelsDataPolicySuperapi.quoteNumber)
            intent.putExtra("totalCost",modelsDataPolicySuperapi.totalCost)
            intent.putExtra("firstReceipt",modelsDataPolicySuperapi.firstReceipt)
            intent.putExtra("subsequents",modelsDataPolicySuperapi.subsequents)
            startActivity(intent)
        }
    }
}