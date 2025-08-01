package com.example.claro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PromocionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promociones)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)

        // Al tocar "Comprar", se abre la pantalla de método de pago (lonuevo.kt)
        btn1.setOnClickListener {
            val intent = Intent(this, lonuevo::class.java)
            // Puedes pasar datos si quieres, como el nombre de la promoción
            intent.putExtra("promo", "15 días de recarga por Q7")
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, lonuevo::class.java)
            intent.putExtra("promo", "120 MB por Q4.50")
            startActivity(intent)
        }
    }
}