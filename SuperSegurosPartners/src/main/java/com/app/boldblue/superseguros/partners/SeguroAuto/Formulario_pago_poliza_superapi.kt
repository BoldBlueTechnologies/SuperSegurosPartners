package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import android.widget.CheckedTextView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Formulario_pago_poliza_superapi : AppCompatActivity() {

    private lateinit var btnContinuarSuperApi : CardView
    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi

    private lateinit var txt_tipoCobertura_superapi : TextView
    private lateinit var txt_Precio_superapi : TextView
    private lateinit var txtPago_superapi : TextView
    private lateinit var txtAuto_superapi : TextView
    private lateinit var txtAseguradora_superapi : TextView
    private lateinit var txtNombreTarjetaSuperApi : TextView
    private lateinit var txtNumeroTarjetaSuperApi : TextView
    private lateinit var txtExpiracionMMTarjetaSuperApi : TextView
    private lateinit var txtExpiracionAATarjetaSuperApi : TextView
    private lateinit var txtCVVTarjetaSuperApi : TextView
    private lateinit var checkRequieroFactura_superapi : CheckBox
    private lateinit var cardNombreTarjeta_superapi : CardView
    private lateinit var cardNumeroTarjeta_superapi : CardView
    private lateinit var cardMMTarjeta_superapi : CardView
    private lateinit var cardAATarjeta_superapi : CardView
    private lateinit var cardCodigoTarjeta_superapi : CardView
    private lateinit var txtPrecioContinuar_superapi : TextView
    private lateinit var itemPagos_superapi : LinearLayout
    private lateinit var txt_PrecioTotal_superapi : TextView
    private lateinit var txt_PrimerPago_superapi : TextView
    private lateinit var txt_PagoSubsecuente_superapi : TextView

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

        itemPagos_superapi = findViewById(R.id.itemPagos_superapi)
        txt_tipoCobertura_superapi = findViewById(R.id.txt_tipoCobertura_superapi)
        txt_Precio_superapi = findViewById(R.id.txt_Precio_superapi)
        txtPago_superapi = findViewById(R.id.txtPago_superapi)
        txtAuto_superapi = findViewById(R.id.txtAuto_superapi)
        txtAseguradora_superapi = findViewById(R.id.txtAseguradora_superapi)
        txtNombreTarjetaSuperApi = findViewById(R.id.txtNombreTarjetaSuperApi)
        txtNumeroTarjetaSuperApi = findViewById(R.id.txtNumeroTarjetaSuperApi)
        txtExpiracionAATarjetaSuperApi = findViewById(R.id.txtExpiracionAATarjetaSuperApi)
        txtExpiracionMMTarjetaSuperApi = findViewById(R.id.txtExpiracionMMTarjetaSuperApi)
        txtCVVTarjetaSuperApi = findViewById(R.id.txtCVVTarjetaSuperApi)
        checkRequieroFactura_superapi = findViewById(R.id.checkRequieroFactura_superapi)
        cardNombreTarjeta_superapi = findViewById(R.id.cardNombreTarjeta_superapi)
        cardNumeroTarjeta_superapi = findViewById(R.id.cardNumeroTarjeta_superapi)
        cardMMTarjeta_superapi = findViewById(R.id.cardMMTarjeta_superapi)
        cardAATarjeta_superapi = findViewById(R.id.cardAATarjeta_superapi)
        cardCodigoTarjeta_superapi = findViewById(R.id.cardCodigoTarjeta_superapi)
        txtPrecioContinuar_superapi = findViewById(R.id.txtPrecioContinuar_superapi)
        txt_PrecioTotal_superapi = findViewById(R.id.txt_PrecioTotal_superapi)
        txt_PrimerPago_superapi = findViewById(R.id.txt_PrimerPago_superapi)
        txt_PagoSubsecuente_superapi = findViewById(R.id.txt_PagoSubsecuente_superapi)
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
        modelsDataPolicySuperapi.carQuoteId = intent.getStringExtra("carQuoteId").toString()
        modelsDataPolicySuperapi.coverageId = intent.getStringExtra("coverageId").toString()
        modelsDataPolicySuperapi.coverage = intent.getStringExtra("coverage").toString()

        modelsDataPolicySuperapi.licensePlate = intent.getStringExtra("licensePlate").toString()
        modelsDataPolicySuperapi.VIN = intent.getStringExtra("VIN").toString()
        modelsDataPolicySuperapi.engineNumber = intent.getStringExtra("engineNumber").toString()

        modelsDataPolicySuperapi.idCar = intent.getStringExtra("idCar").toString()

        modelsDataPolicySuperapi.idDriver = intent.getStringExtra("idDriver").toString()
        modelsDataPolicySuperapi.name = intent.getStringExtra("name").toString()
        modelsDataPolicySuperapi.paternalSurname = intent.getStringExtra("paternalSurname").toString()
        modelsDataPolicySuperapi.maternalSurname = intent.getStringExtra("maternalSurname").toString()
        modelsDataPolicySuperapi.bornDate = intent.getStringExtra("bornDate").toString()
        modelsDataPolicySuperapi.gender = intent.getStringExtra("gender").toString()
        modelsDataPolicySuperapi.maritalStatus = intent.getStringExtra("maritalStatus").toString()
        modelsDataPolicySuperapi.genderID = intent.getStringExtra("genderID").toString()
        modelsDataPolicySuperapi.maritalStatusID = intent.getStringExtra("maritalStatusID").toString()
        modelsDataPolicySuperapi.rfc = intent.getStringExtra("rfc").toString()

        modelsDataPolicySuperapi.street = intent.getStringExtra("street").toString()
        modelsDataPolicySuperapi.apartmentNumber = intent.getStringExtra("apartmentNumber").toString()
        modelsDataPolicySuperapi.streetNumber = intent.getStringExtra("streetNumber").toString()
        modelsDataPolicySuperapi.state = intent.getStringExtra("state").toString()
        modelsDataPolicySuperapi.city = intent.getStringExtra("city").toString()
        modelsDataPolicySuperapi.neighborhood = intent.getStringExtra("neighborhood").toString()

        modelsDataPolicySuperapi.email = intent.getStringExtra("email").toString()
        modelsDataPolicySuperapi.password = intent.getStringExtra("password").toString()
        modelsDataPolicySuperapi.userId = intent.getStringExtra("userId").toString()
        modelsDataPolicySuperapi.phoneNumber = intent.getStringExtra("phoneNumber").toString()


        txt_tipoCobertura_superapi.text ="Cobertura ${modelsDataPolicySuperapi.coverage}"
        if(modelsDataPolicySuperapi.paymentForm == "Anual"){
            itemPagos_superapi.visibility=View.GONE
            txt_Precio_superapi.visibility=View.VISIBLE
            txt_Precio_superapi.text="$${modelsDataPolicySuperapi.totalCost} / ${modelsDataPolicySuperapi.paymentForm}"
            txtPrecioContinuar_superapi.text = "Pagar $${modelsDataPolicySuperapi.firstReceipt}"
        }else{
            itemPagos_superapi.visibility=View.VISIBLE
            txt_Precio_superapi.visibility=View.GONE
            txt_PrecioTotal_superapi.text="$${modelsDataPolicySuperapi.totalCost}"
            txt_PrimerPago_superapi.text="$${modelsDataPolicySuperapi.firstReceipt}"
            txt_PagoSubsecuente_superapi.text="$${modelsDataPolicySuperapi.subsequents}"
            txtPrecioContinuar_superapi.text = "Pagar $${modelsDataPolicySuperapi.firstReceipt}"
        }
        txtPago_superapi.text="$${modelsDataPolicySuperapi.totalCost} / ${modelsDataPolicySuperapi.paymentForm}"
        txtAuto_superapi.text="${modelsDataPolicySuperapi.nameBrand}, ${modelsDataPolicySuperapi.model}, ${modelsDataPolicySuperapi.nameSubBrand}, ${modelsDataPolicySuperapi.autoDescription}"
        txtAseguradora_superapi.text ="${modelsDataPolicySuperapi.insurance}"

        println("coverage---${modelsDataPolicySuperapi.coverage}")
        println("vehicleType---${modelsDataPolicySuperapi.vehicleType}")
        println("description---${modelsDataPolicySuperapi.description}")
        println("model---${modelsDataPolicySuperapi.model}")
        println("nameBrand---${modelsDataPolicySuperapi.nameBrand}")
        println("brand---${modelsDataPolicySuperapi.brand}")
        println("nameSubBrand---${modelsDataPolicySuperapi.nameSubBrand}")
        println("subBrand---${modelsDataPolicySuperapi.subBrand}")
        println("internalKey---${modelsDataPolicySuperapi.internalKey}")
        println("autoDescription---${modelsDataPolicySuperapi.autoDescription}")
        println("insurance---${modelsDataPolicySuperapi.insurance}")
        println("paymentForm---${modelsDataPolicySuperapi.paymentForm}")
        println("applicableCoverages---${modelsDataPolicySuperapi.applicableCoverages}")
        println("quoteNumber---${modelsDataPolicySuperapi.quoteNumber}")
        println("totalCost---${modelsDataPolicySuperapi.totalCost}")
        println("firstReceipt---${modelsDataPolicySuperapi.firstReceipt}")
        println("subsequents---${modelsDataPolicySuperapi.subsequents}")
        println("ZIPCode---${modelsDataPolicySuperapi.ZIPCode}")
        println("carQuoteId---${modelsDataPolicySuperapi.carQuoteId}")
        println("coverageId---${modelsDataPolicySuperapi.coverageId}")
        println("licensePlate---${modelsDataPolicySuperapi.licensePlate}")
        println("VIN---${modelsDataPolicySuperapi.VIN}")
        println("engineNumber---${modelsDataPolicySuperapi.engineNumber}")
        println("idCar---${modelsDataPolicySuperapi.idCar}")
        println("idDriver---${modelsDataPolicySuperapi.idDriver}")
        println("name---${modelsDataPolicySuperapi.name}")
        println("paternalSurname---${modelsDataPolicySuperapi.paternalSurname}")
        println("maternalSurname---${modelsDataPolicySuperapi.maternalSurname}")
        println("bornDate---${modelsDataPolicySuperapi.bornDate}")
        println("gender---${modelsDataPolicySuperapi.gender}")
        println("maritalStatus---${modelsDataPolicySuperapi.maritalStatus}")
        println("genderID---${modelsDataPolicySuperapi.genderID}")
        println("maritalStatusID---${modelsDataPolicySuperapi.maritalStatusID}")
        println("rfc---${modelsDataPolicySuperapi.rfc}")
        println("street---${modelsDataPolicySuperapi.street}")
        println("apartmentNumber---${modelsDataPolicySuperapi.apartmentNumber}")
        println("streetNumber---${modelsDataPolicySuperapi.streetNumber}")
        println("state---${modelsDataPolicySuperapi.state}")
        println("city---${modelsDataPolicySuperapi.city}")
        println("neighborhood---${modelsDataPolicySuperapi.neighborhood}")
        println("email---${modelsDataPolicySuperapi.email}")
        println("password---${modelsDataPolicySuperapi.password}")
        println("userId---${modelsDataPolicySuperapi.userId}")
        println("phoneNumber---${modelsDataPolicySuperapi.phoneNumber}")

        txtNombreTarjetaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<3){
                    cardNombreTarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtNombreTarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardNombreTarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtNombreTarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtNumeroTarjetaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<15){
                    cardNumeroTarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtNumeroTarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardNumeroTarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtNumeroTarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtExpiracionMMTarjetaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<1){
                    cardMMTarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtExpiracionMMTarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardMMTarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtExpiracionMMTarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtExpiracionAATarjetaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<1){
                    cardAATarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtExpiracionAATarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardAATarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtExpiracionAATarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtCVVTarjetaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardCodigoTarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtCVVTarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardCodigoTarjeta_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtCVVTarjetaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        btnContinuarSuperApi.setOnClickListener {
            if (txtNombreTarjetaSuperApi.text.isNotEmpty()) {
                if (txtNumeroTarjetaSuperApi.text.isNotEmpty()) {
                    if (txtExpiracionMMTarjetaSuperApi.text.isNotEmpty()) {
                        if (txtExpiracionAATarjetaSuperApi.text.isNotEmpty()) {
                            if (txtCVVTarjetaSuperApi.text.isNotEmpty()) {
                                val fechaActual = LocalDate.now()
                                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                                val map: HashMap<String, Any> = HashMap()
                                map["quoteId"] = modelsDataPolicySuperapi.quoteNumber
                                map["startingAt"] = fechaActual.format(formatter)
                                map["serial"] = modelsDataPolicySuperapi.VIN
                                map["motorNumber"] = modelsDataPolicySuperapi.engineNumber
                                map["carPlateNumber"] = modelsDataPolicySuperapi.licensePlate
                                map["typeVehicleId"] =  modelsDataPolicySuperapi.vehicleType
                                map["name"] = modelsDataPolicySuperapi.name
                                map["paternalSurname"] = modelsDataPolicySuperapi.paternalSurname
                                map["maternalSurname"] = modelsDataPolicySuperapi.maternalSurname
                                map["gender"] = modelsDataPolicySuperapi.genderID
                                map["maritalStatus"] = modelsDataPolicySuperapi.maritalStatusID
                                map["email"] = modelsDataPolicySuperapi.email
                                map["birthDate"] = modelsDataPolicySuperapi.bornDate
                                map["rfc"] = modelsDataPolicySuperapi.rfc
                                map["zipCode"] = modelsDataPolicySuperapi.ZIPCode
                                map["entity"] = modelsDataPolicySuperapi.state
                                map["municipality"] = modelsDataPolicySuperapi.city
                                map["neighborhood"] = modelsDataPolicySuperapi.neighborhood
                                map["street"] = modelsDataPolicySuperapi.street
                                map["extNumber"] = modelsDataPolicySuperapi.streetNumber
                                map["holderName"] = txtNombreTarjetaSuperApi.text.toString()
                                map["cardNumber"] = txtNumeroTarjetaSuperApi.text.toString()
                                map["cvv"] = txtCVVTarjetaSuperApi.text.toString()
                                map["month"] = txtExpiracionMMTarjetaSuperApi.text.toString()
                                map["year"] = "20"+txtExpiracionAATarjetaSuperApi.text.toString()
                                map["userId"] = modelsDataPolicySuperapi.userId
                                map["coverage"] = modelsDataPolicySuperapi.coverage
                                HelperConnectSuperApi().payQuotation(this, map)
                            } else
                                Toast.makeText(this, R.string.agregaUnCodigoDeSeguridad_superapi, Toast.LENGTH_LONG).show()
                        } else
                            Toast.makeText(this, R.string.agregaUnAno_superapi, Toast.LENGTH_LONG).show()
                    } else
                        Toast.makeText(this, R.string.agregaUnMes_superapi, Toast.LENGTH_LONG).show()
                } else
                    Toast.makeText(this, R.string.agregaUnNumeroDeTarjeta_superapi, Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(this, R.string.agregaUnNombre_superapi, Toast.LENGTH_LONG).show()
        }
    }
}