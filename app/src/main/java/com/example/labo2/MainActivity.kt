package com.example.labo2

import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

//Configura la interfaz de usuario usando jetpack compose
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            Window()
            //Esta funcion composable se encarga de mostrar en pantalla todos los elementos estruxturados en MyComponent()
        }

    }
}

//Fucnion componente principal de la interfaz, estructura todos los elementos y modifica el formato
//Muestra lso mensajes de bienvenida y boton con mensaje snackbar
@Composable
fun Window() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { defaultPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(defaultPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Ivana Figueroa", color = Color.Blue, fontSize = 20.sp)
            Text("Bienvenidos a Destiny")

            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Sana tú, crece él. Destiny.")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("Haz Click")
            }
        }
    }
}


//Funcion que permite previzualizar la funci[on window sin necesidad de emular
@Preview
@Composable
fun PreviewWindow(){
    Window()

}
