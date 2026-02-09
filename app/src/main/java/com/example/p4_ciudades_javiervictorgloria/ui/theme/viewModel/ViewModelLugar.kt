
package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.model.Lugar

class ViewModelLugar : ViewModel() {
     var lugarSeleccionado by  mutableStateOf<Lugar?>(null) //null para que no haya ningun lugar seleccionado
         private set




    fun seleccionarLugar(nuevoLugar: Lugar){ //la funcion se llama desde la segunda pantalla al hacer click en una
        lugarSeleccionado= nuevoLugar
    }

    // se comprueba si estan los datos validos
    fun datosValidosLugar(): Boolean{
        return lugarSeleccionado !=null
    }



}
