package forgot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.theme.Life4EarthTheme
import compose.widgets.CommonActionButton

@Composable
fun ForgotPasswordScreen(
    popUp: () -> Unit,
    navigateToRegister: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().background(Life4EarthTheme.colors.primaryBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            text = "ForgotPasswordScreen",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Life4EarthTheme.colors.primaryText,
            fontWeight = FontWeight.Medium
        )

        CommonActionButton(
            modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 32.dp),
            text = "Go to Register",
            enabled = true,
            onClick = { navigateToRegister.invoke() }
        )

        CommonActionButton(
            modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 32.dp),
            text = "Back",
            enabled = true,
            onClick = { popUp.invoke() }
        )
    }
}