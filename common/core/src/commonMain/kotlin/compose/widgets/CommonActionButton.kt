package compose.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import compose.theme.Life4EarthTheme

@Composable
fun CommonActionButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Life4EarthTheme.colors.primaryAction),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        onClick = { onClick.invoke() }) {
        Text(
            text = text,
            color = Life4EarthTheme.colors.primaryText,
            style = Life4EarthTheme.typography.smallHeading,
            textAlign = TextAlign.Center
        )
    }
}
