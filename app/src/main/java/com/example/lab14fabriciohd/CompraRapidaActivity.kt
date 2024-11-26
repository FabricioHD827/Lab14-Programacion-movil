package com.example.lab14fabriciohd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CompraRapidaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompraRapidaScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompraRapidaScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi lista", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4CAF50),
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = CircleShape,
                containerColor = Color(0xFF388E3C)
            ) {
                Text("+", fontSize = 24.sp, color = Color.White)
            }
        },
        content = {
            LazyColumn(modifier = Modifier.padding(it)) {
                item {
                    CategoryTitle(title = "Frutas, verduras y huevos")
                }
                items(2) { index ->
                    ProductRow(
                        imageRes = if (index == 0) R.drawable.banana else R.drawable.tomato,
                        name = if (index == 0) "Plátano" else "Tomate",
                        price = 1.0
                    )
                }

                item {
                    CategoryTitle(title = "Abarrotes")
                }
                items(2) { index ->
                    ProductRow(
                        imageRes = if (index == 0) R.drawable.crackers else R.drawable.chocolate,
                        name = if (index == 0) "Crackers" else "Oblea rellena",
                        price = if (index == 0) 2.5 else 3.0
                    )
                }

                item {
                    CategoryTitle(title = "Carrito")
                }
                items(1) {
                    ProductRow(
                        imageRes = R.drawable.lemon,
                        name = "Lima",
                        price = 1.0
                    )
                }
            }
        },
        bottomBar = {
            BottomBar()
        }
    )
}

@Composable
fun CategoryTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun ProductRow(imageRes: Int, name: String, price: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "1 un - S/.${price}", fontSize = 14.sp, color = Color.Gray)
        }
        Checkbox(checked = false, onCheckedChange = {})
    }
}

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4CAF50))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Total (5)", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "S/. 5.00", color = Color.White, fontSize = 14.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Carrito (1)", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "S/. 1.00", color = Color.White, fontSize = 14.sp)
        }
    }
}