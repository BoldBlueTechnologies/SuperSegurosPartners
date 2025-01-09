package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
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

class Formulario_siete_superapi : AppCompatActivity() {

    private lateinit var txtCalleSuperApi : TextView
    private lateinit var txtNumeroExteriorSuperApi : TextView
    private lateinit var txtNumeroInteriorSuperApi : TextView
    private lateinit var txtColoniaSuperApi : TextView
    private lateinit var txtEstadoSuperApi : TextView
    private lateinit var txtMunicipioSuperApi : TextView
    private lateinit var txtCodigoPostalSuperApi : TextView
    private lateinit var btnContinuarSuperApi : CardView
    private lateinit var cardCalle_superapi : CardView
    private lateinit var cardNumExterior_superapi : CardView
    private lateinit var cardNumInterior_superapi : CardView
    private lateinit var cardColonia_superapi : CardView
    private lateinit var cardEstado_superapi : CardView
    private lateinit var cardMunicipio_superapi : CardView
    private lateinit var cardCodigoPostal_superapi : CardView

    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_siete_superapi)
        val helperConnectSuperApi = HelperConnectSuperApi()
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

        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish() }
        cardCalle_superapi = findViewById(R.id.cardCalle_superapi)
        cardNumExterior_superapi = findViewById(R.id.cardNumExterior_superapi)
        cardNumInterior_superapi = findViewById(R.id.cardNumInterior_superapi)
        cardColonia_superapi = findViewById(R.id.cardColonia_superapi)
        cardEstado_superapi = findViewById(R.id.cardEstado_superapi)
        cardMunicipio_superapi = findViewById(R.id.cardMunicipio_superapi)
        cardCodigoPostal_superapi = findViewById(R.id.cardCodigoPostal_superapi)

        txtCalleSuperApi = findViewById(R.id.txtCalleSuperApi)
        txtNumeroExteriorSuperApi = findViewById(R.id.txtNumeroExteriorSuperApi)
        txtNumeroInteriorSuperApi = findViewById(R.id.txtNumeroInteriorSuperApi)
        txtColoniaSuperApi = findViewById(R.id.txtColoniaSuperApi)
        txtEstadoSuperApi = findViewById(R.id.txtEstadoSuperApi)
        txtMunicipioSuperApi = findViewById(R.id.txtMunicipioSuperApi)
        txtCodigoPostalSuperApi = findViewById(R.id.txtCodigoPostalSuperApi)
        btnContinuarSuperApi = findViewById(R.id.btnContinuarSuperApi)

        txtCalleSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardCalle_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtCalleSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardCalle_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtCalleSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtNumeroExteriorSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<1){
                    cardNumExterior_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtNumeroExteriorSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardNumExterior_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtNumeroExteriorSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtNumeroInteriorSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<1){
                    cardNumInterior_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtNumeroInteriorSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardNumInterior_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtNumeroInteriorSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtColoniaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardColonia_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtColoniaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardColonia_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtColoniaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })
        txtEstadoSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardEstado_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtEstadoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardEstado_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtEstadoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })
        txtMunicipioSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardMunicipio_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtMunicipioSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardMunicipio_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtMunicipioSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })
        txtCodigoPostalSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardCodigoPostal_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtCodigoPostalSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardCodigoPostal_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtCodigoPostalSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })
        txtCodigoPostalSuperApi.text = modelsDataPolicySuperapi.ZIPCode
        cardCodigoPostal_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
        txtCodigoPostalSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
        btnContinuarSuperApi.setOnClickListener {
            if (txtCalleSuperApi.text.isNotEmpty()) {
                if (txtNumeroExteriorSuperApi.text.isNotEmpty()) {
                    if (txtColoniaSuperApi.text.isNotEmpty()) {
                        if (txtEstadoSuperApi.text.isNotEmpty()) {
                            if (txtMunicipioSuperApi.text.isNotEmpty()) {
                                if (txtCodigoPostalSuperApi.text.isNotEmpty()) {
                                    val map: HashMap<String, Any> = HashMap()
                                    map["id_driver"] = modelsDataPolicySuperapi.idDriver
                                    map["street"] = txtCalleSuperApi.text.toString()
                                    map["streetNumber"] = txtNumeroExteriorSuperApi.text.toString()
                                    map["apartmentNumber"] = txtNumeroInteriorSuperApi.text.toString()
                                    map["state"] = txtEstadoSuperApi.text.toString()
                                    map["city"] = txtMunicipioSuperApi.text.toString()
                                    map["neighborhood"] = txtColoniaSuperApi.text.toString()
                                    map["ZIPCode"] = txtCodigoPostalSuperApi.text.toString()
                                    helperConnectSuperApi.dataAddress(this, map)
                                } else
                                    Toast.makeText(this, R.string.agregaUnCodigoPostal_superapi, Toast.LENGTH_LONG).show()
                            } else
                                Toast.makeText(this, R.string.agregaUnMunicipio_superapi, Toast.LENGTH_LONG).show()
                        } else
                            Toast.makeText(this, R.string.agregaUnEstado_superapi, Toast.LENGTH_LONG).show()
                    } else
                        Toast.makeText(this, R.string.agregaUnaColonia_superapi, Toast.LENGTH_LONG).show()
                } else
                    Toast.makeText(this, R.string.agregaUnNumeroExterior_superapi, Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(this, R.string.agregaUnaCalle_superapi, Toast.LENGTH_LONG).show()
        }

    }
}