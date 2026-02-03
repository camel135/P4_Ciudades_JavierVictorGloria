package com.example.p4_ciudades_javiervictorgloria.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Lugar(
    @StringRes val name : Int,
    val ciudad: Ciudad,
    @DrawableRes val imageRes:Int,
    @StringRes val descripcion: Int,
    //Coordenadas para añadir el mapa etc
    //Posible favoritos
)
