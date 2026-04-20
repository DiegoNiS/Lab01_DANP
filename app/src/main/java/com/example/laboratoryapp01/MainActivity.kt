package com.example.laboratoryapp01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@Composable
fun LabApp01() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0F172A)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            // Usando los composables reutilizables
            TarjetaPerfil(
                nombre = "Diego",
                rol = "Ingeniería de Sistemas",
                descripcion = "Aprendiendo desarrollo móvil con Jetpack Compose"
            )

            Spacer(modifier = Modifier.height(24.dp))
            DivisorEtiqueta(etiqueta = "acciones")
            Spacer(modifier = Modifier.height(24.dp))

            BotonPrimario(texto = "Ver perfil") {
                // acción aquí
            }

            Spacer(modifier = Modifier.height(12.dp))

            BotonPrimario(texto = "Contactar") {
                // acción aquí
            }
        }
    }
}

// ─────────────────────────────────────────
// 1. Componente: Tarjeta de perfil
// ─────────────────────────────────────────
@Composable
fun TarjetaPerfil(
    nombre: String,
    rol: String,
    descripcion: String
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextoTitulo(texto = nombre)
            TextoSubtitulo(texto = rol)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = descripcion,
                fontSize = 14.sp,
                color = Color(0xFF94A3B8),
                textAlign = TextAlign.Center
            )
        }
    }
}

// ─────────────────────────────────────────
// 2. Composable: Texto título reutilizable
// ─────────────────────────────────────────
@Composable
fun TextoTitulo(texto: String) {
    Text(
        text = texto,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF38BDF8)
    )
}

// ─────────────────────────────────────────
// 3. Composable: Texto subtítulo reutilizable
// ─────────────────────────────────────────
@Composable
fun TextoSubtitulo(texto: String) {
    Text(
        text = texto,
        fontSize = 14.sp,
        color = Color(0xFF64748B),
        fontWeight = FontWeight.Medium
    )
}

// ─────────────────────────────────────────
// 4. Composable: Botón personalizado reutilizable
// ─────────────────────────────────────────
@Composable
fun BotonPrimario(
    texto: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38BDF8)),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {
        Text(
            text = texto,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF0F172A)
        )
    }
}

// ─────────────────────────────────────────
// 5. Composable: Divisor con etiqueta
// ─────────────────────────────────────────
@Composable
fun DivisorEtiqueta(etiqueta: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = Color(0xFF334155)
        )
        Text(
            text = "  $etiqueta  ",
            fontSize = 12.sp,
            color = Color(0xFF64748B)
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = Color(0xFF334155)
        )
    }
}