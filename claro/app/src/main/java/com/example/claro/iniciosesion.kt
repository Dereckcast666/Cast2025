package com.example.claro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class iniciodesesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iniciosesion)

        // Declaraciones
        val usuario = findViewById<EditText>(R.id.btnusu)
        val clave = findViewById<EditText>(R.id.btncon)
        val boton = findViewById<Button>(R.id.btnEntrar)

        boton.setOnClickListener {
            val user = usuario.text.toString()
            val cont = clave.text.toString()


            if (user.isNotEmpty() && cont.isNotEmpty()) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Completa ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}