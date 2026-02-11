package com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos


class ViewModelHome : ViewModel() {
    var expanded by mutableStateOf(false)
        private set

    var ciudadIndex by mutableStateOf(0)
        private set



    @Composable
    fun toGithub() {
        val context = LocalContext.current
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://github.com/camel135/P4_Ciudades_JavierVictorGloria.git")
        )
        context.startActivity(intent)
    }


    fun onDropDownMenuClick() {
        expanded = !expanded

    }

    fun onDismissMenu() {
        expanded = false
    }


    fun onSunClick() {

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