package com.example.mvvmexamplekotlin.data

import com.example.mvvmexamplekotlin.ui.model.Frutas

// tambein se puede llamar FrutasDataSet,
// FrutasRepoLocal, etc.

class FrutasRepository {

    fun crearListaDeFrutas(): List<Frutas> {
        return listOf(
            Frutas("manzana", "rojo", 4.5F,1.5F),
            Frutas("banana","amarillo",5.6F,2F),
            Frutas("uvas","verdes",5.4F,22F)
            )
    }

}