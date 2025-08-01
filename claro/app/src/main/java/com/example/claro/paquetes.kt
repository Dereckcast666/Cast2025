package com.example.claro

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class paquetes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paquetes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Listeners para los botones
        val btn1 = findViewById<Button>(R.id.btnComprar1)
        val btn2 = findViewById<Button>(R.id.btnComprar2)
        val btn3 = findViewById<Button>(R.id.btnComprar3)

        val intent = Intent(this, lonuevo::class.java)

        btn1.setOnClickListener { startActivity(intent) }
        btn2.setOnClickListener { startActivity(intent) }
        btn3.setOnClickListener { startActivity(intent) }
    }
}

