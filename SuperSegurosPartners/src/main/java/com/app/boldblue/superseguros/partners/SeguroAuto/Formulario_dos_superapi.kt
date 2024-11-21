package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi

class Formulario_dos_superapi : AppCompatActivity() {

    private var marcaSuperApi = ""
    private var anoSuperApi = ""
    private var modeloSuperApi = ""
    private var versionSuperApi = ""
    private var cpSuperApi = ""
    private var tokenSuperApi = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_dos_superapi)

        tokenSuperApi= intent.getStringExtra("tokenSuperApi").toString()
        marcaSuperApi= intent.getStringExtra("marcaSuperApi").toString()
        anoSuperApi= intent.getStringExtra("anoSuperApi").toString()
        modeloSuperApi= intent.getStringExtra("modeloSuperApi").toString()
        versionSuperApi= intent.getStringExtra("versionSuperApi").toString()
        cpSuperApi= intent.getStringExtra("cpSuperApi").toString()
        val helperConnectSuperApi = HelperConnectSuperApi()
        val myToolbar: Toolbar = findViewById(R.id.toolbar_superapi)
        myToolbar.setTitle(R.string.auto_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.purple1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish() }
    }

}