package com.example.proyecto_dmcu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class TutorialVistaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_vista)
        //add back button
        var intent = intent
        val tuto = intent.getStringExtra("tuto")
        setTitle(tuto)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == android.R.id.home) {
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
