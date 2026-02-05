package com.example.p4_ciudades_javiervictorgloria.ui.theme.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p4_ciudades_javiervictorgloria.R

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeView() {
    Surface(
        modifier = Modifier
            .padding(top = 24.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(

            ) {
                NavigationBar(

                ) {
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null,

                                )
                        },
                        selected = false,
                        onClick = {

                        }
                    )
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,

                                )
                        },
                        selected = false,
                        onClick = {

                        }
                    )
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,

                                )
                        },
                        selected = false,
                        onClick = {

                        }
                    )
                }
            }


            Column(
                modifier = Modifier
                    .weight(7f)
                    .fillMaxSize()
                    ,

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(


                ) {
                    Image(
                        painter = painterResource(R.drawable.proto_menu),
                        contentDescription = null,
                        Modifier.size(200.dp)

                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)

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
}