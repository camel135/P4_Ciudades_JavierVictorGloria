package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.model.Lugar

class ViewModelHome : ViewModel() {
    var expanded by mutableStateOf(false)
        private set

    var ciudadIndex by mutableStateOf(0)
        private set

    fun onDropDownMenuClick() {
        expanded = !expanded

    }
    fun onDismissMenu() {
        expanded = false
    }

    fun lugarRandom(): Lugar{
        return FuenteDatos.lugares.random()
    }

    fun onSunClick() {

    }

    // funcion para la flecha derecha
    fun siguienteCiudad(){
        if (ciudadIndex < FuenteDatos.ciudades.size - 1) {
            ciudadIndex++
        } else {
            ciudadIndex = 0
        }
    }

    // funcion pa la izquierda
    fun anteriorCiudad(){
        if (ciudadIndex > 0){
            ciudadIndex--
        } else {
            ciudadIndex = FuenteDatos.ciudades.size -1
        }
    }





}