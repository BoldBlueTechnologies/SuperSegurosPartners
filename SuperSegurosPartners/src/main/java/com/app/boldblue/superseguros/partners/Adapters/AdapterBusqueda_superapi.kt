package com.app.boldblue.superseguros.partners.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_uno_superapi
import com.google.android.material.bottomsheet.BottomSheetDialog

class AdapterBusqueda_superapi(arrayList:ArrayList<String>, activity: Formulario_uno_superapi, dialog: BottomSheetDialog): RecyclerView.Adapter<AdapterBusqueda_superapi.ARViewHolder>() {
    var arrayList = arrayList
    var dialog = dialog
    var activity = activity
    private var context: Context? = null

    class ARViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textbusqueda = itemView.findViewById<TextView>(R.id.textBusqueda_superapi)
        var linebusqueda = itemView.findViewById<View>(R.id.linebusqueda_superapi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ARViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.items_busqueda_superapi, parent, false)
        val arv = ARViewHolder(v)
        context = parent.context
        return arv
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ARViewHolder, position: Int) {
        holder.textbusqueda.text = arrayList[position]
        holder.textbusqueda.setOnClickListener {
            println("------exito-------"+arrayList[position])
            dialog.dismiss()
            activity.textbrand_superapi.text = arrayList[position]
            activity.itemMarca.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.purple1_superapi)
        }
    }

    fun actualizarLista(nuevaLista: ArrayList<String>) {
        arrayList = nuevaLista
        notifyDataSetChanged() // Notifica al RecyclerView que los datos han cambiado
    }
}