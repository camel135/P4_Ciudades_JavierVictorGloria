package com.example.p4_ciudades_javiervictorgloria.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p4_ciudades_javiervictorgloria.ui.theme.utils.EstadoPantalla
import com.example.p4_ciudades_javiervictorgloria.ui.theme.view.CiudadView
import com.example.p4_ciudades_javiervictorgloria.ui.theme.view.HomeView
import com.example.p4_ciudades_javiervictorgloria.ui.theme.view.LugarView
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelLugar
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelCiudad
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelHome


enum class Views {
    Home,
    Ciudad,
    Lugar
}

@Composable
fun navigation(
    viewModelHome: ViewModelHome= viewModel(),
    estadoPantalla: EstadoPantalla
) {
    val navController = rememberNavController()


    val viewModelCiudad: ViewModelCiudad = viewModel()
    val viewModelLugar: ViewModelLugar = viewModel()


    NavHost(
        navController = navController,
        startDestination = Views.Home.name,
    ) {
        composable(route = Views.Home.name) {
            HomeView(
                viewModelHome = viewModelHome,
                viewModelLugar = viewModelLugar,
                onNavigateToCiudad = {
                    // antes de navegar acutalizar el ViewModelCiudad con la ciudad actual
                    viewModelCiudad.actualizarCiudad(viewModelHome.ciudadIndex)
                    navController.navigate(Views.Ciudad.name)
                },
                onNavigateToRandomLugar = {
                    navController.navigate(Views.Lugar.name)
                }
            )
        }

        composable(route = Views.Ciudad.name) {
            CiudadView(
                viewModelCiudad = viewModelCiudad,
                viewModelLugar = viewModelLugar,
                onLugarClick = {
                    navController.navigate(Views.Lugar.name)
                },
                estadoPantalla = estadoPantalla,
            )
        }

        composable(route = Views.Lugar.name) {
            LugarView(viewModelLugar = viewModelLugar)
        }
    }
}


