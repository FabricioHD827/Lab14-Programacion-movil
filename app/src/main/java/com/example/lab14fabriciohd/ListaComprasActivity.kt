package com.example.lab14fabriciohd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ShoppingItem(
    val id: Int,
    val name: String,
    var isChecked: Boolean = false
)

class ListaComprasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaComprasScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaComprasScreen() {
    val items = remember {
        mutableStateListOf(
            ShoppingItem(1, "Pollo"),
            ShoppingItem(2, "Cebollas", true),
            ShoppingItem(3, "Pimientos"),
            ShoppingItem(4, "Apio"),
            ShoppingItem(5, "Yogures"),
            ShoppingItem(6, "Leche", true),
            ShoppingItem(7, "Huevos"),
            ShoppingItem(8, "Lata de garbanzos"),
            ShoppingItem(9, "Caldo de verduras"),
            ShoppingItem(10, "Pimienta molida", true),
            ShoppingItem(11, "Berenjenas")
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de compras", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
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
                containerColor = Color(0xFF4CAF50)
            ) {
                Text("+", fontSize = 24.sp, color = Color.White)
            }
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                items(items.size) { index ->
                    ShoppingRow(
                        item = items[index],
                        onCheckedChange = { isChecked ->
                            items[index] = items[index].copy(isChecked = isChecked)
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun ShoppingRow(item: ShoppingItem, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(if (item.isChecked) Color(0xFFF0F0F0) else Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item.isChecked,
            onCheckedChange = { onCheckedChange(it) }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item.name,
            fontSize = 16.sp,
            fontWeight = if (item.isChecked) FontWeight.Normal else FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_edit),
                contentDescription = "Editar"
            )
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_sort_by_size),
                contentDescription = "Mover"
            )
        }
    }
}
