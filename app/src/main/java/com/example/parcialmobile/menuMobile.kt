package com.example.parcialmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menuMobile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_mobile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.btn_reservar)

        // Configurar el Listener para el botón
        btn.setOnClickListener {

            val intent = Intent(this, reservarCita::class.java)
            // Iniciar la actividad SecondActivity
            startActivity(intent)

            }

        val button = findViewById<Button>(R.id.btn_back)

        // Configurar el Listener para el botón
        button.setOnClickListener {

            val intent1 = Intent(this, MainActivity::class.java)
            // Iniciar la actividad SecondActivity
            startActivity(intent1)




            }


        }
    }
