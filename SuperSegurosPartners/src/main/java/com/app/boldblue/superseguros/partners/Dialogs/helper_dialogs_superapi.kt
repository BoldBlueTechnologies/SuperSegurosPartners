package com.app.boldblue.superseguros.partners.Dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.app.boldblue.superseguros.partners.R

class helper_dialogs_superapi {
    var context: Context
    lateinit var alertDialog : AlertDialog

    constructor(context: Context) {
        this.context = context
    }

    fun progressActivate(titulo : String) {
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.dialog_progress_superapi, null)
        val texto = dialogView.findViewById<TextView>(R.id.txtTitulo_superapi)
        val myProgressBar = dialogView.findViewById<ProgressBar>(R.id.myProgressBar)

        myProgressBar.indeterminateDrawable.setTint(ContextCompat.getColor(context, R.color.purple1_superapi))
        texto.text = titulo
        alertDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(false)
            .create()
        alertDialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        alertDialog.show()
    }

    fun progressDesactivate() {
        if (alertDialog.isShowing)
            alertDialog.dismiss()
    }

}