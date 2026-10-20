
package com.medilink.actividadimagenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    ContentView()
                }
            }
        }
    }
}

@Composable
fun ContentView() {

    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }

    // LAS CUATRO IMAGENES
    val imagenes = listOf(
        R.drawable.imagen1,
        R.drawable.imagen2,
        R.drawable.imagen3,
        R.drawable.imagen4
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentPadding = PaddingValues(bottom = 30.dp)
    ) {

        item {

            // IMAGEN PRINCIPAL
            Image(
                painter = painterResource(
                    id = R.drawable.imagen1
                ),
                contentDescription = "Imagen principal",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            // BOTON DE ME GUSTA
            Row(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 15.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "👍",
                    fontSize = 30.sp,
                    modifier = Modifier.clickable {
                        counter++
                    }
                )

                Text(
                    text = counter.toString(),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }

            // NOMBRE DE LA MATERIA
            Text(
                text = "Desarrollo de Aplicaciones Moviles",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
            )

            // NOMBRE DEL ESTUDIANTE
            Text(
                text = "Diego Alexis",
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            // APELLIDOS
            Text(
                text = "Gallegos Mireles",
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )

            // TITULO DE LA GALERIA
            Text(
                text = "Galeria de Imagenes",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 30.dp,
                    bottom = 15.dp
                )
            )
        }

        // GALERIA HORIZONTAL
        item {

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {

                itemsIndexed(imagenes) { index, imagen ->

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = imagen),
                            contentDescription = "Imagen ${index + 1}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(160.dp)
                        )

                        Text(
                            text = "Imagen ${index + 1}",
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentViewPreview() {
    MaterialTheme {
        ContentView()
    }
}
