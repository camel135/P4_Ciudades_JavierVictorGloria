package com.example.p4_ciudades_javiervictorgloria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import com.example.p4_ciudades_javiervictorgloria.navigation.navigation
import com.example.p4_ciudades_javiervictorgloria.ui.theme.P4_Ciudades_JavierVictorGloriaTheme
import com.example.p4_ciudades_javiervictorgloria.ui.theme.view.CiudadView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P4_Ciudades_JavierVictorGloriaTheme {
                navigation()
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun previewApp(){
    CiudadView(
        viewModel(),
        {},
        cityIndex = 0,
    )
}

