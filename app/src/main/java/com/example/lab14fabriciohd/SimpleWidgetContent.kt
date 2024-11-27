package com.example.lab14fabriciohd

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Alignment
import androidx.glance.layout.Row
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.text.Text
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.Column
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.background
import androidx.glance.action.actionStartActivity
import androidx.glance.text.FontWeight
import androidx.glance.text.TextStyle
import androidx.compose.ui.graphics.Color
import androidx.glance.action.clickable

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MyWidgetContent()
        }
    }

    @Composable
    fun MyWidgetContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(androidx.glance.unit.ColorProvider(Color(0xFF333333)))  // Fondo suave (gris oscuro)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Accesos rápidos",
                modifier = GlanceModifier.padding(bottom = 12.dp),
                style = TextStyle(color = androidx.glance.unit.ColorProvider(Color.White), fontWeight = FontWeight.Bold)  // Título blanco y en negrita
            )
            Row(
                modifier = GlanceModifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Botón para "Compra Rápida"
                Column(
                    modifier = GlanceModifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        provider = ImageProvider(R.drawable.ic_cart),
                        contentDescription = "Compra rápida",
                        modifier = GlanceModifier
                            .size(60.dp)
                            .background(androidx.glance.unit.ColorProvider(Color(0xFF4CAF50))) 
                            .padding(12.dp)
                            .clickable(actionStartActivity<CompraRapidaActivity>())
                    )
                    Text(
                        text = "Compra rápida",
                        modifier = GlanceModifier.padding(top = 8.dp),
                        style = TextStyle(color = androidx.glance.unit.ColorProvider(Color.White))
                    )
                }

                // Botón para "Mi Lista de Compras"
                Column(
                    modifier = GlanceModifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        provider = ImageProvider(R.drawable.ic_list),
                        contentDescription = "Mi Lista de Compras",
                        modifier = GlanceModifier
                            .size(60.dp)
                            .background(androidx.glance.unit.ColorProvider(Color(0xFF388E3C)))
                            .clickable(actionStartActivity<ListaComprasActivity>())
                    )
                    Text(
                        text = "Mi Lista de Compras",
                        modifier = GlanceModifier.padding(top = 8.dp),
                        style = TextStyle(color = androidx.glance.unit.ColorProvider(Color.White))
                    )
                }
            }
        }
    }
}
