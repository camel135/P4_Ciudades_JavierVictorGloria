package com.example.p4_ciudades_javiervictorgloria.ui.theme.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.R
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelHome


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun previewApp() {
    HomeView(
        viewModel(),
        {}
    )
}


@Composable
fun HomeView(
    viewModelHome: ViewModelHome = viewModel(),
    onNavigateToCiudad: () -> Unit
) {
    // para saber la ciudad actual usando el indice
    val ciudadActual = FuenteDatos.ciudades[viewModelHome.ciudadIndex]

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Barra superior
            NavigationBar {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    dropDownMenu(viewModelHome)

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Info",
                        )
                    }
                    IconButton(onClick = { viewModelHome.onSunClick() }) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Tema",
                        )
                    }
                }

            }


            // Central (el planeta)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    // Al hacer click en planeta se entra pasa a la pagina
                    modifier = Modifier
                        .clickable {
                            onNavigateToCiudad()
                        }
                ) {
                    Image(
                        painter = painterResource(ciudadActual.imagenPlaneta),
                        contentDescription = stringResource(ciudadActual.name),
                        modifier = Modifier.size(300.dp)
                    )
                }
            }
            // Para la zona inferior
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Anterior",
                        )
                    },
                    selected = false,
                    onClick = {
                        viewModelHome.anteriorCiudad()
                    }
                )
                // texto ciudad
                NavigationBarItem(
                    icon = {
                        Text(
                            text = stringResource(ciudadActual.name),
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    selected = false,
                    onClick = {
                        onNavigateToCiudad()
                    }
                )

                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "Siguiente",
                        )
                    },
                    selected = false,
                    onClick = {
                        viewModelHome.siguienteCiudad()
                    }
                )

            }
        }
    }
}
@Composable
fun dropDownMenu(viewModelHome: ViewModelHome) {

    Box() {

        IconButton(onClick = { viewModelHome.onDropDownMenuClick() }) {
            Icon(Icons.Default.MoreVert, contentDescription = "More options")
        }

        DropdownMenu(
            expanded = viewModelHome.expanded,
            onDismissRequest = { viewModelHome.onDismissMenu() }
        ) {
            DropdownMenuItem(
                text = { Text("Option 1") },
                onClick = { viewModelHome.onDismissMenu() }
            )
            DropdownMenuItem(
                text = { Text("Option 2") },
                onClick = { viewModelHome.onDismissMenu() }
            )
        }
    }
}









