package com.example.mvvmexamplekotlin.domain

import com.example.mvvmexamplekotlin.data.FrutasRepository
import com.example.mvvmexamplekotlin.ui.model.Frutas

class FrutasUseCase{

    private val frutasDataSet = FrutasRepository()

    fun obtenerListaDeFrutas():List<Frutas>{
        return frutasDataSet.crearListaDeFrutas()
    }

}