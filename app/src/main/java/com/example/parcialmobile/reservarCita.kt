package com.example.parcialmobile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class reservarCita : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reservar_cita)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.btn_agendar)
        val fechaCita = findViewById<EditText>(R.id.text_fecha)
        val spinner = findViewById<Spinner>(R.id.spinner1)
        val especialidad = resources.getStringArray(R.array.spinner_items)

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, especialidad
            )
            spinner.adapter = adapter
        }

        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val medico = resources.getStringArray(R.array.spinner_medico)

        if (spinner2 != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, medico
            )
            spinner2.adapter = adapter
        }


        button.setOnClickListener {

            val intent = Intent(this, citaReservada::class.java)




            val agendarCita:String = fechaCita.text.toString()
            val enviarFecha = Intent(this, citaReservada::class.java)
            enviarFecha.putExtra("EXTRA_MENSAJE", agendarCita)
            startActivity(enviarFecha)



            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                    val selectedEspecialidad = especialidad[position]
                    val enviarEspecialidad = Intent(this@reservarCita, citaReservada::class.java)
                    enviarEspecialidad.putExtra("selectedItem", selectedEspecialidad)
                    startActivity(enviarEspecialidad)




                    Toast.makeText(this@reservarCita, "Especialidad seleccionada: $selectedEspecialidad", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {


                }
            }










            spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                    val selectedMedico = medico[position]
                    val enviarMedico = Intent(this@reservarCita, citaReservada::class.java)
                    enviarMedico.putExtra("selectedMedico", selectedMedico)
                    startActivity(enviarMedico)
                    Toast.makeText(this@reservarCita, "Medico seleccionado: $selectedMedico", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }








        }







    }
}