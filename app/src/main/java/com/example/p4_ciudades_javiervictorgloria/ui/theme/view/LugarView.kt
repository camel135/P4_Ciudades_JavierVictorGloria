package com.example.p4_ciudades_javiervictorgloria.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelLugar

@Composable
fun LugarView(
    viewModelLugar: ViewModelLugar = viewModel(),
    onBack: () -> Unit
){
    val lugar= viewModelLugar.lugarSeleccionado

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->

        if (viewModelLugar.datosValidosLugar() && lugar !=null){
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(
                    rememberScrollState()
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth().height(350.dp)
                ){
                    Image(
                        painter = painterResource(id = lugar.imageRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.padding(17.dp).background(Color.White)
                    ) { }
                }
            }
        }
    }
}
