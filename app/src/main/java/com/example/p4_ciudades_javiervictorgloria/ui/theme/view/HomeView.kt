package com.example.p4_ciudades_javiervictorgloria.ui.theme.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p4_ciudades_javiervictorgloria.R

@Preview
@Composable
fun HomeView() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.padding(top = 16.dp)) {

        }
        Column(
            modifier = Modifier
        ) {
            Box(


                modifier = Modifier
                    .padding(),

                ) {
                Image(
                    painter = painterResource(R.drawable.proto_menu),
                    contentDescription = null,

                    )
            }
        }
        Column(
            modifier = Modifier
                .padding(bottom = 0.dp)
        ) {
            NavigationBar() {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,

                            )
                    },
                    selected = false,
                    onClick = {

                    }
                )

                NavigationBarItem(
                    icon = { Text("Ciudad") },
                    selected = false,
                    onClick = {

                    }
                )


                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,

                            )
                    },
                    selected = false,
                    onClick = {

                    }
                )

            }
        }
    }
}