package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.app.boldblue.superseguros.partners.Methods.models_data_policy_superapi
import com.app.boldblue.superseguros.partners.R.*

class Formulario_uno_superapi : AppCompatActivity() {

    private lateinit var txtCPSuperApi : TextView
    private lateinit var cardCPSuperApi : CardView
    private lateinit var itemCPSuperApi : LinearLayout

    private lateinit var btnCotizaSuperApi : CardView

    private lateinit var itemVersionSuperApi : LinearLayout
    private lateinit var cardVersionSuperApi : CardView
    private lateinit var txtVersionSuperApi : TextView

    private lateinit var itemModeloSuperApi : LinearLayout
    private lateinit var cardModeloSuperApi : CardView
    private lateinit var txtModeloSuperApi : TextView

    private lateinit var itemAnoSuperApi : LinearLayout
    private lateinit var cardAnoSuperApi : CardView
    private lateinit var txtAnoSuperApi : TextView

    private lateinit var itemMarcaSuperApi : LinearLayout
    private lateinit var cardMarcaSuperApi : CardView
    private lateinit var txtMarcaSuperApi : TextView

    private lateinit var itemTipoSuperApi : LinearLayout
    private lateinit var cardTipoSuperApi : CardView
    private lateinit var txtTipoSuperApi : TextView

