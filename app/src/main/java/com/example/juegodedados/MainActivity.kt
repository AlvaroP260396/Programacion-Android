package com.example.juegodedados
import kotlin.random.Random

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var numDados: EditText
    private lateinit var numCaras: EditText
    private lateinit var btnLanzarDados: Button
    private lateinit var tvResultados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numDados = findViewById(R.id.numDados)
        numCaras = findViewById(R.id.numCaras)
        btnLanzarDados = findViewById(R.id.btnLanzarDados)
        tvResultados = findViewById(R.id.tvResultados)


        btnLanzarDados.setOnClickListener {
            lanzarDados()
        }
    }

    private fun lanzarDados() {
        val numDadosText = numDados.text.toString()
        val numCarasText = numCaras.text.toString()

        // Verificar si los campos están vacíos
        if (numDadosText.isEmpty() || numCarasText.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un valor en ambos campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Verificar si los valores son válidos
        val nDados = numDadosText.toIntOrNull() ?: return
        val nCaras = numCarasText.toIntOrNull() ?: return

        if (nDados < 1 || nCaras < 1) {
            Toast.makeText(this, "Por favor, ingrese valores mayores que cero en ambos campos.", Toast.LENGTH_SHORT).show()
            return
        }

        val resultados = IntArray(nDados) { Random.nextInt(1, nCaras + 1) }

        tvResultados.text = "Resultados: ${resultados.joinToString(", ")}"
    }





}





