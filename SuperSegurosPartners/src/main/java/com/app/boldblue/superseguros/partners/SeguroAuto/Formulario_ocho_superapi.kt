package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.R

class Formulario_ocho_superapi : AppCompatActivity() {

    private lateinit var txtNombreSuperApi : TextView
    private lateinit var txtApellidoPaternoSuperApi : TextView
    private lateinit var txtApellidoMaternoSuperApi : TextView
    private lateinit var txtCorreoElectronicoSuperApi : TextView
    private lateinit var txtContrasenaSuperApi : TextView
    private lateinit var txtConfirmarContrasenaSuperApi : TextView
    private lateinit var txtLadaSuperApi : TextView
    private lateinit var txtTelefonoSuperApi : TextView
    private lateinit var btnCrearCuentaSuperApi : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_ocho_superapi)
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
        btnCrearCuentaSuperApi.setOnClickListener {
            //val intent = Intent(this, Formulario_cinco_superapi::class.java)
            //startActivity(intent)
        }
    }
}