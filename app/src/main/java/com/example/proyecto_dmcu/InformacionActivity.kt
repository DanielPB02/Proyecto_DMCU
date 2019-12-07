package com.example.proyecto_dmcu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class InformacionActivity : AppCompatActivity() {

    var imagenIluminacion: ImageView? = null
    var imagenRiego: ImageView? = null
    var txtComun: TextView? = null
    var txtCientifico: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)
        //add back button
        setTitle("Información")
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        //sustancia >:D
        var intent = intent
        val nameP = intent.getStringExtra("nombrecomun")
        val nameC = intent.getStringExtra("nombrecientifico")
        val iluminacion = intent.getIntExtra("iluminacion", 1)
        val riego = intent.getIntExtra("riego", 2)


        txtComun = findViewById(R.id.nombrecomunInfo)
        txtCientifico = findViewById(R.id.nombrecientificoInfo)
        txtComun!!.setText(nameP)
        txtCientifico!!.setText(nameC)

        imagenIluminacion = findViewById(R.id.imagenIluminacion)
        imagenRiego = findViewById(R.id.imagenRiego)

        val nombreImagenIlum = selectImgIlum(iluminacion)
        val nombreImagenRiego = selectImgRiego(riego)

        val drawIlum = this.resources.getIdentifier(nombreImagenIlum, "drawable", this.packageName)
        val drawRiego =
            this.resources.getIdentifier(nombreImagenRiego, "drawable", this.packageName)

        imagenIluminacion!!.setImageResource(drawIlum)
        imagenRiego!!.setImageResource(drawRiego)

        imagenIluminacion!!.setOnClickListener() {
            Toast.makeText(
                this,
                displayIlum(iluminacion),
                Toast.LENGTH_SHORT
            ).show()
        }
        imagenRiego!!.setOnClickListener() {
            Toast.makeText(
                this,
                displayRiego(riego),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun displayIlum(nivel: Int): String {
        if (nivel == 1) {
            return "Media Sombra"
        }
        if (nivel == 2) {
            return "Pleno sol"
        } else {
            return "Media Sombra"
        }
    }

    fun displayRiego(nivel: Int): String {
        if (nivel == 1) {
            return "Escaso"
        }
        if (nivel == 2) {
            return "Moderado"
        }
        if (nivel == 3) {
            return "Abundante"
        } else {
            return "Moderado"
        }
    }

    fun selectImgIlum(nivel: Int): String {
        if (nivel == 1) {
            return "sol1"
        }
        if (nivel == 2) {
            return "sol2"
        } else {
            return "sol1"
        }
    }

    fun selectImgRiego(nivel: Int): String {
        if (nivel == 1) {
            return "riego1"
        }
        if (nivel == 2) {
            return "riego2"
        }
        if (nivel == 3) {
            return "riego3"
        } else {
            return "riego1"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == android.R.id.home) {
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
