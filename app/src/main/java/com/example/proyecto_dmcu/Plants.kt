package com.example.proyecto_dmcu

import androidx.annotation.IntegerRes

class Plants {
    private val plantName: String
    private val scientificName: String
    private val iluminacion: Int
    private val riego: Int

    constructor(plantName: String, scientificName: String, iluminacion: Int, riego: Int) {
        this.plantName = plantName
        this.scientificName = scientificName
        this.iluminacion = iluminacion
        this.riego = riego
    }

    fun getPlantName(): String {
        return this.plantName
    }

    fun getScientificName(): String {
        return this.scientificName
    }

    fun getIluminacion(): Int {
        return this.iluminacion
    }

    fun getRiego(): Int {
        return this.riego
    }

}