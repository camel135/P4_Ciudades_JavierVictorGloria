package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos


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

    var darkMode by mutableStateOf(false) //estado del tema
        private set

    fun onSunClick() { //funcion que llama cuando se pulsa el icono
        darkMode = !darkMode
    }

    // funcion para la flecha derecha
    fun siguienteCiudad() {
        if (ciudadIndex < FuenteDatos.ciudades.size - 1) {
            ciudadIndex++
        } else {
            ciudadIndex = 0
        }
    }

    // funcion pa la izquierda
    fun anteriorCiudad() {
        if (ciudadIndex > 0) {
            ciudadIndex--
        } else {
            ciudadIndex = FuenteDatos.ciudades.size - 1
        }
    }


}