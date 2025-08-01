package com.example.claro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ServiciosFijos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serviciosfijos)

        val btnClaroTv = findViewById<Button>(R.id.clarotvBTN)
        val btnInternet = findViewById<Button>(R.id.wifiBTN)
        val btnAtencion = findViewById<Button>(R.id.atencionBTN)

        // Claro TV
        btnClaroTv.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Claro TV 📡")
                .setMessage("Disfruta más de 100 canales HD, incluye guía interactiva, canales premium y control parental.")
                .setPositiveButton("Cerrar", null)
                .show()
        }

        // Internet Fijo
        btnInternet.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Internet Fijo 🌐")
                .setMessage("Navega con velocidades de hasta 50 Mbps. Planes residenciales y empresariales disponibles.")
                .setPositiveButton("Cerrar", null)
                .show()
        }

        // Servicio al Cliente → ir a pantalla de contacto
        btnAtencion.setOnClickListener {
            val intent = Intent(this, Contacto::class.java)
            startActivity(intent)
        }
    }
}
