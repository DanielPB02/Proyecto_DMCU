package com.example.proyecto_dmcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView

class VerTutorialesActivity : AppCompatActivity() {

    var nameP: String? = null
    var titleText: TextView? = null

    var btn1: ImageButton? = null
    var btn2: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_tutoriales)
        //add back button
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        var intent = intent
        nameP = intent.getStringExtra("Name")
        setTitle(nameP)
        titleText = findViewById(R.id.titulotutorial)
        titleText!!.setText("Todas las técnicas:")

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        btn1!!.setOnClickListener(){
            val intent = Intent(this, TutorialVistaActivity::class.java)
            intent.putExtra("tuto","Tutorial 1")
            startActivity(intent)
        }
        btn2!!.setOnClickListener(){
            val intent = Intent(this, TutorialVistaActivity::class.java)
            intent.putExtra("tuto","Tutorial 2")
            startActivity(intent)
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
