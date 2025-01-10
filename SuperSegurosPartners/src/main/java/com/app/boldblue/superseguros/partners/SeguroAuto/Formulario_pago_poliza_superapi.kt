package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi

class Formulario_pago_poliza_superapi : AppCompatActivity() {

    private lateinit var btnContinuarSuperApi : CardView
    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pago_poliza_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        btnContinuarSuperApi = findViewById(R.id.btnContinuarSuperApi)
        modelsDataPolicySuperapi = models_data_policy_superapi()
        modelsDataPolicySuperapi.vehicleType = intent.getStringExtra("vehicleType").toString()
        modelsDataPolicySuperapi.description = intent.getStringExtra("description").toString()
        modelsDataPolicySuperapi.model = intent.getStringExtra("model").toString()
        modelsDataPolicySuperapi.nameBrand = intent.getStringExtra("nameBrand").toString()
        modelsDataPolicySuperapi.brand = intent.getStringExtra("brand").toString()
        modelsDataPolicySuperapi.nameSubBrand = intent.getStringExtra("nameSubBrand").toString()
        modelsDataPolicySuperapi.subBrand = intent.getStringExtra("subBrand").toString()
        modelsDataPolicySuperapi.internalKey = intent.getStringExtra("internalKey").toString()
        modelsDataPolicySuperapi.autoDescription = intent.getStringExtra("autoDescription").toString()
        modelsDataPolicySuperapi.insurance = intent.getStringExtra("insurance").toString()
        modelsDataPolicySuperapi.paymentForm = intent.getStringExtra("paymentForm").toString()
        modelsDataPolicySuperapi.applicableCoverages = intent.getStringExtra("applicableCoverages").toString()
        modelsDataPolicySuperapi.quoteNumber = intent.getStringExtra("quoteNumber").toString()
        modelsDataPolicySuperapi.totalCost = intent.getStringExtra("totalCost").toString()
        modelsDataPolicySuperapi.firstReceipt = intent.getStringExtra("firstReceipt").toString()
        modelsDataPolicySuperapi.subsequents = intent.getStringExtra("subsequents").toString()
        modelsDataPolicySuperapi.ZIPCode = intent.getStringExtra("ZIPCode").toString()

        modelsDataPolicySuperapi.licensePlate = intent.getStringExtra("licensePlate").toString()
        modelsDataPolicySuperapi.VIN = intent.getStringExtra("VIN").toString()
        modelsDataPolicySuperapi.engineNumber = intent.getStringExtra("engineNumber").toString()

        modelsDataPolicySuperapi.idCar = intent.getStringExtra("idCar").toString()

        modelsDataPolicySuperapi.idDriver = intent.getStringExtra("idDriver").toString()
        modelsDataPolicySuperapi.name = intent.getStringExtra("name").toString()
        modelsDataPolicySuperapi.paternalSurname = intent.getStringExtra("paternalSurname").toString()
        modelsDataPolicySuperapi.maternalSurname = intent.getStringExtra("maternalSurname").toString()
        modelsDataPolicySuperapi.bornDate = intent.getStringExtra("bornDate").toString()

        modelsDataPolicySuperapi.street = intent.getStringExtra("street").toString()
        modelsDataPolicySuperapi.apartmentNumber = intent.getStringExtra("apartmentNumber").toString()
        modelsDataPolicySuperapi.streetNumber = intent.getStringExtra("streetNumber").toString()
        modelsDataPolicySuperapi.state = intent.getStringExtra("state").toString()
        modelsDataPolicySuperapi.city = intent.getStringExtra("city").toString()
        modelsDataPolicySuperapi.neighborhood = intent.getStringExtra("neighborhood").toString()

        modelsDataPolicySuperapi.email = intent.getStringExtra("email").toString()
        modelsDataPolicySuperapi.password = intent.getStringExtra("password").toString()
        modelsDataPolicySuperapi.password = intent.getStringExtra("password").toString()
        modelsDataPolicySuperapi.password = intent.getStringExtra("password").toString()
        modelsDataPolicySuperapi.phoneNumber = intent.getStringExtra("phoneNumber").toString()


        btnContinuarSuperApi.setOnClickListener {
            /*if (txtCorreoSuperApi.text.isNotEmpty()) {
                val map: HashMap<String, Any> = HashMap()
                map["email"] = txtCorreoSuperApi.text.toString()
                helperConnectSuperApi.verifyEmail(this, map)
            } else
                Toast.makeText(this, R.string.agregaUnCorreoElectrónico_superapi, Toast.LENGTH_LONG).show()

             */
        }
    }
}