package com.example.app_recibos


import IniciarSesion
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_recibos.ui.theme.App_recibosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_recibosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavegacion(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavegacion(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Pantallas.Bienvenida.name) {
        composable(route = Pantallas.Bienvenida.name) {
            Bienvenida(
                modifier = modifier,
                accion = { navController.navigate(Pantallas.IniciarSesion.name) },
                accionCrear = { navController.navigate(Pantallas.CrearCuenta.name) }
            )
        }
        composable(route = Pantallas.IniciarSesion.name) {
            IniciarSesion(modifier = modifier)
        }
        composable(route = Pantallas.CrearCuenta.name) {
            // Pantalla de registro (por implementar)
        }
    }
}

enum class Pantallas {
    Bienvenida,
    IniciarSesion,
    CrearCuenta,
}

// ---------------------------------------------------------
// Pantalla de bienvenida SERVIPAGO
// Los espacios de imagen (logo e ilustración) quedan como Box
// vacíos, con el Image(painterResource(...)) comentado debajo
// para pegar los recursos reales en res/drawable.
// ---------------------------------------------------------
@Composable
fun Bienvenida(
    modifier: Modifier = Modifier,
    accion: () -> Unit = {},
    accionCrear: () -> Unit = {}
) {
    Surface(
        color = Color.Black,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            // Logo SERVIPAGO
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                 Image(
                     painter = painterResource(id = R.drawable.app_logo),
                     contentDescription = "Logo SERVIPAGO",
                     modifier = Modifier.size(56.dp)
                 )
                Text(
                    text = "SERVIPAGO",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Ilustración: mano con celular + íconos agua/luz/gas/wifi

             Image(
                 painter = painterResource(id = R.drawable.app_inicio),
                 contentDescription = "Ilustración de bienvenida",
                 modifier = Modifier
                     .fillMaxWidth()
                     .height(220.dp)
             )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "¡BIENVENIDOS A\nSERVIPAGO!",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Tus facturas, bajo control y sin cortes.",
                color = Color.LightGray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Botón: Iniciar Sesión
            Button(
                onClick = accion,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Iniciar Sesión",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Enlace: Crear Cuenta
            TextButton(onClick = accionCrear) {
                Text(
                    text = "Crear Cuenta",
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BienvenidaPreview() {
    Bienvenida()
}