package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val campoPeso: EditText = findViewById(R.id.editTextPeso)
        val campoAltura: EditText = findViewById(R.id.editTextAltura)
        val botaoCalcular: Button = findViewById(R.id.buttonCalcular)
        val textoResultado: TextView = findViewById(R.id.textViewResultado)

        botaoCalcular.setOnClickListener {
            val pesoTexto = campoPeso.text.toString()
            val alturaTexto = campoAltura.text.toString()

            if (pesoTexto.isNotEmpty() && alturaTexto.isNotEmpty()) {
                val peso = pesoTexto.toDouble()

                val altura = alturaTexto.toDouble()

                val imc = peso / (altura * altura)

                textoResultado.text = "IMC: %.2f".format(imc)
            } else {
                Toast.makeText(
                    this,
                    "Por favor, insira um peso e altura",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}