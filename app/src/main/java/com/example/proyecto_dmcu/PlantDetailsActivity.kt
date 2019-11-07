package com.example.proyecto_dmcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.ImageView
import android.view.Window
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

        //get Data from Search

        var intent = intent
        nameP = intent.getStringExtra("Name")
        nameC = intent.getStringExtra("scientific")
        //imageview = findViewById(R.id.imgPlant)
        //val draw = this.resources.getIdentifier(nameP,"drawable",this.packageName)
        //imageview!!.setImageResource(draw)
        txtview = findViewById(R.id.namePlant)
        txtviewdesc = findViewById(R.id.descPlant)
        txtview!!.setText(nameP)
        txtviewdesc!!.setText(nameC)

        btnC = findViewById(R.id.cuidados)
        btnI = findViewById(R.id.info)

        btnC!!.setOnClickListener(){
            val intent = Intent(this, CuidadosActivity::class.java)
            startActivity(intent)
        }
        btnI!!.setOnClickListener(){
            val intent = Intent(this, InformacionActivity::class.java)
            startActivity(intent)
        }

    }

    }