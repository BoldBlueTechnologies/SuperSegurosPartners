package com.app.boldblue.superseguros.partners.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity.RESULT_OK
import androidx.recyclerview.widget.RecyclerView
import com.app.boldblue.superseguros.partners.Methods.models_list_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Listados

class AdapterBusqueda_superapi(arrayList:ArrayList<models_list_superapi>, activity: Listados): RecyclerView.Adapter<AdapterBusqueda_superapi.ARViewHolder>() {

    var arrayList = arrayList
    var activity = activity
    private var context: Context? = null

    class ARViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textbusqueda = itemView.findViewById<TextView>(R.id.textBusqueda_superapi)
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
        holder.textbusqueda.text = arrayList[position].Descripcion
        holder.textbusqueda.setOnClickListener {
            val resultadoIntent = Intent()
            resultadoIntent.putExtra("idSuperApi", arrayList[position].id)
            resultadoIntent.putExtra("descripcionSuperApi", arrayList[position].Descripcion)
            resultadoIntent.putExtra("tipoSuperApi",activity.tipoSuperApi)
            activity.setResult(RESULT_OK, resultadoIntent) // Enviar resultado
            activity.finish()
        }
    }

    fun actualizarLista(nuevaLista: ArrayList<models_list_superapi>) {
        arrayList = nuevaLista
        notifyDataSetChanged()
    }
}