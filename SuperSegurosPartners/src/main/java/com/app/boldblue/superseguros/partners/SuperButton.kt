package com.app.boldblue.superseguros.partners

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView

class SuperButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
    ): LinearLayout(context,attrs,defStyle,defStyleRes){
        init {
            LayoutInflater.from(context).inflate(R.layout.component_btn_super, this, true)
            val btnSuper = findViewById<CardView>(R.id.btnSuper)
            btnSuper.setOnClickListener {
                Toast.makeText(context,"Soy un cacahuate ",Toast.LENGTH_SHORT).show()
            }
        }
}