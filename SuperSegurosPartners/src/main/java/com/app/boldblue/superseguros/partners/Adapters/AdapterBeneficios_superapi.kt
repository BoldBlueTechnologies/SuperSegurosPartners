package com.app.boldblue.superseguros.partners.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_coberturas
import com.app.boldblue.superseguros.partners.Methods.models_beneficios_superapi
import com.app.boldblue.superseguros.partners.R
import java.util.ArrayList

class AdapterBeneficios_superapi (array: ArrayList<models_beneficios_superapi>, activity: fragment_coberturas): RecyclerView.Adapter<AdapterBeneficios_superapi.ARViewHolder>() {
    var array = array
    var activity = activity
    private var context: Context? = null

    class ARViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitulo_superapi = itemView.findViewById<TextView>(R.id.txtTitulo_superapi)
        var txtsubTitulo_superapi = itemView.findViewById<TextView>(R.id.txtsubTitulo_superapi)
        var imgOpen_superapi = itemView.findViewById<ImageView>(R.id.imgOpen_superapi)
        var txtTexto_superapi = itemView.findViewById<TextView>(R.id.txtTexto_superapi)
        var btnCardOpen_superapi = itemView.findViewById<CardView>(R.id.btnCardOpen_superapi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ARViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_beneficios_superapi, parent, false)
        val arv = ARViewHolder(v)
        context = parent.context
        return arv
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ARViewHolder, vr: Int) {
        holder.txtTitulo_superapi.text= array[vr].descripcionCobertura
        holder.txtsubTitulo_superapi.text=array[vr].montoFormateadoCobertura
        holder.txtTexto_superapi.text=array[vr].descripcionLarga
        holder.txtsubTitulo_superapi.setOnClickListener {
            if(array[vr].idCobertura !="-1"){
                holder.txtTexto_superapi.visibility=View.VISIBLE
                array[vr].idCobertura="-1"
            }else{
                holder.txtTexto_superapi.visibility=View.GONE
                array[vr].idCobertura="28"
            }
        }
        holder.imgOpen_superapi.setOnClickListener {
            if(array[vr].idCobertura !="-1"){
                holder.txtTexto_superapi.visibility=View.VISIBLE
                array[vr].idCobertura="-1"
            }else{
                holder.txtTexto_superapi.visibility=View.GONE
                array[vr].idCobertura="28"
            }
        }

        holder.txtTitulo_superapi.setOnClickListener {
            if(array[vr].idCobertura !="-1"){
                holder.txtTexto_superapi.visibility=View.VISIBLE
                array[vr].idCobertura="-1"
            }else{
                holder.txtTexto_superapi.visibility=View.GONE
                array[vr].idCobertura="28"
            }
        }
        holder.txtTexto_superapi.setOnClickListener {
            if(array[vr].idCobertura !="-1"){
                holder.txtTexto_superapi.visibility=View.VISIBLE
                array[vr].idCobertura="-1"
            }else{
                holder.txtTexto_superapi.visibility=View.GONE
                array[vr].idCobertura="28"
            }
        }
    }
}