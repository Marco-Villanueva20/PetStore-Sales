package pe.petstore.sales.ui.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.petstore.sales.R
import pe.petstore.sales.ui.theme.Black
import pe.petstore.sales.ui.theme.Green
import pe.petstore.sales.ui.theme.Pink80
import pe.petstore.sales.ui.theme.Purple40
import pe.petstore.sales.ui.theme.Purple80

@Composable
fun InitialScreen(
    navigateToLogin: () -> Unit = {},
    navigationToSignUp: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Purple80, Purple40),
                    startY = 0F,
                    endY = 600F
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.petstore_logo),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.weight(1f))

        TitleText("Muchos artículos para tu mascota")

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navigationToSignUp() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)
        ) {
            Text(text = "Regístrate gratis", color = Black, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        CustomButton(
            modifier = Modifier.clickable { },
            painterResource(R.drawable.google),
            title = "Continuar con Google"
        )
        Spacer(Modifier.height(8.dp))
        CustomButton(
            modifier = Modifier.clickable { },
            painterResource(R.drawable.facebook),
            title = "Continuar con Facebook"
        )
        Text(
            text = "Iniciar sesión",
            color = Color.White,
            modifier = Modifier.padding(24.dp).clickable { navigateToLogin() },
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun CustomButton(
    modifier: Modifier,
    painter: Painter,
    title: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 32.dp)
            .background(Purple40)
            .border(2.dp, Pink80, CircleShape),
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(16.dp)
        )
        Text(
            text = title,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 44.sp
    )
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun InitialPreview() {
    InitialScreen()
}