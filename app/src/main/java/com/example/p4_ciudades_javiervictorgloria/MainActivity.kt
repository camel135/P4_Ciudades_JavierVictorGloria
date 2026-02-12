package com.example.p4_ciudades_javiervictorgloria

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudades_javiervictorgloria.navigation.navigation
import com.example.p4_ciudades_javiervictorgloria.ui.theme.P4_Ciudades_JavierVictorGloriaTheme
import com.example.p4_ciudades_javiervictorgloria.ui.theme.utils.EstadoPantalla
import com.example.p4_ciudades_javiervictorgloria.ui.theme.viewModel.ViewModelHome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModelHome: ViewModelHome = viewModel()

            val config = LocalConfiguration.current
            val estadoPantalla = if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                EstadoPantalla.HORIZONTAL
            }else{
                EstadoPantalla.VERTICAL
            }

            P4_Ciudades_JavierVictorGloriaTheme(
                darkTheme = viewModelHome.darkMode
            ) {
                navigation(viewModelHome,estadoPantalla)
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewApp() {
    P4_Ciudades_JavierVictorGloriaTheme {
        navigation(
            viewModelHome = TODO(),
            estadoPantalla = TODO()
        )
    }
}
