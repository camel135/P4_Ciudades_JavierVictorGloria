package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.model.Lugar

class ViewModelCiudad : ViewModel() {
    //se empieza por la primera ciudad
    var ciudadSeleccionada by mutableStateOf(FuenteDatos.ciudades[0])
        private set

    //vamos a empezar por defecto con restaurantes
    var categoriaSeleccionada by mutableIntStateOf(0)
        private set


    fun actualizarCategoria(nuevaCategoria: Int) {
        categoriaSeleccionada = nuevaCategoria
    }

    fun lugarFiltrado(): List<Lugar> {


        return FuenteDatos.lugares.filter { lugar ->
            if (categoriaSeleccionada==0) {
                lugar.ciudad == ciudadSeleccionada
            }else{
                lugar.ciudad == ciudadSeleccionada && lugar.categoria == categoriaSeleccionada//lugares de la ciudad y categoria seleccionada
            }
        }


    }

    


}
