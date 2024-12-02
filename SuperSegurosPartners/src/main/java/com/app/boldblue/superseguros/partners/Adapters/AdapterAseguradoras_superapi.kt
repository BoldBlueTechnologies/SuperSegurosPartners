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
import com.app.boldblue.superseguros.partners.Methods.models_aseguradoras_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_dos_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_tres_superapi
import com.squareup.picasso.Picasso

class AdapterAseguradoras_superapi (arrayList:ArrayList<models_aseguradoras_superapi>, activity: Formulario_dos_superapi): RecyclerView.Adapter<AdapterAseguradoras_superapi.ARViewHolder>() {
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

    override fun onBindViewHolder(holder: ARViewHolder, position: Int) {
        holder.txtPrecio_superapi.text = "$${arrayList[position].precioAseguradoras_superapi} MXN"
        Picasso.get()
        .load(BuildConfig.photosSuper+arrayList[position].imgAseguradoras_superapi) // URL de la imagen
        .into(holder.imgAseguradoras_superapi)
        holder.cardAseguradoras_superapi.setOnClickListener {
            val intent = Intent(activity, Formulario_tres_superapi::class.java)
            intent.putExtra("idAseguradora",arrayList[position].idAseguradoras_superapi)
            activity.startActivity(intent)
        }
    }

}