package com.example.proyecto_dmcu

class Plants {
    private val plantName: String
    private val scientificName: String
    constructor(plantName: String, scientificName: String){
        this.plantName = plantName
        this.scientificName = scientificName
    }
    fun getPlantName() : String{
        return this.plantName
    }
    fun getScientificName(): String{
        return this.scientificName
    }
    /*
    private val family: String
    private val species: String
    private val cientificName: String

    constructor(plantName: String, family: String, species: String, cientificName: String){
        this.plantName = plantName
        this.family = family
        this.species = species
        this. cientificName = cientificName
    }

    fun getPlantName(): String{
        return this.plantName
    }

    fun getFamily(): String{
        return this.plantName
    }

    fun getSpecies(): String{
        return this.species
    }

    fun getCientificName(): String{
        return this.cientificName
    }
     */
}