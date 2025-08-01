package com.example.claro

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class lonuevo : AppCompatActivity() {

    private lateinit var cardDebit: CardView
    private lateinit var cardCredit: CardView
    private lateinit var btnContinue: Button
    private lateinit var formTarjeta: LinearLayout
    private lateinit var editNombre: EditText
    private lateinit var editNumero: EditText
    private lateinit var editVencimiento: EditText
    private lateinit var editCVV: EditText
    private lateinit var btnPagar: Button

    private var selectedPaymentMethod: PaymentMethod? = null

    enum class PaymentMethod {
        DEBIT, CREDIT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lonuevo)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cardDebit = findViewById(R.id.cardDebit)
        cardCredit = findViewById(R.id.cardCredit)
        btnContinue = findViewById(R.id.btnContinue)

        // Nuevos campos para datos de tarjeta
        formTarjeta = findViewById(R.id.formTarjeta)
        editNombre = findViewById(R.id.editNombre)
        editNumero = findViewById(R.id.editNumero)
        editVencimiento = findViewById(R.id.editVencimiento)
        editCVV = findViewById(R.id.editCVV)
        btnPagar = findViewById(R.id.btnPagar)

        updateSelection(null)

        cardDebit.setOnClickListener {
            updateSelection(PaymentMethod.DEBIT)
        }

        cardCredit.setOnClickListener {
            updateSelection(PaymentMethod.CREDIT)
        }

        btnContinue.setOnClickListener {
            if (selectedPaymentMethod == null) {
                Toast.makeText(this, "Por favor selecciona un método de pago", Toast.LENGTH_SHORT).show()
            } else {
                formTarjeta.visibility = View.VISIBLE
            }
        }

        btnPagar.setOnClickListener {
            val nombre = editNombre.text.toString()
            val numero = editNumero.text.toString()
            val vencimiento = editVencimiento.text.toString()
            val cvv = editCVV.text.toString()

            if (nombre.isEmpty() || numero.isEmpty() || vencimiento.isEmpty() || cvv.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pago procesado correctamente", Toast.LENGTH_LONG).show()
                // Aquí puedes continuar la lógica para enviar los datos
            }
        }
    }

    private fun updateSelection(selection: PaymentMethod?) {
        selectedPaymentMethod = selection

        if (selection == PaymentMethod.DEBIT) {
            cardDebit.setCardBackgroundColor(Color.parseColor("#DBEAFE")) // azul claro
            setCardTextColor(cardDebit, Color.parseColor("#2563EB"))      // azul oscuro texto
            cardCredit.setCardBackgroundColor(Color.WHITE)
            setCardTextColor(cardCredit, Color.parseColor("#222222"))
        } else if (selection == PaymentMethod.CREDIT) {
            cardCredit.setCardBackgroundColor(Color.parseColor("#D1FAE5")) // verde claro
            setCardTextColor(cardCredit, Color.parseColor("#059669"))      // verde oscuro texto
            cardDebit.setCardBackgroundColor(Color.WHITE)
            setCardTextColor(cardDebit, Color.parseColor("#222222"))
        } else {
            cardDebit.setCardBackgroundColor(Color.WHITE)
            cardCredit.setCardBackgroundColor(Color.WHITE)
            setCardTextColor(cardDebit, Color.parseColor("#222222"))
            setCardTextColor(cardCredit, Color.parseColor("#222222"))
        }

        // Ocultar formulario si cambian de opción
        formTarjeta.visibility = View.GONE
    }

    private fun setCardTextColor(card: CardView, color: Int) {
        val linearLayout = card.getChildAt(0)
        if (linearLayout is LinearLayout) {
            val tv = linearLayout.getChildAt(1)
            if (tv is TextView) {
                tv.setTextColor(color)
            }
        }
    }
}







