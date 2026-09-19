
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_recibos.R

/**
 * Pantalla de Iniciar Sesión.
 * Los íconos (persona, llave, Google) quedan como Box vacíos
 * para que pegues las imágenes/íconos reales cuando los tengas.
 */
@Composable
fun IniciarSesion(
    email: String = "",
    contrasena: String = "",
    modifier: Modifier = Modifier,
    onEmailCambia: (String) -> Unit = {},
    onContrasenaCambia: (String) -> Unit = {},
    accion: () -> Unit = {},
    accionOlvide: () -> Unit = {},
    accionGoogle: () -> Unit = {}
) {
    val focusManager = LocalFocusManager.current

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

            Text(
                text = "Iniciar Sesion",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Tarjeta con el formulario
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF2A2A2A))
                    .padding(20.dp)
            ) {

                Text(
                    text = "Ingresa tus Datos",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Campo: Email o Usuario
                OutlinedTextField(
                    value = email,
                    onValueChange = onEmailCambia,
                    placeholder = { Text("Email o Usuario", color = Color.LightGray) },
                    singleLine = true,
                    shape = RoundedCornerShape(50),
                    leadingIcon = {
                        // Ícono de persona (vacío, reemplazar por el ícono real)

                         Image(
                             painter = painterResource(id = R.drawable.usuario_logo),
                             contentDescription = null,
                             modifier = Modifier.size(20.dp)
                         )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFF4A4A4A),
                        focusedContainerColor = Color(0xFF4A4A4A),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo: Contraseña
                OutlinedTextField(
                    value = contrasena,
                    onValueChange = onContrasenaCambia,
                    placeholder = { Text("Contraseña", color = Color.LightGray) },
                    singleLine = true,
                    shape = RoundedCornerShape(50),
                    visualTransformation = PasswordVisualTransformation(),
                    leadingIcon = {
                        // Ícono de llave (vacío, reemplazar por el ícono real)

                         Image(
                             painter = painterResource(id = R.drawable.llave_logo),
                             contentDescription = null,
                             modifier = Modifier.size(20.dp)
                         )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFF4A4A4A),
                        focusedContainerColor = Color(0xFF4A4A4A),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Olvidaste tu contraseña",
                    color = Color(0xFF64B5F6),
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = accionOlvide)
                )

                Spacer(modifier = Modifier.height(20.dp))

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
                        text = "Iniciar Sesion",
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "o Inicia con:",
                color = Color.LightGray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón: Google
            Button(
                onClick = accionGoogle,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                // Ícono de Google (vacío, reemplazar por el ícono real)

                 Image(
                     painter = painterResource(id = R.drawable.app_logo_google),
                     contentDescription = "Google",
                     modifier = Modifier.size(20.dp)
                 )
                Spacer(modifier = Modifier.height(0.dp).width(8.dp))
                Text(text = "Google", fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun IniciarSesionPreview() {
    IniciarSesion()
}
