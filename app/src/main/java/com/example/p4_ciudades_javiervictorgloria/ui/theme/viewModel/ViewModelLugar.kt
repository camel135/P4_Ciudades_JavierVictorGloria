/**
package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.model.Lugar

class ViewModelLugar : ViewModel() {
     var lugarSeleccionar by  mutableStateOf(FuenteDatos.lugares[0])
         private set
    fun seleccionarLugar(nuevoLugar: Lugar){
        lugarSeleccionar= nuevoLugar
    }
}
 **/