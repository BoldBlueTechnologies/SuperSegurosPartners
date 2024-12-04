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
import com.app.boldblue.superseguros.partners.R.*
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi

class Formulario_uno_superapi : AppCompatActivity() {

    var tokenSuperApi = ""
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

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_formulario_uno_superapi)
        val helperConnectSuperApi = HelperConnectSuperApi()
        val map = HashMap<String,Any>()
        map["email"]="marodriguez@midoconline.com"
        map["password"]="12345678"
        helperConnectSuperApi.login(map,this)

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
            intent.putExtra("marcaSuperApi",txtMarcaSuperApi.text.toString())
            intent.putExtra("anoSuperApi",txtAnoSuperApi.text.toString())
            intent.putExtra("modeloSuperApi",txtModeloSuperApi.text.toString())
            intent.putExtra("versionSuperApi",txtVersionSuperApi.text.toString())
            intent.putExtra("cpSuperApi",txtCPSuperApi.text.toString())
            intent.putExtra("tokenSuperApi",tokenSuperApi)
            resultadoLauncher.launch(intent)
        }
        itemTipoSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tokenSuperApi",tokenSuperApi)
            intent.putExtra("tipoSuperApi",0)
            resultadoLauncher.launch(intent)
        }
        itemAnoSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tokenSuperApi",tokenSuperApi)
            intent.putExtra("tipoSuperApi",1)
            resultadoLauncher.launch(intent)
        }
        itemMarcaSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tokenSuperApi",tokenSuperApi)
            intent.putExtra("tipoSuperApi",2)
            resultadoLauncher.launch(intent)
        }
        itemModeloSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tokenSuperApi",tokenSuperApi)
            intent.putExtra("tipoSuperApi",3)
            resultadoLauncher.launch(intent)
        }
        itemVersionSuperApi.setOnClickListener {
            val intent = Intent(this, Listados::class.java)
            intent.putExtra("tokenSuperApi",tokenSuperApi)
            intent.putExtra("tipoSuperApi",4)
            resultadoLauncher.launch(intent)
        }
        txtCPSuperApi.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(s!!.length<5){
                    btnCotizaSuperApi.visibility= View.GONE
                    cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(baseContext, color.grey1_superapi)
                } else{
                    btnCotizaSuperApi.visibility=View.VISIBLE
                    cardCPSuperApi.backgroundTintList = ContextCompat.getColorStateList(baseContext, color.purple1_superapi)
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
                    if(data.getStringExtra("campoSuperApi") !=""){
                        txtTipoSuperApi.text = data.getStringExtra("campoSuperApi")
                        cardTipoSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemAnoSuperApi.visibility = View.VISIBLE
                    }
                }
                1 -> {
                    if(data.getStringExtra("campoSuperApi") !=""){
                        txtAnoSuperApi.text = data.getStringExtra("campoSuperApi")
                        cardAnoSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemMarcaSuperApi.visibility = View.VISIBLE
                    }
                }
                2 -> {
                    if(data.getStringExtra("campoSuperApi") !=""){
                        txtMarcaSuperApi.text = data.getStringExtra("campoSuperApi")
                        cardMarcaSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemModeloSuperApi.visibility = View.VISIBLE
                    }
                }
                3 -> {
                    if(data.getStringExtra("campoSuperApi") !=""){
                        txtModeloSuperApi.text = data.getStringExtra("campoSuperApi")
                        cardModeloSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemVersionSuperApi.visibility = View.VISIBLE
                    }
                }
                4 -> {
                    if(data.getStringExtra("campoSuperApi") !=""){
                        txtVersionSuperApi.text = data.getStringExtra("campoSuperApi")
                        cardVersionSuperApi.backgroundTintList = ContextCompat.getColorStateList(this, color.purple1_superapi)
                        itemCPSuperApi.visibility = View.VISIBLE
                    }
                }

                28 -> {
                    itemAnoSuperApi.visibility = View.GONE
                    itemModeloSuperApi.visibility = View.GONE
                    itemVersionSuperApi.visibility = View.GONE
                    itemCPSuperApi.visibility = View.GONE
                    txtMarcaSuperApi.text = resources.getString(string.seleccionaLaMarcaDeTuAuto_superapi)
                    txtAnoSuperApi.text = resources.getString(string.seleccionaElAnoDeTuAuto_superapi)
                    txtModeloSuperApi.text = resources.getString(string.seleccionaElModeloDeTuAuto_superapi)
                    txtVersionSuperApi.text = resources.getString(string.seleccionaLaVersionDeTuAuto_superapi)
                    txtCPSuperApi.text = ""
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