    private lateinit var modelsDataPolicySuperapi: models_data_policy_superapi

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_formulario_uno_superapi)

        modelsDataPolicySuperapi = models_data_policy_superapi()
        txtCPSuperApi = findViewById(id.txtCPSuperApi)
        cardCPSuperApi = findViewById(id.cardCPSuperApi)
        itemCPSuperApi = findViewById(id.itemCPSuperApi)

        itemVersionSuperApi = findViewById(id.itemVersionSuperApi)
        cardVersionSuperApi = findViewById(id.cardVersionSuperApi)
        txtVersionSuperApi = findViewById(id.txtVersionSuperApi)

        itemModeloSuperApi = findViewById(id.itemModeloSuperApi)
        cardModeloSuperApi = findViewById(id.cardModeloSuperApi)
        txtModeloSuperApi = findViewById(id.txtModeloSuperApi)

        itemAnoSuperApi = findViewById(id.itemAnoSuperApi)
        cardAnoSuperApi = findViewById(id.cardAnoSuperApi)
        txtAnoSuperApi = findViewById(id.txtAnoSuperApi)

        itemMarcaSuperApi = findViewById(id.itemMarcaSuperApi)
        cardMarcaSuperApi = findViewById(id.cardMarcaSuperApi)
        txtMarcaSuperApi = findViewById(id.txtMarcaSuperApi)

        itemTipoSuperApi = findViewById(id.itemTipoSuperApi)
        cardTipoSuperApi = findViewById(id.cardTipoSuperApi)
        txtTipoSuperApi = findViewById(id.txtTipoSuperApi)

        btnCotizaSuperApi = findViewById(id.btnCotizaSuperApi)

        val myToolbar: Toolbar = findViewById(id.toolbar_superapi)
        myToolbar.setTitle(string.auto_superapi)
        myToolbar.setNavigationIcon(drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish() }
        btnCotizaSuperApi.setOnClickListener {
            val intent = Intent(this, Formulario_dos_superapi::class.java)
            intent.putExtra("vehicleType",modelsDataPolicySuperapi.vehicleType)
            intent.putExtra("description",modelsDataPolicySuperapi.description)
            intent.putExtra("model",modelsDataPolicySuperapi.model)
            intent.putExtra("nameBrand",modelsDataPolicySuperapi.nameBrand)
            intent.putExtra("brand",modelsDataPolicySuperapi.brand)
            intent.putExtra("nameSubBrand",modelsDataPolicySuperapi.nameSubBrand)
            intent.putExtra("subBrand",modelsDataPolicySuperapi.subBrand)
            intent.putExtra("internalKey",modelsDataPolicySuperapi.internalKey)
            intent.putExtra("autoDescription",modelsDataPolicySuperapi.autoDescription)
            intent.putExtra("ZIPCode",modelsDataPolicySuperapi.ZIPCode)
            resultadoLauncher.launch(intent)
        }
        itemTipoSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tipoSuperApi",0)
            resultadoLauncher.launch(intent)
        }
        itemAnoSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tipoSuperApi",1)
            intent.putExtra("vehicleType",modelsDataPolicySuperapi.vehicleType)
            resultadoLauncher.launch(intent)
        }
        itemMarcaSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("vehicleType",modelsDataPolicySuperapi.vehicleType)
            intent.putExtra("model",modelsDataPolicySuperapi.model)
            intent.putExtra("tipoSuperApi",2)
            resultadoLauncher.launch(intent)
        }
        itemModeloSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tipoSuperApi",3)
            intent.putExtra("vehicleType",modelsDataPolicySuperapi.vehicleType)
            intent.putExtra("model",modelsDataPolicySuperapi.model)
            intent.putExtra("brand",modelsDataPolicySuperapi.brand)
            resultadoLauncher.launch(intent)
        }
        itemVersionSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tipoSuperApi",4)
            intent.putExtra("vehicleType",modelsDataPolicySuperapi.vehicleType)
            intent.putExtra("model",modelsDataPolicySuperapi.model)
            intent.putExtra("brand",modelsDataPolicySuperapi.brand)
            intent.putExtra("subBrand",modelsDataPolicySuperapi.subBrand)
            resultadoLauncher.launch(intent)
        }
        txtCPSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<5){
                    btnCotizaSuperApi.visibility= View.GONE
                    cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(baseContext, color.grey1_superapi)
                    txtCPSuperApi.setTextColor(ContextCompat.getColor(baseContext, color.grey2_superapi))
                } else{
                    modelsDataPolicySuperapi.ZIPCode = s.toString()
                    btnCotizaSuperApi.visibility=View.VISIBLE
                    cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(baseContext, color.purple1_superapi)
                    txtCPSuperApi.setTextColor(ContextCompat.getColor(baseContext, color.black1_superapi))
                }
            }
        })
    }

    private val resultadoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            when (data?.getIntExtra("tipoSuperApi",-1)) {
                0 -> {
                    if(data.getStringExtra("descripcionSuperApi") !=""){
                        modelsDataPolicySuperapi.vehicleType =data.getStringExtra("idSuperApi")!!
                        modelsDataPolicySuperapi.description = data.getStringExtra("descripcionSuperApi")!!
                        println("-----${modelsDataPolicySuperapi.vehicleType}")
                        println("-----${modelsDataPolicySuperapi.description}")
                        txtTipoSuperApi.text = data.getStringExtra("descripcionSuperApi")
                        txtTipoSuperApi.setTextColor(ContextCompat.getColor(this, color.black1_superapi))
                        cardTipoSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemAnoSuperApi.visibility = View.VISIBLE


                        itemMarcaSuperApi.visibility = View.GONE
                        itemModeloSuperApi.visibility = View.GONE
                        itemVersionSuperApi.visibility = View.GONE
                        itemCPSuperApi.visibility = View.GONE
                        txtMarcaSuperApi.text = resources.getString(string.seleccionaLaMarcaDeTuAuto_superapi)
                        txtMarcaSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        txtAnoSuperApi.text = resources.getString(string.seleccionaElAnoDeTuAuto_superapi)
                        txtAnoSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        txtModeloSuperApi.text = resources.getString(string.seleccionaElModeloDeTuAuto_superapi)
                        txtModeloSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        txtVersionSuperApi.text = resources.getString(string.seleccionaLaVersionDeTuAuto_superapi)
                        txtVersionSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        txtCPSuperApi.text = ""
                        txtCPSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        cardMarcaSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardAnoSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardModeloSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardVersionSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    }
                }
                1 -> {
                    if(data.getStringExtra("descripcionSuperApi") !=""){
                        txtAnoSuperApi.text = data.getStringExtra("descripcionSuperApi")
                        txtAnoSuperApi.setTextColor(ContextCompat.getColor(this, color.black1_superapi))
                        modelsDataPolicySuperapi.model =data.getStringExtra("idSuperApi")!!
                        println("-----${modelsDataPolicySuperapi.vehicleType}")
                        println("-----${modelsDataPolicySuperapi.description}")
                        println("-----${modelsDataPolicySuperapi.model}")
                        cardAnoSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemMarcaSuperApi.visibility = View.VISIBLE

                        itemModeloSuperApi.visibility = View.GONE
                        itemVersionSuperApi.visibility = View.GONE
                        itemCPSuperApi.visibility = View.GONE
                        txtModeloSuperApi.text = resources.getString(string.seleccionaElModeloDeTuAuto_superapi)
                        txtModeloSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        txtVersionSuperApi.text = resources.getString(string.seleccionaLaVersionDeTuAuto_superapi)
                        txtVersionSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        txtCPSuperApi.text = ""
                        txtCPSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        cardMarcaSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardModeloSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardVersionSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    }
                }
                2 -> {
                    if(data.getStringExtra("descripcionSuperApi") !=""){
                        txtMarcaSuperApi.text = data.getStringExtra("descripcionSuperApi")
                        txtMarcaSuperApi.setTextColor(ContextCompat.getColor(this, color.black1_superapi))
                        modelsDataPolicySuperapi.brand =data.getStringExtra("idSuperApi")!!
                        modelsDataPolicySuperapi.nameBrand = data.getStringExtra("descripcionSuperApi")!!
                        println("-----${modelsDataPolicySuperapi.vehicleType}")
                        println("-----${modelsDataPolicySuperapi.description}")
                        println("-----${modelsDataPolicySuperapi.model}")
                        println("-----${modelsDataPolicySuperapi.brand}")
                        println("-----${modelsDataPolicySuperapi.nameBrand}")
                        cardMarcaSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemModeloSuperApi.visibility = View.VISIBLE

                        itemVersionSuperApi.visibility = View.GONE
                        itemCPSuperApi.visibility = View.GONE
                        txtVersionSuperApi.text = resources.getString(string.seleccionaLaVersionDeTuAuto_superapi)
                        txtVersionSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        txtCPSuperApi.text = ""
                        txtCPSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        cardModeloSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardVersionSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    }
                }
                3 -> {
                    if(data.getStringExtra("descripcionSuperApi") !=""){
                        txtModeloSuperApi.text = data.getStringExtra("descripcionSuperApi")
                        txtModeloSuperApi.setTextColor(ContextCompat.getColor(this, color.black1_superapi))
                        modelsDataPolicySuperapi.subBrand =data.getStringExtra("idSuperApi")!!
                        modelsDataPolicySuperapi.nameSubBrand = data.getStringExtra("descripcionSuperApi")!!
                        println("-----${modelsDataPolicySuperapi.vehicleType}")
                        println("-----${modelsDataPolicySuperapi.description}")
                        println("-----${modelsDataPolicySuperapi.model}")
                        println("-----${modelsDataPolicySuperapi.brand}")
                        println("-----${modelsDataPolicySuperapi.nameBrand}")
                        println("-----${modelsDataPolicySuperapi.subBrand}")
                        println("-----${modelsDataPolicySuperapi.nameSubBrand}")
                        cardModeloSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemVersionSuperApi.visibility = View.VISIBLE

                        itemCPSuperApi.visibility = View.GONE
                        txtCPSuperApi.text = ""
                        txtCPSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        cardVersionSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                        cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    }
                }
                4 -> {
                    if(data.getStringExtra("descripcionSuperApi") !=""){
                        txtVersionSuperApi.text = data.getStringExtra("descripcionSuperApi")
                        txtVersionSuperApi.setTextColor(ContextCompat.getColor(this, color.black1_superapi))
                        modelsDataPolicySuperapi.internalKey =data.getStringExtra("idSuperApi")!!
                        modelsDataPolicySuperapi.autoDescription = data.getStringExtra("descripcionSuperApi")!!
                        println("-----${modelsDataPolicySuperapi.vehicleType}")
                        println("-----${modelsDataPolicySuperapi.description}")
                        println("-----${modelsDataPolicySuperapi.model}")
                        println("-----${modelsDataPolicySuperapi.brand}")
                        println("-----${modelsDataPolicySuperapi.nameBrand}")
                        println("-----${modelsDataPolicySuperapi.subBrand}")
                        println("-----${modelsDataPolicySuperapi.nameSubBrand}")
                        println("-----${modelsDataPolicySuperapi.internalKey}")
                        println("-----${modelsDataPolicySuperapi.autoDescription}")
                        cardVersionSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemCPSuperApi.visibility = View.VISIBLE

                        txtCPSuperApi.text = ""
                        txtCPSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                        cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    }
                }

                28 -> {
                    itemMarcaSuperApi.visibility = View.GONE
                    itemAnoSuperApi.visibility = View.GONE
                    itemModeloSuperApi.visibility = View.GONE
                    itemVersionSuperApi.visibility = View.GONE
                    itemCPSuperApi.visibility = View.GONE
                    txtTipoSuperApi.text = resources.getString(string.autoOPickup_superapi)
                    txtTipoSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                    txtMarcaSuperApi.text = resources.getString(string.seleccionaLaMarcaDeTuAuto_superapi)
                    txtMarcaSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                    txtAnoSuperApi.text = resources.getString(string.seleccionaElAnoDeTuAuto_superapi)
                    txtAnoSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                    txtModeloSuperApi.text = resources.getString(string.seleccionaElModeloDeTuAuto_superapi)
                    txtModeloSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                    txtVersionSuperApi.text = resources.getString(string.seleccionaLaVersionDeTuAuto_superapi)
                    txtVersionSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                    txtCPSuperApi.text = ""
                    txtCPSuperApi.setTextColor(ContextCompat.getColor(this, color.grey2_superapi))
                    cardMarcaSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    cardAnoSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    cardModeloSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    cardVersionSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                    cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.grey1_superapi)
                }
                else -> {
                    // Acción por defecto
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
    }
}