package com.example.p4_ciudades_javiervictorgloria.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p4_ciudades_javiervictorgloria.ui.theme.view.CiudadView
import com.example.p4_ciudades_javiervictorgloria.ui.theme.view.HomeView
import com.example.p4_ciudades_javiervictorgloria.ui.theme.view.LugarView
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelLugar

enum class Views {
    Home,
    Ciudad,
    Lugar
}

@Composable
fun navigation() {

    val navController = rememberNavController()
    val navLugar: ViewModelLugar = viewModel()
    val navLugarRandom: ViewModelLugar = viewModel()


    NavHost(
        navController = navController,
        startDestination = Views.Home.name,
    ) {
        composable(route = Views.Home.name) {
            HomeView(
                viewModelHome = viewModel(),
                viewModelLugar = navLugarRandom,
                onNavigateToCiudad = { navController.navigate(Views.Ciudad.name) },
                onNavigateToRandomLugar = { navController.navigate(Views.Lugar.name) }
            )
        }

        composable(route = Views.Ciudad.name) {
            CiudadView(
                viewModelCiudad = viewModel(),
                viewModelLugar = navLugar,
                onLugarClick = { navController.navigate(Views.Lugar.name) },

            )
        }

        composable(route = Views.Lugar.name) {
            LugarView(viewModelLugar = navLugar)
        }
    }
}


