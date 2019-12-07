package com.example.proyecto_dmcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.ActionBar


class PlantDetailsActivity : AppCompatActivity() {

    var imageview: ImageView? = null
    var txtview: TextView? = null
    var txtviewdesc: TextView? = null
    var nameP: String? = null
    var nameC: String? = null
    var btnI: ImageButton? = null
    var btnC: ImageButton? = null
    var actionBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_details)
        setTitle("Detalles")
        //add back button
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        //get Data from Search
        var intent = intent
        nameP = intent.getStringExtra("Name")
        nameC = intent.getStringExtra("scientific")
        val iluminacion = intent.getIntExtra("iluminacion",1)
        val riego = intent.getIntExtra("riego",2)
        imageview = findViewById(R.id.imgPlant)
        val nombreImg = getImageId(nameP)
        val draw = this.resources.getIdentifier(nombreImg,"drawable",this.packageName)
        imageview!!.setImageResource(draw)
        txtview = findViewById(R.id.namePlant)
        txtviewdesc = findViewById(R.id.descPlant)
        txtview!!.setText(nameP)
        txtviewdesc!!.setText(nameC)

        btnC = findViewById(R.id.cuidados)
        btnI = findViewById(R.id.info)

        btnC!!.setOnClickListener() {
            val intent = Intent(this, CuidadosActivity::class.java)
            intent.putExtra("nombre",nameP)
            startActivity(intent)
        }
        btnI!!.setOnClickListener() {
            val intent = Intent(this, InformacionActivity::class.java)
            intent.putExtra("nombrecomun", nameP)
            intent.putExtra("nombrecientifico",nameC)
            intent.putExtra("iluminacion", iluminacion)
            intent.putExtra("riego", riego)
            startActivity(intent)
        }
    }

    fun getImageId(namePlant: String?): String {
        val name = namePlant!!.toLowerCase()
        val nombre = name.replace("é","e")
        return nombre.replace(" " , "")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == android.R.id.home) {
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

}