package com.app.boldblue.superseguros.partners.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.BuildConfig
import com.app.boldblue.superseguros.partners.Methods.models_list_insurance_superapi
import com.app.boldblue.superseguros.partners.Methods.models_list_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_dos_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_tres_superapi
import com.squareup.picasso.Picasso

class AdapterAseguradoras_superapi (arrayList:ArrayList<models_list_insurance_superapi>, activity: Formulario_dos_superapi): RecyclerView.Adapter<AdapterAseguradoras_superapi.ARViewHolder>() {
    var arrayList = arrayList
    var activity = activity
    private var context: Context? = null

    class ARViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardAseguradoras_superapi = itemView.findViewById<CardView>(R.id.cardAseguradoras_superapi)
        var txtPrecio_superapi = itemView.findViewById<TextView>(R.id.txtPrecio_superapi)
        var imgAseguradoras_superapi = itemView.findViewById<ImageView>(R.id.imgAseguradoras_superapi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ARViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.items_aseguradoras_superapi, parent, false)
        val arv = ARViewHolder(v)
        context = parent.context
        return arv
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ARViewHolder, vr: Int) {
        holder.txtPrecio_superapi.text = "$${arrayList[vr].monto} MXN"
        Picasso.get()
        .load(BuildConfig.photosSuper+arrayList[vr].img)
        .into(holder.imgAseguradoras_superapi)
        holder.cardAseguradoras_superapi.setOnClickListener {
            activity.modelsDataPolicySuperapi.insurance = arrayList[vr].aseguradora
            val intent = Intent(activity, Formulario_tres_superapi::class.java)
            intent.putExtra("vehicleType",activity.modelsDataPolicySuperapi.vehicleType)
            intent.putExtra("description",activity.modelsDataPolicySuperapi.description)
            intent.putExtra("model",activity.modelsDataPolicySuperapi.model)
            intent.putExtra("nameBrand",activity.modelsDataPolicySuperapi.nameBrand)
            intent.putExtra("brand",activity.modelsDataPolicySuperapi.brand)
            intent.putExtra("nameSubBrand",activity.modelsDataPolicySuperapi.nameSubBrand)
            intent.putExtra("subBrand",activity.modelsDataPolicySuperapi.subBrand)
            intent.putExtra("internalKey",activity.modelsDataPolicySuperapi.internalKey)
            intent.putExtra("autoDescription",activity.modelsDataPolicySuperapi.autoDescription)
            intent.putExtra("insurance",activity.modelsDataPolicySuperapi.insurance)
            intent.putExtra("ZIPCode",activity.modelsDataPolicySuperapi.ZIPCode)
            activity.startActivity(intent)
        }
    }

}