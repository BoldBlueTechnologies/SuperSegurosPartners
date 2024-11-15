package com.app.boldblue.superseguros.partners.SeguroAuto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.widget.Adapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.Adapters.AdapterBusqueda_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.json.JSONArray

class Formulario_uno_superapi : AppCompatActivity() {

    var token= ""
    var arrayListbrand = ArrayList<String>()
    var arrayListYear = ArrayList<String>()
    var arrayListModel = ArrayList<String>()
    var arrayListVersion = ArrayList<String>()
    lateinit var textbrand_superapi : TextView
    lateinit var itemMarca : CardView
    lateinit var itemyear : CardView
    lateinit var itemmodel : CardView
    lateinit var itemversion : CardView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_uno_superapi)
        val helperConnectSuperApi = HelperConnectSuperApi()
        val map = HashMap<String,Any>()

        map["email"]="marodriguez@midoconline.com"
        map["password"]="12345678";
        textbrand_superapi = findViewById(R.id.textbrand_superapi)
        itemMarca = findViewById(R.id.itemMarca_superapi)
        itemyear = findViewById(R.id.itemyear_superapi)
        itemmodel = findViewById(R.id.itemmodel_superapi)
        itemversion = findViewById(R.id.itemversion_superapi)
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
            bottomSheetListado(arrayListbrand)
        }
        itemyear.setOnClickListener {
            bottomSheetListado(arrayListYear)
        }
        itemmodel.setOnClickListener {
            bottomSheetListado(arrayListModel)
        }
        itemversion.setOnClickListener {
            bottomSheetListado(arrayListVersion)
        }
        helperConnectSuperApi.login(map,this)
    }

    fun bottomSheetListado(array: ArrayList<String>) {
        println("------bottomSheetListado---"+array.size)

        val bottomSheetListado = BottomSheetDialog(this)
        bottomSheetListado.setOnShowListener {
            val window = bottomSheetListado.window
            if (window != null) {
                window.setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT
                )
            }
        }
        bottomSheetListado.setContentView(R.layout.sheet_listado_superapi)
        bottomSheetListado.setCanceledOnTouchOutside(false)
        val toolbarSheet = bottomSheetListado.findViewById<Toolbar>(R.id.toolbarSheet)
        val txtSheet = bottomSheetListado.findViewById<EditText>(R.id.txtSheet)
        val imgBorrar = bottomSheetListado.findViewById<ImageView>(R.id.imgBorrar)
        val recyclerSheet = bottomSheetListado.findViewById<RecyclerView>(R.id.recyclerSheet)
        toolbarSheet!!.setTitle(R.string.seleccionaUnaMarca_superapi)
        toolbarSheet.setNavigationIcon(R.drawable.back_purple_superapi)
        toolbarSheet.setTitleTextColor(getColor(R.color.purple1_superapi))
        toolbarSheet.setBackgroundColor(getColor(R.color.white1_superapi))
        setSupportActionBar(toolbarSheet)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarSheet.setNavigationOnClickListener { bottomSheetListado.dismiss() }
        recyclerSheet!!.layoutManager = LinearLayoutManager(this)
        recyclerSheet.hasFixedSize()
        val adapter = AdapterBusqueda_superapi(array,this,bottomSheetListado)
        recyclerSheet.adapter = adapter
        /*if(listEmergencia[0].nombre!="---") {
            recyclerEmergenciaEdit.adapter= AdapterEditarEmergencia(this,listEmergencia)
        }*/
        imgBorrar?.setOnClickListener {
            txtSheet?.text?.clear()
        }

        txtSheet?.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val textoIngresado = s.toString()
                val listafiltrada = array.filter {
                    it.contains(textoIngresado, ignoreCase = true)
                } // Filtra los elementos según el texto ingresado }
                adapter.actualizarLista(ArrayList(listafiltrada))
            }
        })

        bottomSheetListado.show()
    }

}