package com.example.claro

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar sonido
        mediaPlayer = MediaPlayer.create(this, R.raw.click)

        // Referencias a los botones
        val btnServicios = findViewById<Button>(R.id.btnServicios)
        val btnPromociones = findViewById<Button>(R.id.btnPromocionesGrid)
        val btnContactanos = findViewById<Button>(R.id.btnContactanos)
        val btnLoNuevo = findViewById<Button>(R.id.btnLoNuevo)

        // Mostrar menú de servicios móviles
        btnServicios.setOnClickListener {
            playSound()
            mostrarMenuServicios()
        }

        // Abrir PromocionesActivity
        btnPromociones.setOnClickListener {
            playSound()
            val intent = Intent(this, PromocionesActivity::class.java)
            startActivity(intent)
        }


        btnContactanos.setOnClickListener {
            playSound()
            val intent = Intent(this, Contacto::class.java)
            startActivity(intent)
        }

        // Abrir Método de pago (lonuevo.kt)
        btnLoNuevo.setOnClickListener {
            playSound()
            val intent = Intent(this, lonuevo::class.java)
            startActivity(intent)
        }
    }

    private fun mostrarMenuServicios() {
        val opciones = arrayOf(
            "1. Consultar saldo",
            "2. Comprar paquetes",
            "3. Activar roaming",
            "4. Ver historial de consumo"
        )

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Selecciona un servicio")
        builder.setItems(opciones) { _, which ->
            playSound()
            when (which) {
                0 -> Toast.makeText(this, "Actualmente no cuenta con saldo disponible.", Toast.LENGTH_SHORT).show()
                1 -> startActivity(Intent(this, paquetes::class.java))
                2 -> Toast.makeText(this, "Roaming activado correctamente", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this, "No tienes historial de consumo", Toast.LENGTH_SHORT).show()
            }
        }
        builder.show()
    }

    private fun playSound() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.prepare()
        }
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
