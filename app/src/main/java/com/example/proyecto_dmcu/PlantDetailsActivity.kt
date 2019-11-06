package com.example.proyecto_dmcu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import android.widget.ImageView

class PlantDetailsActivity : AppCompatActivity() {

    var imageview: ImageView? = null
    var txtview: TextView? = null
    lateinit var detailView: View
    var nameP: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_details)

        //get Data from Search

        var intent = intent
        nameP = intent.getStringExtra("Name")
        imageview = findViewById(R.id.imgPlant)
        val draw = this.resources.getIdentifier(nameP,"drawable",this.packageName)
        imageview!!.setImageResource(draw)
        txtview = findViewById(R.id.namePlant)
        txtview!!.setText(nameP)
    }

    }

