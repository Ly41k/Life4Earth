package splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen(
    navigateToAuth: () -> Unit
) {
//    LaunchedEffect(Unit) {
//        delay(1000L)
//        navigationToAuth.invoke()
//    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            text = "SplashScreen",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.Red,
            fontWeight = FontWeight.Medium
        )

        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            onClick = { navigateToAuth.invoke() }
        ) {
            Text(text = "Go to Login")
        }
    }
}
