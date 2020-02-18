package com.example.mvvmexamplekotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexamplekotlin.domain.FrutasUseCase
import com.example.mvvmexamplekotlin.ui.model.Frutas

class MyViewModel : ViewModel() {

    val frutasUseCase = FrutasUseCase()

    // el mutablelivedata esta escuchadno por una lista de frutas.
    private val listData = MutableLiveData<List<Frutas>>()

    /*   init {
        // En este caso estamos llamando a la siguient función desde el constructor,
        // sin embargo, podemos modificarlo para llamarla desde el otro lado, como el mainactivity por ejemplo.
        getListaFrutas()
    }*/


    fun setListData(listaFrutas: List<Frutas>) {
        listData.value = listaFrutas
    }

    // función que obtiene los datos desde el repositorio
    // En este caso es sincrono, pero se puede usar corutinas para consultas asincronas
    fun getListaFrutas() {
        setListData(frutasUseCase.obtenerListaDeFrutas())
    }

    fun getListaFrutasLiveData(): LiveData<List<Frutas>> {
        return listData
    }

}