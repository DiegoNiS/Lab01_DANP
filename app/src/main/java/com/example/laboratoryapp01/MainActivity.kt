package com.example.laboratoryapp01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratoryapp01.ui.theme.LaboratoryApp01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaboratoryApp01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        color = Color(0xFF0F172A) // fondo oscuro
                    ) {
                        LabApp01()
                    }
                }
            }
        }
    }
}

// ─────────────────────────────────────────
// Modelo de datos
// ─────────────────────────────────────────
data class Tarea(
    val titulo: String,
    val descripcion: String,
    val etiqueta: String,
    val color: Color
)

// ─────────────────────────────────────────
// Datos estáticos
// ─────────────────────────────────────────
val listaDeTareas = listOf(
    Tarea("Diseñar base de datos", "Crear el esquema ER para el sistema de ventas", "BD", Color(0xFF6366F1)),
    Tarea("Implementar login", "Pantalla de autenticación con validación de campos", "Auth", Color(0xFF38BDF8)),
    Tarea("Conectar API REST", "Integrar Retrofit para consumir los endpoints del backend", "API", Color(0xFF34D399)),
    Tarea("Crear pantalla home", "Diseñar la pantalla principal con LazyColumn", "UI", Color(0xFFFBBF24)),
    Tarea("Subir a GitHub", "Hacer commit y push del avance del laboratorio", "Git", Color(0xFFF87171)),
    Tarea("Documentar código", "Agregar comentarios y README al proyecto", "Docs", Color(0xFFA78BFA)),
)

// ─────────────────────────────────────────
// ItemCard: tarjeta individual reutilizable
// ─────────────────────────────────────────
@Composable
fun TareaCard(tarea: Tarea) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Indicador de color lateral
            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = tarea.color.copy(alpha = 0.2f)),
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = tarea.etiqueta.take(2),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = tarea.color
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Título y descripción
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tarea.titulo,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFF1F5F9)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = tarea.descripcion,
                    fontSize = 13.sp,
                    color = Color(0xFF94A3B8),
                    lineHeight = 18.sp
                )
            }
        }
    }
}

// ─────────────────────────────────────────
// Pantalla principal con LazyColumn
// ─────────────────────────────────────────
@Composable
fun LabApp01() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0F172A)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Header
            Column(modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 48.dp, bottom = 16.dp)) {
                Text(
                    text = "Mis Tareas",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF38BDF8)
                )
                Text(
                    text = "${listaDeTareas.size} tareas pendientes",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B)
                )
            }

            // Lista
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(listaDeTareas) { tarea ->
                    TareaCard(tarea = tarea)
                }
            }
        }
    }
}