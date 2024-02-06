package compose.widgets

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import compose.theme.Life4EarthTheme

@Composable
fun CommonOutlinedTextField(
    modifier: Modifier,
    text: String,
    hint: String,
    enabled: Boolean = true,
    isSecure: Boolean = false,
    trailingIcon: @Composable () -> Unit = {},
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Life4EarthTheme.colors.primaryText,
            unfocusedTextColor = Life4EarthTheme.colors.primaryText,
            focusedContainerColor = Life4EarthTheme.colors.primaryBackground,
            unfocusedContainerColor = Life4EarthTheme.colors.primaryBackground,
            focusedBorderColor = Life4EarthTheme.colors.focusedBorderColor,
            unfocusedBorderColor = Life4EarthTheme.colors.unfocusedBorderColor,
            cursorColor = Life4EarthTheme.colors.primaryText,
        ),
        visualTransformation = if (isSecure) PasswordVisualTransformation() else VisualTransformation.None,
        placeholder = { Text(text = hint, color = Life4EarthTheme.colors.secondaryText) },
        shape = RoundedCornerShape(8.dp),
        trailingIcon = { trailingIcon.invoke() },
        enabled = enabled,
        onValueChange = { onValueChanged(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}
