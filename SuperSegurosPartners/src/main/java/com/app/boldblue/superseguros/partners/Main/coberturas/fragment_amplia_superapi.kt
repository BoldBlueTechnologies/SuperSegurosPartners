package com.app.boldblue.superseguros.partners.Main.coberturas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.app.boldblue.superseguros.partners.R

class fragment_amplia_superapi : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_coberturas_superapi, container, false)
        val itemCobertura : LinearLayout = view.findViewById(R.id.itemCoberturas_superapi)
        itemCobertura.visibility= View.GONE
        return view
    }

}