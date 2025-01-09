package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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

class Formulario_cinco_superapi : AppCompatActivity() {

    private lateinit var txtMatriculaSuperApi : TextView
    private lateinit var txtVINSuperApi : TextView
    private lateinit var txtNumeroMotorSuperApi : TextView
    private lateinit var cardUsoVehiculo_superapi : CardView
    private lateinit var txtUsoVehiculoSuperApi : TextView
    private lateinit var btnContinuarSuperApi : CardView
    private lateinit var cardMatricula_superapi : CardView
    private lateinit var cardVIN_superapi : CardView
    private lateinit var cardNumeroMotor_superapi : CardView
    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_cinco_superapi)
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        cardMatricula_superapi = findViewById(R.id.cardMatricula_superapi)
        cardVIN_superapi = findViewById(R.id.cardVIN_superapi)
        cardNumeroMotor_superapi = findViewById(R.id.cardNumeroMotor_superapi)
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

        modelsDataPolicySuperapi.paymentForm= intent.getStringExtra("paymentForm").toString()
        modelsDataPolicySuperapi.applicableCoverages= intent.getStringExtra("applicableCoverages").toString()
        modelsDataPolicySuperapi.quoteNumber= intent.getStringExtra("quoteNumber").toString()
        modelsDataPolicySuperapi.totalCost= intent.getStringExtra("totalCost").toString()
        modelsDataPolicySuperapi.firstReceipt= intent.getStringExtra("firstReceipt").toString()
        modelsDataPolicySuperapi.subsequents= intent.getStringExtra("subsequents").toString()

        txtMatriculaSuperApi = findViewById(R.id.txtMatriculaSuperApi)
        txtVINSuperApi = findViewById(R.id.txtVINSuperApi)
        txtNumeroMotorSuperApi = findViewById(R.id.txtNumeroMotorSuperApi)

        txtMatriculaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardMatricula_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtMatriculaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardMatricula_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtMatriculaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtVINSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardVIN_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtVINSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardVIN_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtVINSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtNumeroMotorSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardNumeroMotor_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtNumeroMotorSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardNumeroMotor_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtNumeroMotorSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        cardUsoVehiculo_superapi = findViewById(R.id.cardUsoVehiculo_superapi)
        txtUsoVehiculoSuperApi = findViewById(R.id.txtUsoVehiculoSuperApi)
        btnContinuarSuperApi = findViewById(R.id.btnContinuarSuperApi)
        btnContinuarSuperApi.setOnClickListener {
            if(txtMatriculaSuperApi.text.isNotEmpty()){
                if(txtVINSuperApi.text.isNotEmpty()){
                    if(txtVINSuperApi.length()>=17){
                        if(txtNumeroMotorSuperApi.text.isNotEmpty()){
                            val map: HashMap<String, Any> = HashMap()
                            map["licensePlate"]= txtMatriculaSuperApi.text.toString()
                            map["VIN"]= txtVINSuperApi.text.toString()
                            map["engineNumber"]= txtNumeroMotorSuperApi.text.toString()
                            helperConnectSuperApi.dataCar(this,map)
                        }else
                            Toast.makeText(this,R.string.ingresaElNumeroDeTuMotor_superapi,Toast.LENGTH_LONG).show()
                    }else
                        Toast.makeText(this,R.string.elNoDeSerieDebeTener17Caracteres_superapi,Toast.LENGTH_LONG).show()
                }else
                    Toast.makeText(this,R.string.ingresaTuNoDeSerie_superapi,Toast.LENGTH_LONG).show()
            }else
                Toast.makeText(this,R.string.ingresaTuPlaca_superapi,Toast.LENGTH_LONG).show()
        }
    }
}