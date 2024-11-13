package com.app.boldblue.superseguros.partners

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import com.app.boldblue.superseguros.partners.Main.Principal_superapi

class SuperButton_superapi @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
    ): LinearLayout(context,attrs,defStyle,defStyleRes){
        init {
            LayoutInflater.from(context).inflate(R.layout.btn_super_superapi, this, true)
            val btnSuper = findViewById<CardView>(R.id.btnSuper)
            btnSuper.setOnClickListener {
                val intent = Intent(context, Principal_superapi::class.java)
                context.startActivity(intent)
            }
        }
}