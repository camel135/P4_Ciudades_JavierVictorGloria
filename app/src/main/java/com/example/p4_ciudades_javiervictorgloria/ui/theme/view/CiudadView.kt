package com.example.p4_ciudades_javiervictorgloria.ui.theme.view

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos

@Preview(
    showBackground = true,
    showSystemUi = true,
)

@Composable

fun CiudadView(){
    val lugar = FuenteDatos.lugares[0]

    Scaffold(
        bottomBar = {
            NavigationBar{
                NavigationBarItem(
                    icon= {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Favorito"
                        )
                    },
                    selected = false,
                    onClick = {}
                )

                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Me gusta"
                        )
                    },
                    selected = false,
                    onClick = { }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).padding(16.dp).verticalScroll(
                rememberScrollState()
            )
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    //imagen lugar
                    Image(
                        painter = painterResource(id = lugar.imageRes),
                        contentDescription= null,
                        modifier= Modifier.fillMaxWidth().height(200.dp),
                        contentScale = ContentScale.Crop

                    )

                    Spacer(modifier= Modifier.height(16.dp))

                    //nombre lugar

                    Text(
                        text = stringResource(id = lugar.name),
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    //la ciudad y el pais

                    Text(
                        text = stringResource(id = lugar.ciudad.name) + ", " + stringResource(id = lugar.ciudad.pais),
                        style= MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    //descripcion

                    Text(
                        text = stringResource(id = lugar.descripcion),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)

@Composable
fun CiudadViewPreview(){
    CiudadView()
}