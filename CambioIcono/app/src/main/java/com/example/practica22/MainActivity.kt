package com.example.practica22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                PantallaPractica()
            }
        }
    }
}

@Composable
fun PantallaPractica() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0B2033)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(
                        id = R.drawable.ilustracion_apps
                    ),
                    contentDescription = stringResource(
                        id = R.string.descripcion_imagen
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                // Mensaje principal
                Text(
                    text = stringResource(
                        id = R.string.mensaje
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFB3E5FC),
                    fontSize = 28.sp,
                    lineHeight = 34.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(32.dp)
                )

                // Nombre del alumno
                Text(
                    text = stringResource(
                        id = R.string.nombre_alumno
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFFFD166),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaPractica() {
    MaterialTheme {
        PantallaPractica()
    }
}