package com.example.parcialmobile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class citaReservada : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cita_reservada)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fechaResivida = findViewById<TextView>(R.id.fechaResivida)
        val resivirFecha:String = intent.extras?.getString("EXTRA_MENSAJE").orEmpty()
        fechaResivida.text = resivirFecha

        val textView: TextView = findViewById(R.id.especialidadResivida)
        val selectedItem = intent.getStringExtra("selectedItem")
        textView.text = selectedItem

        val textMedico: TextView = findViewById(R.id.textMedico)
        val selectedMedico = intent.getStringExtra("selectedMedico")
        textMedico.text = selectedMedico







        val button = findViewById<Button>(R.id.btn_aceptar)


        button.setOnClickListener {

            val intent = Intent(this, menuMobile::class.java)

            startActivity(intent)

        }

        val button1 = findViewById<Button>(R.id.btn_cancelar)


        button1.setOnClickListener {

            val intent = Intent(this, citaCancelada::class.java)

            startActivity(intent)

        }


    }
}