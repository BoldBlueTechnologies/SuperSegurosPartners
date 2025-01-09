package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.widget.CheckBox
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

class Formulario_registro_superapi : AppCompatActivity() {

    private lateinit var txtNombreSuperApi : TextView
    private lateinit var txtApellidoPaternoSuperApi : TextView
    private lateinit var txtApellidoMaternoSuperApi : TextView
    private lateinit var txtCorreoElectronicoSuperApi : TextView
    private lateinit var txtContrasenaSuperApi : TextView
    private lateinit var txtConfirmarContrasenaSuperApi : TextView
    private lateinit var txtLadaSuperApi : TextView
    private lateinit var txtTelefonoSuperApi : TextView
    private lateinit var cardNombre_superapi : CardView
    private lateinit var cardApellidoPaterno_superapi : CardView
    private lateinit var cardApellidoMaterno_superapi : CardView
    private lateinit var cardCorreoElectronico_superapi : CardView
    private lateinit var cardContrasenaConfirmar_superapi : CardView
    private lateinit var cardContrasena_superapi : CardView
    private lateinit var cardTelefono_superapi : CardView
    private lateinit var checkTerminos_superapi : CheckBox
    private lateinit var btnCrearCuentaSuperApi : CardView
    lateinit var modelsDataPolicySuperapi : models_data_policy_superapi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_registro_superapi)
        val helperConnectSuperApi = HelperConnectSuperApi()
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish()}
        txtNombreSuperApi = findViewById(R.id.txtNombreSuperApi)
        txtApellidoPaternoSuperApi = findViewById(R.id.txtApellidoPaternoSuperApi)
        txtApellidoMaternoSuperApi = findViewById(R.id.txtApellidoMaternoSuperApi)
        txtCorreoElectronicoSuperApi = findViewById(R.id.txtCorreoElectronicoSuperApi)
        txtContrasenaSuperApi = findViewById(R.id.txtContrasenaSuperApi)
        txtConfirmarContrasenaSuperApi = findViewById(R.id.txtConfirmarContrasenaSuperApi)
        txtLadaSuperApi = findViewById(R.id.txtLadaSuperApi)
        txtTelefonoSuperApi = findViewById(R.id.txtTelefonoSuperApi)
        btnCrearCuentaSuperApi = findViewById(R.id.btnCrearCuentaSuperApi)

        cardNombre_superapi = findViewById(R.id.cardNombre_superapi)
        cardApellidoPaterno_superapi = findViewById(R.id.cardApellidoPaterno_superapi)
        cardApellidoMaterno_superapi = findViewById(R.id.cardApellidoMaterno_superapi)
        cardCorreoElectronico_superapi = findViewById(R.id.cardCorreoElectronico_superapi)
        cardContrasenaConfirmar_superapi = findViewById(R.id.cardContrasenaConfirmar_superapi)
        cardContrasena_superapi = findViewById(R.id.cardContrasena_superapi)
        cardTelefono_superapi = findViewById(R.id.cardTelefono_superapi)
        checkTerminos_superapi = findViewById(R.id.checkTerminos_superapi)

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

        txtCorreoElectronicoSuperApi.text = modelsDataPolicySuperapi.email

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

        txtCorreoElectronicoSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardCorreoElectronico_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtCorreoElectronicoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardCorreoElectronico_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtCorreoElectronicoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
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

        txtConfirmarContrasenaSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardContrasenaConfirmar_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtConfirmarContrasenaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardContrasenaConfirmar_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtConfirmarContrasenaSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtTelefonoSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<2){
                    cardTelefono_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.grey1_superapi)
                    txtTelefonoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.grey2_superapi))
                } else{
                    cardTelefono_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
                    txtTelefonoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))
                }
            }
        })

        txtNombreSuperApi.text = modelsDataPolicySuperapi.name
        cardNombre_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
        txtNombreSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))

        txtApellidoPaternoSuperApi.text = modelsDataPolicySuperapi.paternalSurname
        cardApellidoPaterno_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
        txtApellidoPaternoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))

        txtApellidoMaternoSuperApi.text = modelsDataPolicySuperapi.maternalSurname
        cardApellidoMaterno_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
        txtApellidoMaternoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))

        txtCorreoElectronicoSuperApi.text = modelsDataPolicySuperapi.email
        cardCorreoElectronico_superapi.backgroundTintList = ContextCompat.getColorStateList(baseContext, R.color.purple1_superapi)
        txtCorreoElectronicoSuperApi.setTextColor(ContextCompat.getColor(baseContext, R.color.black1_superapi))

        btnCrearCuentaSuperApi.setOnClickListener {
            if (txtNombreSuperApi.text.isNotEmpty()) {
                if (txtApellidoPaternoSuperApi.text.isNotEmpty()) {
                    if (txtApellidoMaternoSuperApi.text.isNotEmpty()) {
                        if (txtCorreoElectronicoSuperApi.text.isNotEmpty()) {
                            if (txtContrasenaSuperApi.text.isNotEmpty()) {
                                if (txtContrasenaSuperApi.text.length>=8) {
                                    if (txtContrasenaSuperApi.text.toString().equals(txtConfirmarContrasenaSuperApi.text.toString())) {
                                        if (txtTelefonoSuperApi.text.isNotEmpty()) {
                                            if(checkTerminos_superapi.isChecked){
                                                val map: HashMap<String, Any> = HashMap()
                                                map["uid"] = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                                                map["name"] = txtNombreSuperApi.text.toString()
                                                map["paternalSurname"] = txtApellidoPaternoSuperApi.text.toString()
                                                map["maternalSurname"] = txtApellidoMaternoSuperApi.text.toString()
                                                map["email"] = txtCorreoElectronicoSuperApi.text.toString()
                                                map["password"] = txtContrasenaSuperApi.text.toString()
                                                map["prefijo"] = "52"
                                                map["phoneNumber"] = txtTelefonoSuperApi.text.toString()
                                                map["latitud"] = "0.0"
                                                map["longitud"] = "0.0"
                                                map["comoConocio"] = "Super"
                                                map["origen"] = "Super"
                                                helperConnectSuperApi.registerUser(this, map)
                                            }
                                            else
                                                Toast.makeText(this, R.string.aceptaElAvisoDePrivacidad_superapi, Toast.LENGTH_LONG).show()
                                        } else
                                            Toast.makeText(this, R.string.agregaUnTelefono_superapi, Toast.LENGTH_LONG).show()
                                    } else
                                        Toast.makeText(this, R.string.lasContrasenasNoCoinciden_superapi, Toast.LENGTH_LONG).show()
                                } else
                                    Toast.makeText(this, R.string.laContrasenaDebeTenerAlMenos8Caracteres_superapi, Toast.LENGTH_LONG).show()
                            } else
                                Toast.makeText(this, R.string.agregaUnaContrasena_superapi, Toast.LENGTH_LONG).show()
                        } else
                            Toast.makeText(this, R.string.agregaUnCorreoElectrónico_superapi, Toast.LENGTH_LONG).show()
                    } else
                        Toast.makeText(this, R.string.agregaUnApellidoPaterno_superapi, Toast.LENGTH_LONG).show()
                } else
                    Toast.makeText(this, R.string.agregaUnApellidoPaterno_superapi, Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(this, R.string.agregaUnNombre_superapi, Toast.LENGTH_LONG).show()
        }
    }
}