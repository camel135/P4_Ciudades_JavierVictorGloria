package com.example.p4_ciudades_javiervictorgloria.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Ciudad(
    @StringRes val name: Int,
    @StringRes val pais: Int,
    @StringRes val continente: Int,
    @DrawableRes val imagen: Int,
    //coordenadas

)
