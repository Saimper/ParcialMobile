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
import androidx.core.view.get


class reservarCita : AppCompatActivity() {


    private lateinit var spinner:Spinner;
    private lateinit var fechaCita: EditText;
    private lateinit var spinner2: Spinner;


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
         fechaCita = findViewById<EditText>(R.id.text_fecha)
        spinner = findViewById<Spinner>(R.id.spinner1)
        val especialidad = resources.getStringArray(R.array.spinner_items)



        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                val selectedEspecialidad = especialidad[position]
                val enviarEspecialidad = Intent(this@reservarCita, citaReservada::class.java)




                Toast.makeText(this@reservarCita, "Especialidad seleccionada: $selectedEspecialidad", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {


            }
        }



        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, especialidad
            )
            spinner.adapter = adapter
        }


         spinner2 = findViewById<Spinner>(R.id.spinner2)
        val medico = resources.getStringArray(R.array.spinner_medico)



        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                val selectedMedico = medico[position]
                val enviarMedico = Intent(this@reservarCita, citaReservada::class.java)

                Toast.makeText(this@reservarCita, "Medico seleccionado: $selectedMedico", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }





        if (spinner2 != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, medico
            )
            spinner2.adapter = adapter
        }


        button.setOnClickListener {

            llenar();

        }







    }


    fun llenar(){

        val intent = Intent(this, citaReservada::class.java)


        var spSelected = spinner.selectedItem.toString();
        var spSelected2 = spinner2.selectedItem.toString();

        val agendarCita:String = fechaCita.text.toString()
        val datos = Intent(this, citaReservada::class.java)
        datos.putExtra("EXTRA_MENSAJE", agendarCita)
        datos.putExtra("selectedItem", spSelected)
        datos.putExtra("selectedItem2", spSelected2)

        startActivity(datos)

    }
}

