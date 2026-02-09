package com.example.p4_ciudades_javiervictorgloria.ui.theme.view

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudades_javiervictorgloria.R
import com.example.p4_ciudades_javiervictorgloria.data.FuenteDatos
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelLugar
@Preview
@Composable
fun PreviewLugarView(){
    LugarView(viewModelLugar = viewModel())
}
@SuppressLint("ResourceType")
@Composable
fun LugarView(
    viewModelLugar: ViewModelLugar = viewModel()
){
    val lugar= viewModelLugar.lugarSeleccionado


    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        paddingValues ->
            if (lugar !=null)
         {
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(rememberScrollState())
            ){

                Box(
                    modifier = Modifier.fillMaxWidth().height(350.dp)
                ){
                    Image(
                        painter = painterResource(id = lugar.imageRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth().padding(25.dp)
                ) {
                    Text(
                        text= stringResource(lugar.name),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF7B1FA2)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(lugar.descripcion),
                        style= MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        text = "informacion detallasa",
                        style= MaterialTheme.typography.bodyMedium,
                        lineHeight = 20.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "ubi",
                        style= MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth().height(25.dp),
                        shape = RoundedCornerShape(26.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE)),

                        ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp),
                                    tint = Color.Red
                                )
                                Text(
                                    text = "Ver Google Msaps",
                                    color = Color(0xFF0288D1),
                                    fontWeight = FontWeight.Bold
                                )
                            }

                }






                    }
                }
            }
        }
    }
}

