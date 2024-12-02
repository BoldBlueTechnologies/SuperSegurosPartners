package com.app.boldblue.superseguros.partners.SeguroAuto

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.R

class Formulario_cinco_superapi : AppCompatActivity() {

    private lateinit var txtMatriculaSuperApi : TextView
    private lateinit var txtVINSuperApi : TextView
    private lateinit var txtNumeroMotorSuperApi : TextView
    private lateinit var cardUsoVehiculo_superapi : CardView
    private lateinit var txtUsoVehiculoSuperApi : TextView
    private lateinit var btnContinuarSuperApi : CardView

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
        txtMatriculaSuperApi = findViewById(R.id.txtMatriculaSuperApi)
        txtVINSuperApi = findViewById(R.id.txtVINSuperApi)
        txtNumeroMotorSuperApi = findViewById(R.id.txtNumeroMotorSuperApi)
        cardUsoVehiculo_superapi = findViewById(R.id.cardUsoVehiculo_superapi)
        txtUsoVehiculoSuperApi = findViewById(R.id.txtUsoVehiculoSuperApi)
        btnContinuarSuperApi = findViewById(R.id.btnContinuarSuperApi)
        btnContinuarSuperApi.setOnClickListener {
            val intent = Intent(this, Formulario_seis_superapi::class.java)
            startActivity(intent)
        }
    }
}