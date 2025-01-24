package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.Main.Principal_superapi
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.R
import java.lang.String
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Formulario_principal_superapi : AppCompatActivity() {

    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi
    private lateinit var txtNombrePoliza_superapi : TextView
    private lateinit var txtNumeroPoliza_superapi : TextView
    private lateinit var txtFechaPoliza_superapi : TextView
    private lateinit var txtMarca_superapi : TextView
    private lateinit var txtAno_superapi : TextView
    private lateinit var txtModelo_superapi : TextView
    private lateinit var txtVersion_superapi : TextView
    private lateinit var cardLlamar_superapi : CardView
    private lateinit var cardReciboPago_superapi : CardView
    private lateinit var cardPolizaDeAuto_superapi : CardView
    private lateinit var cardCoberturaExtrangero_superapi :CardView
    private lateinit var cardCondicionesGenerales_superapi : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener {
            val intent = Intent(this, Principal_superapi::class.java)
            startActivity(intent)
        }
        txtNumeroPoliza_superapi = findViewById(R.id.txtNumeroPoliza_superapi)
        txtFechaPoliza_superapi = findViewById(R.id.txtFechaPoliza_superapi)
        txtMarca_superapi = findViewById(R.id.txtMarca_superapi)
        txtAno_superapi = findViewById(R.id.txtAno_superapi)
        txtModelo_superapi = findViewById(R.id.txtModelo_superapi)
        txtVersion_superapi = findViewById(R.id.txtVersion_superapi)
        cardLlamar_superapi = findViewById(R.id.cardLlamar_superapi)
        cardReciboPago_superapi = findViewById(R.id.cardReciboPago_superapi)
        cardPolizaDeAuto_superapi = findViewById(R.id.cardPolizaDeAuto_superapi)
        cardCoberturaExtrangero_superapi = findViewById(R.id.cardCoberturaExtrangero_superapi)
        cardCondicionesGenerales_superapi = findViewById(R.id.cardCondicionesGenerales_superapi)
        txtNombrePoliza_superapi = findViewById(R.id.txtNombrePoliza_superapi)
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
        txtNombrePoliza_superapi.text ="${modelsDataPolicySuperapi.name} ${modelsDataPolicySuperapi.paternalSurname } ${modelsDataPolicySuperapi.maternalSurname }"
        txtMarca_superapi.text= modelsDataPolicySuperapi.nameBrand
        txtAno_superapi.text= modelsDataPolicySuperapi.model
        txtModelo_superapi.text= modelsDataPolicySuperapi.nameSubBrand
        txtVersion_superapi.text=modelsDataPolicySuperapi.autoDescription
        val fechaActual = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
         txtFechaPoliza_superapi.text = fechaActual.format(formatter).toString()
        cardLlamar_superapi.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(String.valueOf("tel:800 472 7696"))
            startActivity(intent)
        }
        cardReciboPago_superapi.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW, Uri.parse(modelsDataPolicySuperapi.receiptSuper))
            startActivity(i2)
        }
        cardPolizaDeAuto_superapi.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW, Uri.parse(modelsDataPolicySuperapi.policySuper))
            startActivity(i2)
        }
        cardCoberturaExtrangero_superapi.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW, Uri.parse(modelsDataPolicySuperapi.rcusaSuper))
            startActivity(i2)
        }
        cardCondicionesGenerales_superapi.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://generaldeseguros.mx/home/condiciones-generales-menu/"))
            startActivity(i2)
        }
    }
}