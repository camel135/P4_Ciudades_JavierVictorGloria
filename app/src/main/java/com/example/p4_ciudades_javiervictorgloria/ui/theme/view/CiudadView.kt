package com.example.p4_ciudades_javiervictorgloria.data

import android.content.res.Resources
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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

    Scaffold (containerColor = Color(0xFFF8F0FA)){ paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(20.dp)
            ) {
                Text(
                    text = stringResource(id = ciudadActual.name),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFF7B1FA2)
                )

                Text(
                    text = "Descubre lugares preciosos",
                    style= MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            //carrusel
            Text(
                text = "PUNTOS DE INTERÉS",
                style= MaterialTheme.typography.titleMedium,
                fontFamily = FontFamily.SansSerif,
                color = Color.Blue,
                modifier= Modifier.padding(start = 15.dp, top = 15.dp, bottom = 7.dp)

            )

            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                contentPadding = PaddingValues(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                //aqui se usa la lista de pair
                items(FuenteDatos.categoriasOpciones){
                    (idTexto,idIcono) ->
                    ItemCarrusel(
                        idIcono = idIcono,
                       // label= stringResource(id =idTexto),
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
    //label: String,
    isSelected: Boolean,
    onClick: () -> Unit
)
{
    Surface(
        modifier = Modifier.size(60.dp).clickable{onClick()},
        shape = CircleShape,
        //si se selcciona brilla morado
        color = if (isSelected) Color(0xFF9C27B0) else Color.White,
        shadowElevation = 4.dp
    ) {
        Icon(
            painter = painterResource(id = idIcono),
            contentDescription = null,
            modifier = Modifier.padding(8.dp),
            tint = if (isSelected) Color.White else Color(0xFF9C27B0)
        )
    }
    /*Text(
        text = label,
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier.padding(top = 4.dp),
        //maxLines = 1
    )*/
    }


@Composable
fun CardLugar(
    lugar: Lugar
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = lugar.imageRes),
                contentDescription = null,
                modifier = Modifier.size(70.dp).clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column() {
                Text(
                    text = stringResource(id = lugar.name),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Pulsa para descubrir más",
                    color = Color(0xFFE91E63),
                    style = MaterialTheme.typography.labelMedium
                )
            }

            /*Text(
                text = stringResource(id = lugar.name),
                style= MaterialTheme.typography.titleLarge
            )*/
        }
    }
}

