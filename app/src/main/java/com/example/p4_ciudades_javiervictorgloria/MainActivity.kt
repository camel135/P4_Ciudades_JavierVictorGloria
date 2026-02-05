package com.example.p4_ciudades_javiervictorgloria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.p4_ciudades_javiervictorgloria.ui.theme.P4_Ciudades_JavierVictorGloriaTheme
import com.example.p4_ciudades_javiervictorgloria.ui.theme.view.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P4_Ciudades_JavierVictorGloriaTheme {
                HomeView(
                    viewModel = TODO()
                )
            }
        }
    }
}

@Preview
@Composable
fun previewApp(){
    HomeView(
        viewModel = TODO()
    )
}

