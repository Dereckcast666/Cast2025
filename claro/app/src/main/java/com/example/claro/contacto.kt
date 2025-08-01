package com.example.claro

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Contacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        val btnContacto = findViewById<Button>(R.id.btnContacto)

        btnContacto.setOnClickListener {
            Toast.makeText(this, "Pronto nos comunicaremos con usted...", Toast.LENGTH_LONG).show()
        }
    }
}
