package com.app.boldblue.superseguros.partners.Main.coberturas

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.Adapters.AdapterBeneficios_superapi
import com.app.boldblue.superseguros.partners.BuildConfig
import com.app.boldblue.superseguros.partners.Methods.models_beneficios_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.Services.HelperConnectSuperApi
import com.squareup.picasso.Picasso
import org.json.JSONArray
import org.json.JSONException
import java.util.ArrayList
import java.util.HashMap

class fragment_coberturas : Fragment() {

    var vehicleType = ""
    var description = ""
    var model = ""
    var nameBrand = ""
    var brand = ""
    var nameSubBrand =""
    var subBrand =""
    var internalKey = ""
    var autoDescription = ""
    var insurance = ""
    var cotizacion = ""
    var ZIPCode =""
    var carQuoteId = ""

    var listFormaPago: Array<String>? = null
    var listNumeroCotizacion: Array<String>? = null
    var listCostoTotal: Array<String>? = null
    var listPrimerRecibo: Array<String>? = null
    var listSubSecuentes: Array<String>? = null

    var paymentForm = ""
    var applicableCoverages = ""
    var quoteNumber = ""
    var totalCost = ""
    var firstReceipt =""
    var subsequents = ""
    var imgAseguradoras = ""

    private var listCoberturasAplicables = ArrayList<models_beneficios_superapi>()

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_coberturas_aseguradoras_superapi, container, false)
        var itemSelect = -1
        var recyclerBeneficios_super_api = view.findViewById<RecyclerView>(R.id.recyclerBeneficios_super_api)
        var btnCotiza_superapi = view.findViewById<CardView>(R.id.btnCotiza_superapi)

        var txtPrecioAnual_superapi = view.findViewById<TextView>(R.id.txtPrecioAnual_superapi)
        var txtDescuentoAnual_superapi = view.findViewById<TextView>(R.id.txtDescuentoAnual_superapi)

        var radioButtonAnual = view.findViewById<RadioButton>(R.id.radioButtonAnual)
        var radioButtonTrimestral = view.findViewById<RadioButton>(R.id.radioButtonTrimestral)
        var radioButtonSemestral = view.findViewById<RadioButton>(R.id.radioButtonSemestral)
        var radioButtonMensual = view.findViewById<RadioButton>(R.id.radioButtonMensual)

        var txtPrecioTrimestral_superapi = view.findViewById<TextView>(R.id.txtPrecioTrimestral_superapi)
        var txtPrimerPagoTrimestral_superapi = view.findViewById<TextView>(R.id.txtPrimerPagoTrimestral_superapi)
        var txtSubsecuentePagoTrimestral_superapi = view.findViewById<TextView>(R.id.txtSubsecuentePagoTrimestral_superapi)

        var txtPrecioSemestral_superapi = view.findViewById<TextView>(R.id.txtPrecioSemestral_superapi)
        var txtPrimerPagoSemestral_superapi = view.findViewById<TextView>(R.id.txtPrimerPagoSemestral_superapi)
        var txtSubsecuentesSemestral_superapi = view.findViewById<TextView>(R.id.txtSubsecuentesSemestral_superapi)

        var txtPrecioMensual_superapi = view.findViewById<TextView>(R.id.txtPrecioMensual_superapi)
        var txtPrimerPagoMensual_superapi = view.findViewById<TextView>(R.id.txtPrimerPagoMensual_superapi)
        var txtSubsecuentesMensual_superapi = view.findViewById<TextView>(R.id.txtSubsecuentesMensual_superapi)

        var txtMarca_superapi = view.findViewById<TextView>(R.id.txtMarca_superapi)
        var txtAno_superapi = view.findViewById<TextView>(R.id.txtAno_superapi)
        var txtModelo_superapi = view.findViewById<TextView>(R.id.txtModelo_superapi)
        var txtVersion_superapi = view.findViewById<TextView>(R.id.txtVersion_superapi)
        var txtPrecio_superapi = view.findViewById<TextView>(R.id.txtPrecio_superapi)
        var txtTipoPago_superapi = view.findViewById<TextView>(R.id.txtTipoPago_superapi)

        var imgAseguradoras_superapi = view.findViewById<ImageView>(R.id.imgAseguradoras_superapi)

        vehicleType = arguments?.getString("vehicleType") ?: "---"
        description = arguments?.getString("description") ?: "---"
        model = arguments?.getString("model") ?: "---"
        nameBrand = arguments?.getString("nameBrand") ?: "---"
        brand = arguments?.getString("brand") ?: "---"
        nameSubBrand = arguments?.getString("nameSubBrand") ?: "---"
        subBrand = arguments?.getString("subBrand") ?: "---"
        internalKey = arguments?.getString("internalKey") ?: "---"
        autoDescription = arguments?.getString("autoDescription") ?: "---"
        insurance = arguments?.getString("insurance") ?: "---"
        cotizacion = arguments?.getString("cotizacion") ?: "---"
        ZIPCode = arguments?.getString("ZIPCode") ?: "---"
        carQuoteId = arguments?.getString("carQuoteId") ?: "---"
        imgAseguradoras = arguments?.getString("imgAseguradoras") ?: "---"

        try {
            var jsonData = JSONArray(arguments?.getString("coberturasAplicables"))
            for(vr in 0 until jsonData.length()) {
                println("-------------------${jsonData[vr]}--------$vr")
                listCoberturasAplicables.add(models_beneficios_superapi(
                    jsonData.getJSONObject(vr).getString("idCobertura"),
                    jsonData.getJSONObject(vr).getString("descripcionCobertura"),
                    jsonData.getJSONObject(vr).getString("montoFormateadoCobertura"),
                    jsonData.getJSONObject(vr).getString("descripcionLarga")
                ))
            }
        }catch (error : JSONException){
            println("JSONExceptionlistCoberturasAplicables--------${error}")
        }
        Picasso.get()
            .load((BuildConfig.photosSuper + imgAseguradoras))
            .into(imgAseguradoras_superapi)
        listFormaPago= arguments?.getStringArray("listFormaPago")
        listNumeroCotizacion= arguments?.getStringArray("listNumeroCotizacion")
        listCostoTotal= arguments?.getStringArray("listCostoTotal")
        listPrimerRecibo= arguments?.getStringArray("listPrimerRecibo")
        listSubSecuentes= arguments?.getStringArray("listSubSecuentes")

        recyclerBeneficios_super_api.layoutManager = LinearLayoutManager(requireContext())
        recyclerBeneficios_super_api.hasFixedSize()
        recyclerBeneficios_super_api.adapter = AdapterBeneficios_superapi(listCoberturasAplicables,this)

        txtMarca_superapi.text= nameBrand
        txtAno_superapi.text= model
        txtModelo_superapi.text= nameSubBrand
        txtVersion_superapi.text=autoDescription

        for(vr in listFormaPago!!.indices) {
            if(listFormaPago!![vr]=="Anual"){
                txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                txtTipoPago_superapi.text = listFormaPago!![vr]
                itemSelect = vr
                radioButtonTrimestral.isChecked = false
                radioButtonSemestral.isChecked = false
                radioButtonMensual.isChecked = false
            }
        }

        radioButtonAnual.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                for(vr in listFormaPago!!.indices) {
                    if(listFormaPago!![vr]=="Anual"){
                        txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                        txtTipoPago_superapi.text = listFormaPago!![vr]
                        itemSelect = vr
                        radioButtonTrimestral.isChecked = false
                        radioButtonSemestral.isChecked = false
                        radioButtonMensual.isChecked = false
                    }
                }
            }
        }
        radioButtonTrimestral.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                for(vr in listFormaPago!!.indices) {
                    if(listFormaPago!![vr]=="Trimestral"){
                        txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                        txtTipoPago_superapi.text = listFormaPago!![vr]
                        itemSelect = vr
                        radioButtonAnual.isChecked = false
                        radioButtonSemestral.isChecked = false
                        radioButtonMensual.isChecked = false
                    }
                }
            }
        }
        radioButtonSemestral.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                for(vr in listFormaPago!!.indices) {
                    if(listFormaPago!![vr]=="Semestral"){
                        txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                        txtTipoPago_superapi.text = listFormaPago!![vr]
                        itemSelect = vr
                        radioButtonAnual.isChecked = false
                        radioButtonTrimestral.isChecked = false
                        radioButtonMensual.isChecked = false
                    }
                }
            }
        }
        radioButtonMensual.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                for(vr in listFormaPago!!.indices) {
                    if(listFormaPago!![vr]=="Mensual"){
                        txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                        txtTipoPago_superapi.text = listFormaPago!![vr]
                        itemSelect = vr
                        radioButtonAnual.isChecked = false
                        radioButtonSemestral.isChecked = false
                        radioButtonTrimestral.isChecked = false
                    }
                }

            }
        }
        println("-------------------$cotizacion")

        for(vr in listFormaPago!!.indices) {
            if(listFormaPago!![vr]=="Anual"){
                txtPrecioAnual_superapi.text = "$${listCostoTotal!![vr]}"
                for(rv in listFormaPago!!.indices) {
                    if(listFormaPago!![rv]=="Mensual"){
                        txtDescuentoAnual_superapi.text = "$${ String.format("%.2f", (listCostoTotal!![rv].replace(",","").toDouble()- listCostoTotal!![vr].replace(",","").toDouble())).toDouble()} más barato"
                    }
                }
            }
            if(listFormaPago!![vr]=="Semestral"){
                txtPrecioSemestral_superapi.text = "$${listCostoTotal!![vr]}"
                txtPrimerPagoSemestral_superapi.text = "$${listPrimerRecibo!![vr]}"
                txtSubsecuentesSemestral_superapi.text = "$${listSubSecuentes!![vr]}"
            }
            if(listFormaPago!![vr]=="Trimestral"){
                txtPrecioTrimestral_superapi.text = "$${listCostoTotal!![vr]}"
                txtPrimerPagoTrimestral_superapi.text = "$${listPrimerRecibo!![vr]}"
                txtSubsecuentePagoTrimestral_superapi.text = "$${listSubSecuentes!![vr]}"
            }
            if(listFormaPago!![vr]=="Mensual"){
                txtPrecioMensual_superapi.text = "$${listCostoTotal!![vr]}"
                txtPrimerPagoMensual_superapi.text = "$${listPrimerRecibo!![vr]}"
                txtSubsecuentesMensual_superapi.text = "$${listSubSecuentes!![vr]}"
            }
        }

        btnCotiza_superapi.setOnClickListener {

            paymentForm= listFormaPago!![itemSelect]
            //applicableCoverages= listCoberturasAplicables!![itemSelect]
            quoteNumber= listNumeroCotizacion!![itemSelect]
            totalCost= listCostoTotal!![itemSelect]
            firstReceipt= listPrimerRecibo!![itemSelect]
            subsequents= listSubSecuentes!![itemSelect]

            val map: HashMap<String, Any> = HashMap()
            map["carQuoteId"]=carQuoteId
            map["insurer"]= insurance
            map["plan"]= listFormaPago!![itemSelect]
            map["coverage"]= cotizacion
            HelperConnectSuperApi().saveCoverages(this,map)


        }
        return view
    }


}