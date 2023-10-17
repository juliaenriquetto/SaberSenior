package com.example.sabersenior

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class Config : AppCompatActivity() {

    private var currentTheme = R.style.AppTheme_LightTheme // Tema padrão é o tema claro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        // Alert Dialog Btn_SobreNos
        val btnSobreNos = findViewById<Button>(R.id.btnSobre)

        btnSobreNos.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.custom_allert_sobre_nos, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val SairSobre = dialogBinding.findViewById<Button>(R.id.dialog_Sair)

            SairSobre.setOnClickListener()
            {
                myDialog.dismiss()
            }
            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()
        }
    }
}
