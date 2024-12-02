package com.app.boldblue.superseguros.partners.Main.coberturas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_cuatro_superapi

class fragment_coberturas : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_coberturas_aseguradoras_superapi, container, false)
        var btnCotiza_superapi = view.findViewById<CardView>(R.id.btnCotiza_superapi)
        btnCotiza_superapi.setOnClickListener {
            val intent = Intent(context, Formulario_cuatro_superapi::class.java)
            context?.startActivity(intent)
        }
        return view
    }

}