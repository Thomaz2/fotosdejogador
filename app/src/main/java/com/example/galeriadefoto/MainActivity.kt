package com.example.galeriadefoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeriadefoto.ui.theme.GaleriaDeFotoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeFotoTheme {

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FotosDeJogador() {

    var mudar by remember { mutableStateOf(1) }
    var idImagem = when (mudar) {
        1 -> R.drawable.messi
        2 -> R.drawable.ronaldo
        3 -> R.drawable.ronaldinho
        else -> R.drawable.neymar
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(500.dp)
                .fillMaxWidth()
                .height(300.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            BotoesNavegacao(text = "anterior") {
                if (mudar > 1)
                    mudar --
                else mudar = 4 }

            BotoesNavegacao(text = "proximo ") {
                if(mudar < 4)
                    mudar ++
                else mudar = 1
                
            }
        }
    }
}

@Composable
fun BotoesNavegacao(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color(236, 34, 78)),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text(text = text)
    }
}



