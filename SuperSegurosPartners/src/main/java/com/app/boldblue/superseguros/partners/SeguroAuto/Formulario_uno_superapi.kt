package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class Formulario_uno_superapi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_uno_superapi)
        val itemMarca : CardView = findViewById(R.id.itemMarca)
        val myToolbar: Toolbar = findViewById(R.id.toolbar)
        myToolbar.setTitle(R.string.vacio_superapi)
        myToolbar.setNavigationIcon(R.drawable.back_purple_superapi)
        myToolbar.setTitleTextColor(getColor(R.color.white1_superapi))
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        myToolbar.setNavigationOnClickListener { finish() }
        val btnCotiza: CardView = findViewById(R.id.btnCotiza)
        btnCotiza.setOnClickListener {

        }
        itemMarca.setOnClickListener {
            bottomSheetListado()
        }
    }

    fun bottomSheetListado() {
        var bottomSheetListado = BottomSheetDialog(this)
        bottomSheetListado.setContentView(R.layout.sheet_listado_superapi)
        bottomSheetListado.setCanceledOnTouchOutside(false)
        val toolbarSheet = bottomSheetListado.findViewById<Toolbar>(R.id.toolbarSheet)
        val txtSheet = bottomSheetListado.findViewById<TextView>(R.id.txtSheet)
        val imgBorrar = bottomSheetListado.findViewById<ImageView>(R.id.imgBorrar)
        val recyclerSheet = bottomSheetListado.findViewById<RecyclerView>(R.id.recyclerSheet)
        toolbarSheet!!.setTitle(R.string.seleccionaUnaMarca_superapi)
        toolbarSheet.setNavigationIcon(R.drawable.back_purple_superapi)
        toolbarSheet.setTitleTextColor(getColor(R.color.white1_superapi))
        setSupportActionBar(toolbarSheet)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarSheet.setNavigationOnClickListener { bottomSheetListado.dismiss() }
        recyclerSheet!!.layoutManager = LinearLayoutManager(this)
        recyclerSheet.hasFixedSize()
        /*if(listEmergencia[0].nombre!="---") {
            recyclerEmergenciaEdit.adapter= AdapterEditarEmergencia(this,listEmergencia)
        }*/

        bottomSheetListado.show()
    }

}