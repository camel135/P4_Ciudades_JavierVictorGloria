package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.model.Ciudad

class ViewModelCiudad : ViewModel(){
    //se empieza por la primera ciudad
    var ciudadSeleccionar by mutableStateOf(FuenteDatos.ciudades[0])
        private set

    fun selectCiudad(nuevaCiudad: Ciudad){
        ciudadSeleccionar = nuevaCiudad
    }

}