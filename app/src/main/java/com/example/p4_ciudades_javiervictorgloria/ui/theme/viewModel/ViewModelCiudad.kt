package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.model.Ciudad
import com.example.p4_ciudades_javiervictorgloria.model.Lugar

class ViewModelCiudad : ViewModel() {
    // Guardamos el  indice de  la ciudad actual
    var ciudadIndex by mutableStateOf(0)
        private set

    //La ciudad seleccionada se calcula a partir del indice
    val ciudadSeleccionada: Ciudad
        get() = FuenteDatos.ciudades[ciudadIndex]

    // Categoria 0 son todas
    var categoriaSeleccionada by mutableIntStateOf(0)
        private set


    // funcion para actualizar la ciudad desde fuera (DESDE NAVIGATION!!!!)
    fun actualizarCiudad(nuevoCiudadIndex: Int){
        ciudadIndex = nuevoCiudadIndex
        categoriaSeleccionada = 0 // RESETEAR LA CATEGORIA AL CAMBIAR DE CIUDAD
    }

    fun actualizarCategoria(nuevaCategoria: Int) {
        categoriaSeleccionada = nuevaCategoria
    }

    fun lugarFiltrado(): List<Lugar> {
        return FuenteDatos.lugares.filter { lugar ->
            if (categoriaSeleccionada==0) {
                lugar.ciudad == ciudadSeleccionada
            }else{
                lugar.ciudad == ciudadSeleccionada && lugar.categoria == categoriaSeleccionada //lugares de la ciudad y categoria seleccionada
            }
        }

    }



}
