package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi
import com.google.android.material.tabs.TabLayout
import java.util.HashMap

class Formulario_tres_superapi : AppCompatActivity() {

    lateinit var modelsDataPolicySuperapi: models_data_policy_superapi
    lateinit var mTablayout : TabLayout
    lateinit var mViewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_tres_superapi)

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
        modelsDataPolicySuperapi.insurance= intent.getStringExtra("insurance").toString()
        modelsDataPolicySuperapi.ZIPCode= intent.getStringExtra("ZIPCode").toString()

        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        mViewPager = findViewById(R.id.view_pager_superapi)
        mTablayout = findViewById(R.id.tab_layout_superapi)
        val map: HashMap<String, Any> = HashMap()
        map["vehicleType"]= modelsDataPolicySuperapi.vehicleType
        map["model"]= modelsDataPolicySuperapi.model
        map["brand"]= modelsDataPolicySuperapi.brand
        map["subBrand"]= modelsDataPolicySuperapi.subBrand
        map["internalKey"]= modelsDataPolicySuperapi.internalKey
        map["insurance"]= modelsDataPolicySuperapi.insurance
        map["zipCode"]= modelsDataPolicySuperapi.ZIPCode

        helperConnectSuperApi.getGeneralQuotation(this,map)
    }

}