package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos

class ViewModelHome : ViewModel() {

    var expanded by mutableStateOf(false)
        private set

    var ciudadIndex by mutableStateOf(0)


    fun onDropDownMenuClick() {
        expanded = !expanded

    }
    fun onDismissMenu() {
        expanded = false
    }

    fun onSunClick() {

    }

    fun onCiudadIndexChange(ciudadIndex: Int){


    }





}