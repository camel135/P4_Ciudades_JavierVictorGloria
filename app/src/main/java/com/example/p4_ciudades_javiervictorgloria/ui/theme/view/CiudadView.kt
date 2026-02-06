package com.example.p4_ciudades_javiervictorgloria.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.p4_ciudades_javiervictorgloria.R
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelCiudad


@Composable
fun CiudadView(
    viewModel: ViewModelCiudad
){
    val ciudadActual = viewModel.ciudadSeleccionar
    val categoriaActual = viewModel.seleccionarCategoria
    //se filtra esos lugares de la ciudad por la que coincidan
    val filtrarLugar = FuenteDatos.lugares.filter { it.ciudad == ciudadActual && it.categoria == categoriaActual }

    Scaffold{ paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            //carrusel
            Text(
                text = "Categorias",
                style= MaterialTheme.typography.titleLarge,
                modifier= Modifier.padding(start = 15.dp, top = 15.dp, bottom = 6.dp)

            )

            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                contentPadding = PaddingValues(horizontal = 14.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                //aqui se va a definir los iconos de las 4


            }
        }
    }

}
