package com.example.mvvmexamplekotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmexamplekotlin.R
import com.example.mvvmexamplekotlin.domain.FrutasUseCase
import com.example.mvvmexamplekotlin.ui.model.Frutas
import com.example.mvvmexamplekotlin.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()



        bt_cargar.setOnClickListener {
            viewModel.getListaFrutas()
        }

        bt_borrar.setOnClickListener {
            tv1_main.text = ""
        }

    }

    // Configuramos el viewmodel
    fun setupViewModel(){
        // Enlazamos objeto viewv Model con la clase MyViewModel:
        // En el video dice que este es un observer.
        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        // Suscribirnos o observar al livedata:
        val frutasObserver = Observer<List<Frutas>> {
            // El código en esta área se ejecutará cada vez que
            // el livedata detecte un cambio en el objeto observado.
            var mitexto = ""
            for (i in it) mitexto += i.toString() + "\n\n"
            tv1_main.text = mitexto
        }
        viewModel.getListaFrutasLiveData().observe(this, frutasObserver)
    }
}
