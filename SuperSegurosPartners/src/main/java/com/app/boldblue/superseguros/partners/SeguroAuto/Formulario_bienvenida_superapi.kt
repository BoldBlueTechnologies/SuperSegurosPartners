package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.R

class Formulario_bienvenida_superapi : AppCompatActivity() {

    private lateinit var btnContinuarSuperApi : CardView
    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi
    private lateinit var txtNombre_superapi : TextView
    private lateinit var txt_texto_superapi : TextView
    private lateinit var txt_texto2_superapi : TextView
    private lateinit var txt_texto3_superapi :TextView
    private lateinit var txt_texto4_superapi : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_poliza_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        txtNombre_superapi = findViewById(R.id.txtNombre_superapi)
        txt_texto_superapi = findViewById(R.id.txt_texto_superapi)
        txt_texto2_superapi = findViewById(R.id.txt_texto2_superapi)
        txt_texto3_superapi = findViewById(R.id.txt_texto3_superapi)
        txt_texto4_superapi = findViewById(R.id.txt_texto4_superapi)
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
        modelsDataPolicySuperapi.policySuper = intent.getStringExtra("policySuper").toString()
        modelsDataPolicySuperapi.receiptSuper = intent.getStringExtra("receiptSuper").toString()
        modelsDataPolicySuperapi.rcusaSuper = intent.getStringExtra("rcusaSuper").toString()
        modelsDataPolicySuperapi.paid = intent.getStringExtra("paid").toString()
        txtNombre_superapi.text ="${modelsDataPolicySuperapi.name} ${modelsDataPolicySuperapi.paternalSurname } ${modelsDataPolicySuperapi.maternalSurname }"
        if(modelsDataPolicySuperapi.paid=="2"){
            txt_texto2_superapi.visibility=View.GONE
            txt_texto_superapi.text = resources.getString(R.string.lamentamosInformarteQueElPagoDeTu_superapi)
            txt_texto3_superapi.text = resources.getString(R.string.hemosEnviadoATuCorreoYTelefono_superapi)
            txt_texto4_superapi.text = resources.getString(R.string.realizaElPagoAntesDeLaFecha_superapi)
        }
        if(modelsDataPolicySuperapi.paid=="1"){
            txt_texto2_superapi.visibility=View.VISIBLE
            txt_texto_superapi.text = resources.getString(R.string.felicidades_superapi)
            txt_texto3_superapi.text = resources.getString(R.string.conTuNuevaPolizaDeSeguro_superapi)
            txt_texto4_superapi.text = resources.getString(R.string.tuPolizaSeraVigenteUnDiaDespuesDeTuContratacion_superapi)
        }
        btnContinuarSuperApi.setOnClickListener {
            val intent = Intent(this, Formulario_principal_superapi::class.java)
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
            intent.putExtra("coverageId",modelsDataPolicySuperapi.coverageId)
            intent.putExtra("carQuoteId",modelsDataPolicySuperapi.carQuoteId)
            intent.putExtra("coverage",modelsDataPolicySuperapi.coverage)
            intent.putExtra("ZIPCode",modelsDataPolicySuperapi.ZIPCode)
            intent.putExtra("paymentForm", modelsDataPolicySuperapi.paymentForm)
            intent.putExtra("applicableCoverages",modelsDataPolicySuperapi.applicableCoverages)
            intent.putExtra("quoteNumber",modelsDataPolicySuperapi.quoteNumber)
            intent.putExtra("totalCost",modelsDataPolicySuperapi.totalCost)
            intent.putExtra("firstReceipt",modelsDataPolicySuperapi.firstReceipt)
            intent.putExtra("subsequents",modelsDataPolicySuperapi.subsequents)
            intent.putExtra("licensePlate",modelsDataPolicySuperapi.licensePlate)
            intent.putExtra("VIN",modelsDataPolicySuperapi.VIN)
            intent.putExtra("engineNumber",modelsDataPolicySuperapi.engineNumber)
            intent.putExtra("idCar",modelsDataPolicySuperapi.idCar)
            intent.putExtra("name",modelsDataPolicySuperapi.name)
            intent.putExtra("paternalSurname",modelsDataPolicySuperapi.paternalSurname)
            intent.putExtra("maternalSurname",modelsDataPolicySuperapi.maternalSurname)
            intent.putExtra("bornDate",modelsDataPolicySuperapi.bornDate)
            intent.putExtra("gender",modelsDataPolicySuperapi.gender)
            intent.putExtra("maritalStatus",modelsDataPolicySuperapi.maritalStatus)
            intent.putExtra("genderID",modelsDataPolicySuperapi.genderID)
            intent.putExtra("maritalStatusID",modelsDataPolicySuperapi.maritalStatusID)
            intent.putExtra("rfc",modelsDataPolicySuperapi.rfc)
            intent.putExtra("idDriver",modelsDataPolicySuperapi.idDriver)
            intent.putExtra("id_Address",modelsDataPolicySuperapi.id_Address)
            intent.putExtra("street",modelsDataPolicySuperapi.street)
            intent.putExtra("streetNumber",modelsDataPolicySuperapi.streetNumber)
            intent.putExtra("apartmentNumber",modelsDataPolicySuperapi.apartmentNumber)
            intent.putExtra("state",modelsDataPolicySuperapi.state)
            intent.putExtra("city",modelsDataPolicySuperapi.city)
            intent.putExtra("neighborhood",modelsDataPolicySuperapi.neighborhood)
            intent.putExtra("email",modelsDataPolicySuperapi.email)
            intent.putExtra("password",modelsDataPolicySuperapi.password)
            intent.putExtra("phoneNumber",modelsDataPolicySuperapi.phoneNumber)
            intent.putExtra("userId",modelsDataPolicySuperapi.userId)
            intent.putExtra("policySuper",modelsDataPolicySuperapi.policySuper)
            intent.putExtra("receiptSuper",modelsDataPolicySuperapi.receiptSuper)
            intent.putExtra("rcusaSuper",modelsDataPolicySuperapi.rcusaSuper)

            startActivity(intent)
        }
    }
}