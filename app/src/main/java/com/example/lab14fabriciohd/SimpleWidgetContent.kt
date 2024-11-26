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
                .background(android.R.color.background_light)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Accesos rápidos",
                modifier = GlanceModifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = GlanceModifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Botón para "Compra Rápida"
                Column(
                    modifier = GlanceModifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        provider = ImageProvider(R.drawable.ic_cart),
                        contentDescription = "Compra rápida",
                        modifier = GlanceModifier.size(48.dp).padding(bottom = 4.dp)
                    )
                    Text(text = "Compra rápida")
                    androidx.glance.action.actionStartActivity<CompraRapidaActivity>()
                }

                // Botón para "Mi Lista de Compras"
                Column(
                    modifier = GlanceModifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        provider = ImageProvider(R.drawable.ic_list),
                        contentDescription = "Mi Lista de Compras",
                        modifier = GlanceModifier.size(48.dp).padding(bottom = 4.dp)
                    )
                    Text(text = "Mi Lista de Compras")
                    androidx.glance.action.actionStartActivity<ListaComprasActivity>()
                }
            }
        }
    }
}
