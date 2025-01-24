package com.app.boldblue.superseguros.partners.SeguroAuto

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi
import java.util.Calendar
import java.util.HashMap

class Formulario_seis_superapi: AppCompatActivity() {

    private lateinit var txtNombreSuperApi : TextView
    private lateinit var txtApellidoPaternoSuperApi : TextView
    private lateinit var txtApellidoMaternoSuperApi : TextView
    private lateinit var cardFechaNacimiento_superapi : CardView
    private lateinit var cardNombre_superapi : CardView
    private lateinit var cardApellidoPaterno_superapi : CardView
    private lateinit var cardApellidoMaterno_superapi : CardView
    private lateinit var cardRfc_superapi : CardView

    private lateinit var txtFechaNacimientoSuperApi : TextView
    private lateinit var btnContinuarSuperApi : CardView
    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi
    private lateinit var cardGeneroSuperApi : CardView
    private lateinit var txtGeneroSuperApi : TextView
    private lateinit var cardEstadoCivilSuperApi : CardView
    private lateinit var txtEstadoCivilSuperApi : TextView
    private lateinit var txtRfcSuperApi : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_seis_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        val helperConnectSuperApi = HelperConnectSuperApi()

        cardGeneroSuperApi = findViewById(R.id.cardGeneroSuperApi)
        txtGeneroSuperApi = findViewById(R.id.txtGeneroSuperApi)
        cardEstadoCivilSuperApi = findViewById(R.id.cardEstadoCivilSuperApi)
        txtEstadoCivilSuperApi = findViewById(R.id.txtEstadoCivilSuperApi)
        txtRfcSuperApi = findViewById(R.id.txtRfcSuperApi)

        cardRfc_superapi = findViewById(R.id.cardRfc_superapi)
        cardNombre_superapi = findViewById(R.id.cardNombre_superapi)
        cardApellidoPaterno_superapi = findViewById(R.id.cardApellidoPaterno_superapi)
        cardApellidoMaterno_superapi = findViewById(R.id.cardApellidoMaterno_superapi)
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
        modelsDataPolicySuperapi.carQuoteId= intent.getStringExtra("carQuoteId").toString()
        modelsDataPolicySuperapi.coverageId= intent.getStringExtra("coverageId").toString()
        modelsDataPolicySuperapi.coverage= intent.getStringExtra("coverage").toString()

        modelsDataPolicySuperapi.paymentForm= intent.getStringExtra("paymentForm").toString()
        modelsDataPolicySuperapi.applicableCoverages= intent.getStringExtra("applicableCoverages").toString()
        modelsDataPolicySuperapi.quoteNumber= intent.getStringExtra("quoteNumber").toString()
        modelsDataPolicySuperapi.totalCost= intent.getStringExtra("totalCost").toString()
        modelsDataPolicySuperapi.firstReceipt= intent.getStringExtra("firstReceipt").toString()
        modelsDataPolicySuperapi.subsequents= intent.getStringExtra("subsequents").toString()

        modelsDataPolicySuperapi.licensePlate= intent.getStringExtra("licensePlate").toString()
        modelsDataPolicySuperapi.VIN= intent.getStringExtra("VIN").toString()
        modelsDataPolicySuperapi.engineNumber= intent.getStringExtra("engineNumber").toString()

        modelsDataPolicySuperapi.idCar= intent.getStringExtra("idCar").toString()

        txtNombreSuperApi = findViewById(R.id.txtNombreSuperApi)
        txtApellidoPaternoSuperApi = findViewById(R.id.txtApellidoPaternoSuperApi)
        txtApellidoMaternoSuperApi = findViewById(R.id.txtApellidoMaternoSuperApi)
        cardFechaNacimiento_superapi = findViewById(R.id.cardFechaNacimiento_superapi)
        txtFechaNacimientoSuperApi = findViewById(R.id.txtFechaNacimientoSuperApi)
        btnContinuarSuperApi = findViewById(R.id.btnContinuarSuperApi)
        cardFechaNacimiento_superapi.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    var mes: String
                    var dia: String

                    when (selectedMonth + 1) {
                        0 -> mes = "00"
                        1 -> mes = "01"
                        2 -> mes = "02"
                        3 -> mes = "03"
                        4 -> mes = "04"
                        5 -> mes = "05"
                        6 -> mes = "06"
                        7 -> mes = "07"
                        8 -> mes = "08"
                        9 -> mes = "09"
                        else -> {
                            mes ="${selectedMonth +1}"
                        }
                    }
                    when (selectedDay) {
                        0 -> dia = "00"
                        1 -> dia = "01"
                        2 -> dia = "02"
                        3 -> dia = "03"
                        4 -> dia = "04"
                        5 -> dia = "05"
                        6 -> dia = "06"
                        7 -> dia = "07"
                        8 -> dia = "08"
                        9 -> dia = "09"
                        else -> {
                            dia ="${selectedDay}"
                        }
                    }
                    val selectedDate = "$selectedYear-${mes}-$dia"

