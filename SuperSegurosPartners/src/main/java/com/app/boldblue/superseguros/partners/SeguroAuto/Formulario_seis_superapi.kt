package com.app.boldblue.superseguros.partners.SeguroAuto

import android.app.DatePickerDialog
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
    private lateinit var txtFechaNacimientoSuperApi : TextView
    private lateinit var btnContinuarSuperApi : CardView
    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi

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
                    val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
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

        btnContinuarSuperApi.setOnClickListener {
            if(txtNombreSuperApi.text.isNotEmpty()){
                if(txtApellidoPaternoSuperApi.text.isNotEmpty()){
                    if(txtApellidoMaternoSuperApi.text.isNotEmpty()){
                        if(txtFechaNacimientoSuperApi.text.isNotEmpty()){
                            val map: HashMap<String, Any> = HashMap()
                            map["id_car"]= modelsDataPolicySuperapi.idCar
                            map["name"]= txtNombreSuperApi.text.toString()
                            map["paternalSurname"]= txtApellidoPaternoSuperApi.text.toString()
                            map["maternalSurname"]= txtApellidoMaternoSuperApi.text.toString()
                            map["bornDate"]= txtFechaNacimientoSuperApi.text.toString()
                            helperConnectSuperApi.dataDriver(this,map)
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
}