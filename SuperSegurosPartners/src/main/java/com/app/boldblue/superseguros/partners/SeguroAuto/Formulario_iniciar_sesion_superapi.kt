package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi
import java.util.HashMap

class Formulario_iniciar_sesion_superapi : AppCompatActivity() {

    private lateinit var txtCorreoSuperApi : TextView
    private lateinit var cardCorreoElectronico_superapi : CardView
    private lateinit var cardContrasena_superapi : CardView
    private lateinit var txtContrasenaSuperApi : TextView
    private lateinit var btnVincularSuperApi : CardView

    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_iniciar_sesion_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        val helperConnectSuperApi = HelperConnectSuperApi()
        txtCorreoSuperApi = findViewById(R.id.txtCorreoSuperApi)
        cardCorreoElectronico_superapi = findViewById(R.id.cardCorreoElectronico_superapi)
        txtContrasenaSuperApi = findViewById(R.id.txtContrasenaSuperApi)
        cardContrasena_superapi = findViewById(R.id.cardContrasena_superapi)
        btnVincularSuperApi = findViewById(R.id.btnVincularSuperApi)
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
        txtCorreoSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardCorreoElectronico_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtCorreoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardCorreoElectronico_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtCorreoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })
        txtContrasenaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardContrasena_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtContrasenaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardContrasena_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtContrasenaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })
        txtCorreoSuperApi.text = modelsDataPolicySuperapi.email
        cardContrasena_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
        txtCorreoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
        btnVincularSuperApi.setOnClickListener {
            if (txtCorreoSuperApi.text.isNotEmpty()) {
                if (txtContrasenaSuperApi.text.isNotEmpty()) {
                    val map: HashMap<String, Any> = HashMap()
                    map["email"] = txtCorreoSuperApi.text.toString()
                    map["password"] = txtContrasenaSuperApi.text.toString()
                    helperConnectSuperApi.associateUser(this, map)
                } else
                    Toast.makeText(this, R.string.agregaUnCorreoElectrónico_superapi, Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(this, R.string.agregaUnCorreoElectrónico_superapi, Toast.LENGTH_LONG).show()
        }
    }
}