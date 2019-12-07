package com.example.proyecto_dmcu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.welcome.*

class CuidadosActivity : AppCompatActivity() {

    var listview: ListView? = null
    var txtview : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuidados)
        //add back button
        setTitle("Cuidados")
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        //get data from previous activity
        val intent = intent
        var nombre = intent.getStringExtra("nombre")
        txtview = findViewById(R.id.dsctitle)
        txtview!!.setText(nombre)
        val cuidados = selectCuidados(nombre)
        //display cuidados
        listview = findViewById(R.id.listaCuidados)
        selectCuidados(nombre)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,cuidados)
        listview!!.adapter = adapter
    }

    fun selectCuidados(nombre: String) : Array<String>{
        if (nombre.equals("Siete Colores")) {
           return arrayOf("Debe situarse a pleno sol pero también vive bien a semisombra.",
            "Es muy sensible al frío.",
            "El clima más apropiado para su cultivo es el de tipo tropical y mediterráneo.",
            "Resiste a la sequía. Planta muy apropiada para jardines secos.",
            "Se adapta a cualquier tipo de suelo pero vive mejor en un terreno bien abonado.")
        }
        if (nombre.equals("Orégano")) {
            return arrayOf("Es preferible situarla en lugares muy soleados",
            "Resiste las heladas.",
            "Las plantas se ponen en hileras a 30 cm unas de otras.",
            "Se siembra a fines de invierno y durante toda la primavera, para recolectar a fines de primavera y todo el verano.",
            "Se debe tener cuidado al escardar para no dañar las raíces.")
        }
        if (nombre.equals("Albahaca")) {
            return arrayOf("Se puede situar a pleno sol o a media sombra.",
            "Es una planta muy sensible a las heladas, no las resiste.",
            "Abonar el suelo antes de la siembra.",
            "Se tiene que sembrar las semillas a poca profundidad, al calor suave de los últimos días de primavera y trasplantarlas hacia mediados del verano, con cuidado de no dañar las raíces.",
            "Las plantas se colocan en hileras a 30 cm de distancia unas de otras. Es conveniente plantarlos algo profundos.")
        }
        else{
            return arrayOf("404")
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