                    txtFechaNacimientoSuperApi.text = selectedDate
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        txtNombreSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardNombre_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtNombreSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardNombre_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtNombreSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtApellidoPaternoSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardApellidoPaterno_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtApellidoPaternoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardApellidoPaterno_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtApellidoPaternoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtApellidoMaternoSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardApellidoMaterno_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtApellidoMaternoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardApellidoMaterno_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtApellidoMaternoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtFechaNacimientoSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardFechaNacimiento_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtFechaNacimientoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardFechaNacimiento_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtFechaNacimientoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })
        txtRfcSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardRfc_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtRfcSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardRfc_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtRfcSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        cardGeneroSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tipoSuperApi",6)
            resultadoLauncher.launch(intent)
        }
        cardEstadoCivilSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tipoSuperApi",5)
            resultadoLauncher.launch(intent)
        }

        btnContinuarSuperApi.setOnClickListener {
            if(txtNombreSuperApi.text.isNotEmpty()){
                if(txtApellidoPaternoSuperApi.text.isNotEmpty()){
                    if(txtApellidoMaternoSuperApi.text.isNotEmpty()){
                        if(txtFechaNacimientoSuperApi.text.isNotEmpty()){
                            if(txtEstadoCivilSuperApi.text.isNotEmpty()){
                                if(txtGeneroSuperApi.text.isNotEmpty()){
                                    if(txtRfcSuperApi.text.isNotEmpty()){
                                        val map: HashMap<String, Any> = HashMap()
                                        map["id_car"]= modelsDataPolicySuperapi.idCar
                                        map["name"]= txtNombreSuperApi.text.toString()
                                        map["paternalSurname"]= txtApellidoPaternoSuperApi.text.toString()
                                        map["maternalSurname"]= txtApellidoMaternoSuperApi.text.toString()
                                        map["bornDate"]= txtFechaNacimientoSuperApi.text.toString()
                                        map["gender"]= txtGeneroSuperApi.text.toString()
                                        map["maritalStatus"]= txtEstadoCivilSuperApi.text.toString()
                                        map["rfc"]= txtRfcSuperApi.text.toString()
                                        map["idDriver"]= modelsDataPolicySuperapi.idDriver

                                        helperConnectSuperApi.dataDriver(this,map)
                                    }else
                                        Toast.makeText(this,R.string.agregaUnRFC_superapi, Toast.LENGTH_LONG).show()
                                }else
                                    Toast.makeText(this,R.string.agregaUnGenero_superapi, Toast.LENGTH_LONG).show()
                            }else
                                Toast.makeText(this,R.string.agregaUnEstadoCivil_superapi, Toast.LENGTH_LONG).show()
                        }else
                            Toast.makeText(this,R.string.agregaUnaFechaDeNacimiento_superapi, Toast.LENGTH_LONG).show()
                    }else
                        Toast.makeText(this,R.string.agregaUnApellidoMaterno_superapi, Toast.LENGTH_LONG).show()
                }else
                    Toast.makeText(this,R.string.agregaUnApellidoPaterno_superapi, Toast.LENGTH_LONG).show()
            }else
                Toast.makeText(this,R.string.agregaUnNombre_superapi, Toast.LENGTH_LONG).show()
        }
    }

    private val resultadoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            when (data?.getIntExtra("tipoSuperApi",-1)) {
                5 -> {
                    if(data.getStringExtra("descripcionSuperApi") !=""){
                        txtRfcSuperApi.requestFocus()
                        modelsDataPolicySuperapi.maritalStatusID =data.getStringExtra("idSuperApi")!!
                        modelsDataPolicySuperapi.maritalStatus = data.getStringExtra("descripcionSuperApi")!!
                        println("-----${modelsDataPolicySuperapi.maritalStatusID}")
                        println("-----${modelsDataPolicySuperapi.maritalStatus}")
                        txtEstadoCivilSuperApi.text = data.getStringExtra("descripcionSuperApi")
                        txtEstadoCivilSuperApi.setTextColor(ContextCompat.getColor(this, R.color.black1_superapi))
                        cardEstadoCivilSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, R.color.purple1_superapi)
                    }
                }
                6 -> {
                    if(data.getStringExtra("descripcionSuperApi") !=""){
                        txtRfcSuperApi.requestFocus()
                        modelsDataPolicySuperapi.genderID =data.getStringExtra("idSuperApi")!!
                        modelsDataPolicySuperapi.gender = data.getStringExtra("descripcionSuperApi")!!
                        println("-----${modelsDataPolicySuperapi.genderID}")
                        println("-----${modelsDataPolicySuperapi.gender}")
                        txtGeneroSuperApi.text = data.getStringExtra("descripcionSuperApi")
                        txtGeneroSuperApi.setTextColor(ContextCompat.getColor(this, R.color.black1_superapi))
                        cardGeneroSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, R.color.purple1_superapi)
                    }
                }
                else -> {
                    // Acción por defecto
                }
            }
        }
    }

}