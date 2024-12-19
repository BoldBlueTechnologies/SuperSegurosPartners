package com.app.boldblue.superseguros.partners.Main.coberturas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_cuatro_superapi

class fragment_coberturas : Fragment() {
    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_coberturas_aseguradoras_superapi, container, false)
        var itemSelect = -1
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

        val vehicleType = arguments?.getString("vehicleType") ?: "---"
        val description = arguments?.getString("description") ?: "---"
        val model = arguments?.getString("model") ?: "---"
        val nameBrand = arguments?.getString("nameBrand") ?: "---"
        val brand = arguments?.getString("brand") ?: "---"
        val nameSubBrand = arguments?.getString("nameSubBrand") ?: "---"
        val subBrand = arguments?.getString("subBrand") ?: "---"
        val internalKey = arguments?.getString("internalKey") ?: "---"
        val autoDescription = arguments?.getString("autoDescription") ?: "---"
        val insurance = arguments?.getString("insurance") ?: "---"
        val cotizacion = arguments?.getString("cotizacion") ?: "---"
        val ZIPCode = arguments?.getString("ZIPCode") ?: "---"

        val listFormaPago: Array<String>? = arguments?.getStringArray("listFormaPago")
        val listCoberturasAplicables: Array<String>? = arguments?.getStringArray("listCoberturasAplicables")
        val listNumeroCotizacion: Array<String>? = arguments?.getStringArray("listNumeroCotizacion")
        val listCostoTotal: Array<String>? = arguments?.getStringArray("listCostoTotal")
        val listPrimerRecibo: Array<String>? = arguments?.getStringArray("listPrimerRecibo")
        val listSubSecuentes: Array<String>? = arguments?.getStringArray("listSubSecuentes")

        txtMarca_superapi.text= nameBrand
        txtAno_superapi.text= model
        txtModelo_superapi.text= nameSubBrand
        txtVersion_superapi.text=autoDescription

        for(vr in listFormaPago!!.indices) {
            if(listFormaPago[vr]=="Anual"){
                txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                txtTipoPago_superapi.text = listFormaPago[vr]
                itemSelect = vr
                radioButtonTrimestral.isChecked = false
                radioButtonSemestral.isChecked = false
                radioButtonMensual.isChecked = false
            }
        }

        radioButtonAnual.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                for(vr in listFormaPago.indices) {
                    if(listFormaPago[vr]=="Anual"){
                        txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                        txtTipoPago_superapi.text = listFormaPago[vr]
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
                for(vr in listFormaPago.indices) {
                    if(listFormaPago[vr]=="Trimestral"){
                        txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                        txtTipoPago_superapi.text = listFormaPago[vr]
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
                for(vr in listFormaPago.indices) {
                    if(listFormaPago[vr]=="Semestral"){
                        txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                        txtTipoPago_superapi.text = listFormaPago[vr]
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
                for(vr in listFormaPago.indices) {
                    if(listFormaPago[vr]=="Mensual"){
                        txtPrecio_superapi.text = "$${listCostoTotal!![vr]}"
                        txtTipoPago_superapi.text = listFormaPago[vr]
                        itemSelect = vr
                        radioButtonAnual.isChecked = false
                        radioButtonSemestral.isChecked = false
                        radioButtonTrimestral.isChecked = false
                    }
                }

            }
        }
        println("-------------------$cotizacion")
        for(vr in listFormaPago.indices) {
            if(listFormaPago[vr]=="Anual"){
                txtPrecioAnual_superapi.text = "$${listCostoTotal!![vr]}"
                for(rv in listFormaPago.indices) {
                    if(listFormaPago[rv]=="Mensual"){
                        txtDescuentoAnual_superapi.text = "$${ String.format("%.2f", (listCostoTotal[rv].replace(",","").toDouble()- listCostoTotal[vr].replace(",","").toDouble())).toDouble()} más barato"
                    }
                }
            }
            if(listFormaPago[vr]=="Semestral"){
                txtPrecioSemestral_superapi.text = "$${listCostoTotal!![vr]}"
                txtPrimerPagoSemestral_superapi.text = "$${listPrimerRecibo!![vr]}"
                txtSubsecuentesSemestral_superapi.text = "$${listSubSecuentes!![vr]}"
            }
            if(listFormaPago[vr]=="Trimestral"){
                txtPrecioTrimestral_superapi.text = "$${listCostoTotal!![vr]}"
                txtPrimerPagoTrimestral_superapi.text = "$${listPrimerRecibo!![vr]}"
                txtSubsecuentePagoTrimestral_superapi.text = "$${listSubSecuentes!![vr]}"
            }
            if(listFormaPago[vr]=="Mensual"){
                txtPrecioMensual_superapi.text = "$${listCostoTotal!![vr]}"
                txtPrimerPagoMensual_superapi.text = "$${listPrimerRecibo!![vr]}"
                txtSubsecuentesMensual_superapi.text = "$${listSubSecuentes!![vr]}"
            }
        }

        btnCotiza_superapi.setOnClickListener {
            val intent = Intent(context, Formulario_cuatro_superapi::class.java)
            intent.putExtra("vehicleType",vehicleType)
            intent.putExtra("description",description)
            intent.putExtra("model",model)
            intent.putExtra("nameBrand",nameBrand)
            intent.putExtra("brand",brand)
            intent.putExtra("nameSubBrand",nameSubBrand)
            intent.putExtra("subBrand",subBrand)
            intent.putExtra("internalKey",internalKey)
            intent.putExtra("autoDescription",autoDescription)
            intent.putExtra("ZIPCode",ZIPCode)
            intent.putExtra("insurance",insurance)

            intent.putExtra("paymentForm", listFormaPago[itemSelect])
            intent.putExtra("applicableCoverages",listCoberturasAplicables!![itemSelect])
            intent.putExtra("quoteNumber",listNumeroCotizacion!![itemSelect])
            intent.putExtra("totalCost",listCostoTotal!![itemSelect])
            intent.putExtra("firstReceipt",listPrimerRecibo!![itemSelect])
            intent.putExtra("subsequents",listSubSecuentes!![itemSelect])

            context?.startActivity(intent)
        }
        return view
    }

}