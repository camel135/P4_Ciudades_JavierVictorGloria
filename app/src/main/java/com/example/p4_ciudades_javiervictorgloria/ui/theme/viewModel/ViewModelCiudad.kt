package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.R
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos

    class ViewModelCiudad : ViewModel() {
        //se empieza por la primera ciudad
        var ciudadSeleccionar by mutableStateOf(FuenteDatos.ciudades[0])
            private set

        //vamos a empezar por defecto con restaurantes
        var seleccionarCategoria by mutableStateOf(0)
            private set

        fun actualizarCateg(nuevaCategoria: Int) {
            seleccionarCategoria = nuevaCategoria
        }
    }
