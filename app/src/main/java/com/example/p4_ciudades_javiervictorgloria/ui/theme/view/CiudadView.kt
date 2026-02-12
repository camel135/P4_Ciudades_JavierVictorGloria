package com.example.p4_ciudades_javiervictorgloria.ui.theme.view

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
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.model.Lugar
import com.example.p4_ciudades_javiervictorgloria.ui.theme.utils.EstadoPantalla
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelCiudad
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelLugar


@Preview
@Composable
fun PreviewCiudadView() {
    CiudadView(
        viewModel(),
        viewModelLugar = viewModel(),
        onLugarClick = {},
        estadoPantalla = EstadoPantalla.HORIZONTAL,
    )
}


@Composable
fun CiudadView(
    viewModelCiudad: ViewModelCiudad,
    viewModelLugar: ViewModelLugar,
    onLugarClick: () -> Unit,
    estadoPantalla: EstadoPantalla = EstadoPantalla.VERTICAL
) {

    Scaffold(containerColor = MaterialTheme.colorScheme.background) { paddingValues ->
        if (estadoPantalla == EstadoPantalla.VERTICAL) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        text = stringResource(id = viewModelCiudad.ciudadSeleccionada.name),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = stringResource(R.string.descubre_lugares_preciosos),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
                //carrusel
                Text(
                    text = stringResource(R.string.puntos_interes),
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Blue,
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 7.dp)

                )

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    contentPadding = PaddingValues(horizontal = 22.dp),
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    //aqui se usa la lista de pair
                    items(FuenteDatos.categoriasOpciones) { (idTexto, idIcono) ->
                        ItemCarrusel(
                            idIcono = idIcono,
                            isSelected = viewModelCiudad.categoriaSeleccionada == idTexto,
                            onClick = { viewModelCiudad.actualizarCategoria(idTexto) }
                        )
                    }

                }

                //lista lugares

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(15.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(viewModelCiudad.lugarFiltrado()) { lugar ->
                        CardLugar(
                            lugar,
                            onClick = {
                                viewModelLugar.seleccionarLugar(lugar)
                                onLugarClick()
                            },
                        )
                    }
                }
            }

        } else {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                Column(
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(8.dp)
                ) {
                    Text(
                        text = stringResource(id = viewModelCiudad.ciudadSeleccionada.name),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    )

                    Text(
                        text = stringResource(R.string.puntos_interes),
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Blue,
                        modifier = Modifier.padding(start = 12.dp, bottom = 8.dp)
                    )

                    LazyColumn (
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(FuenteDatos.categoriasOpciones) { (idTexto, idIcono) ->
                            ItemCarrusel(
                                idIcono = idIcono,
                                isSelected = viewModelCiudad.categoriaSeleccionada == idTexto,
                                onClick = { viewModelCiudad.actualizarCategoria(idTexto) }
                            )
                        }
                    }
                }


                LazyColumn(
                    modifier = Modifier
                        .weight(4f)
                        .fillMaxSize(),
                    contentPadding = PaddingValues(15.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(viewModelCiudad.lugarFiltrado()) { lugar ->
                        CardLugar(
                            lugar = lugar,
                            onClick = {
                                viewModelLugar.seleccionarLugar(lugar)
                                onLugarClick()
                            }
                        )
                    }
                }
            }

        }

    }

}

@Composable
fun ItemCarrusel(
    idIcono: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .size(60.dp)
            .clickable { onClick() }
            .padding(top = 8.dp),

        shape = CircleShape,
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
        shadowElevation = 2.dp
    ) {
        Icon(
            painter = painterResource(id = idIcono),
            contentDescription = null,
            modifier = Modifier.padding(12.dp),
            tint = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

}


@Composable
fun CardLugar(
    lugar: Lugar,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )

    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(
                painter = painterResource(id = lugar.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = stringResource(id = lugar.name),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = stringResource(lugar.categoria),
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = stringResource(R.string.pulsar_para_informacion),
                    color = Color(0xFFE91E63),
                    style = MaterialTheme.typography.labelSmall
                )
            }


        }
    }
}



