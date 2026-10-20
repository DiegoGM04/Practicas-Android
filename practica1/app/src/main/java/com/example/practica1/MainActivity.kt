package com.example.practica1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica1.ui.theme.Practica1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Practica1Theme {
                BirthdayGreetingWithImage(
                    message = "¡Feliz cumpleaños, Pepe Martínez!",
                    from = "Con mucho cariño Diego",

                    image = R.drawable.feliz
                )
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(
    message: String,
    from: String
) {
    Surface(
        color = Color(0xFF4CAF50)
    ) {
        Column(
            modifier = Modifier.statusBarsPadding()
        ) {

            Text(
                text = message,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )

            Text(
                text = from,
                fontSize = 20.sp,
                color = Color.Yellow,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(
    message: String,
    from: String,
    image: Int
) {
    val imagePainter = painterResource(id = image)

    Box {

        Image(
            painter = imagePainter,
            contentDescription = "Imagen de cumpleaños",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.FillWidth
        )

        BirthdayGreetingWithText(
            message = message,
            from = from
        )
    }
}