package com.example.p4_ciudades_javiervictorgloria.ui.theme.view


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudades_javiervictorgloria.R
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelHome
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelLugar


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewApp() {
    HomeView(
        viewModel(),

        onNavigateToRandomLugar = {},
        onNavigateToCiudad = {},
    )
}


@Composable
fun HomeView(
    viewModelHome: ViewModelHome = viewModel(),
    viewModelLugar: ViewModelLugar = viewModel(),
    onNavigateToCiudad: () -> Unit,
    onNavigateToRandomLugar: () -> Unit
) {
    val ciudadActual = FuenteDatos.ciudades[viewModelHome.ciudadIndex]



    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
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
                            painter = painterResource(
                                id= if(viewModelHome.darkMode) R.drawable.outline_brightness_6_24
                                else R.drawable.outline_brightness_6_24
                            ),
                            contentDescription = "Tema",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.ciudad_anterior),
                        )
                    },
                    selected = false,
                    onClick = {
                        viewModelHome.anteriorCiudad()
                    }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = stringResource(R.string.lugar_aleatorio)
                        )
                    },
                    selected = false,
                    onClick = {
                        viewModelLugar.lugarRandom()
                        onNavigateToRandomLugar()
                    }
                )

                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = stringResource(R.string.ciudad_siguiente),
                        )
                    },
                    selected = false,
                    onClick = {
                        viewModelHome.siguienteCiudad()
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(ciudadActual.imagenPlaneta),
                contentDescription = stringResource(ciudadActual.name),
                modifier = Modifier
                    .size(300.dp)
                    .clickable {
                        onNavigateToCiudad()
                    }
            )

            Button(
                onClick = {
                    onNavigateToCiudad()
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = stringResource(ciudadActual.name),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Composable
fun dropDownMenu(viewModelHome: ViewModelHome) {

    val context = LocalContext.current
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://github.com/camel135/P4_Ciudades_JavierVictorGloria.git")
    )

    Box {
        IconButton(onClick = { viewModelHome.onDropDownMenuClick() }) {
            Icon(Icons.Default.MoreVert, contentDescription = stringResource(R.string.mas_opciones))
        }

        DropdownMenu(
            expanded = viewModelHome.expanded,
            onDismissRequest = { viewModelHome.onDismissMenu() }
        ) {
            DropdownMenuItem(
                text = { Text(stringResource(R.string.idioma)) },
                onClick = {


                }
            )

            DropdownMenuItem(
                text = { Text(stringResource(R.string.acerca_de)) },
                onClick = {
                    context.startActivity(intent)


                }

            )
        }
    }
}