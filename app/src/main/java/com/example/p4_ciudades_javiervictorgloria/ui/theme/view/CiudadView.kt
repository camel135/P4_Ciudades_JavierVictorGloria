package com.example.p4_ciudades_javiervictorgloria.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudades_javiervictorgloria.R
import com.example.p4_ciudades_javiervictorgloria.model.Lugar
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelCiudad


@Preview
@Composable
fun PreviewCiudadView(){
    CiudadView(viewModel = viewModel())
}


@Composable
fun CiudadView(
    viewModel: ViewModelCiudad
){
    val ciudadActual = viewModel.ciudadSeleccionar
    val categoriaActual = viewModel.seleccionarCategoria
    //filtramos por ciudad sino por ciudad y categoria
    val filtrarLugar = FuenteDatos.lugares.filter {
        lugar ->
        if (categoriaActual == 0){
            lugar.ciudad == ciudadActual
        }else{
            lugar.ciudad == ciudadActual && lugar.categoria == categoriaActual
        }
    }

    Scaffold{ paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            //carrusel
            Text(
                text = "PUNTOS DE INTERÉS",
                style= MaterialTheme.typography.titleLarge,
                modifier= Modifier.padding(start = 15.dp, top = 15.dp, bottom = 7.dp)

            )

            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                contentPadding = PaddingValues(horizontal = 17.dp),
                horizontalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                //aqui se usa la lista de pair
                items(FuenteDatos.categoriasOpciones){
                    (idTexto,idIcono) ->
                    ItemCarrusel(
                        idIcono = idIcono,
                        label= stringResource(id =idTexto),
                        isSelected= categoriaActual == idTexto,
                        onClick= {viewModel.actualizarCateg(idTexto)}
                    )
                }

            }

            //lista lugares

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(15.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(filtrarLugar){
                    lugar ->
                    CardLugar(lugar)
                }
            }
        }
    }

}

@Composable
fun ItemCarrusel(
    idIcono: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(75.dp)
            .clickable { onClick() }
    ) {
        Surface(
            modifier = Modifier.size(55.dp),
            shape = CircleShape,
            color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
        ) {
            Icon(
                painter = painterResource(id = idIcono),
                contentDescription = label,
                modifier = Modifier.padding(15.dp),
                tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp),
            //maxLines = 1
        )
    }
}

@Composable
fun CardLugar(
    lugar: Lugar
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = lugar.imageRes),
                contentDescription = null,
                modifier = Modifier.size(60.dp).clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = stringResource(id = lugar.name),
                style= MaterialTheme.typography.titleLarge
            )
        }
    }
}

