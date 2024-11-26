package com.example.lab14fabriciohd

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab14fabriciohd.ui.theme.Lab14FabricioHDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab14FabricioHDTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        onCompraRapidaClick = {
                            startActivity(Intent(this, CompraRapidaActivity::class.java))
                        },
                        onListaComprasClick = {
                            startActivity(Intent(this, ListaComprasActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onCompraRapidaClick: () -> Unit,
    onListaComprasClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onCompraRapidaClick,
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text(text = "Ir a Compra Rápida")
        }

        Button(
            onClick = onListaComprasClick,
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text(text = "Ir a Mi Lista de Compras")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Lab14FabricioHDTheme {
        MainScreen(
            onCompraRapidaClick = {},
            onListaComprasClick = {}
        )
    }
}
