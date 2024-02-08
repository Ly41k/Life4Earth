package login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.life4earth.app.auth.compose.strings.AuthComposeResStrings
import compose.theme.Life4EarthTheme
import compose.widgets.CommonActionButton
import compose.widgets.CommonOutlinedTextField
import login.models.LoginEvent
import login.models.LoginViewState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.ImageRes.IC_GOOGLE_SVG

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginView(
    state: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                textAlign = TextAlign.Center,
                text = AuthComposeResStrings.discover_now,
                style = Life4EarthTheme.typography.mediumHeading,
                color = Life4EarthTheme.colors.primaryText
            )
        }

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                text = AuthComposeResStrings.discover_now_description,
                style = Life4EarthTheme.typography.smallHeading,
                textAlign = TextAlign.Center,
                color = Life4EarthTheme.colors.secondaryText
            )
        }

        item {
            CommonOutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                text = state.email,
                hint = AuthComposeResStrings.email,
                onValueChanged = {
                    eventHandler.invoke(LoginEvent.EmailChanged(it))
                }
            )
        }

        item {
            CommonOutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                text = state.password,
                hint = AuthComposeResStrings.password,
                isSecure = !state.isPasswordShow,
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            eventHandler.invoke(LoginEvent.PasswordShowClick)
                        },
                        imageVector = if (state.isPasswordShow) {
                            Icons.Outlined.Clear
                        } else {
                            Icons.Outlined.Lock
                        },
                        contentDescription = AuthComposeResStrings.password_hidden,
                        tint = Life4EarthTheme.colors.secondaryText
                    )
                },
                onValueChanged = {
                    eventHandler.invoke(LoginEvent.PasswordChanged(it))
                }
            )
        }

        item {

            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.clickable { eventHandler.invoke(LoginEvent.ForgotClick) },
                    text = AuthComposeResStrings.forgot_password,
                    color = Life4EarthTheme.colors.secondaryText,
                    style = Life4EarthTheme.typography.text
                )
            }
        }

        item {
            CommonActionButton(
                text = AuthComposeResStrings.login,
                enabled = true,
                onClick = {}

            )
        }

        item {
            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                text = AuthComposeResStrings.or,
                color = Life4EarthTheme.colors.primaryText,
                style = Life4EarthTheme.typography.smallHeading,
                textAlign = TextAlign.Center,

                )
        }

        item {

            Box(
                modifier = Modifier
                    .wrapContentSize().height(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Life4EarthTheme.colors.googleButtonBackground)
                    .clickable {

                    }

            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .aspectRatio(1f, true).padding(2.dp).clip(RoundedCornerShape(6.dp))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(painterResource(IC_GOOGLE_SVG), contentDescription = AuthComposeResStrings.sign_in_google)
                    }

                    Text(
                        modifier = Modifier.wrapContentSize().padding(horizontal = 10.dp),
                        text = AuthComposeResStrings.sign_in_google,
                        color = Life4EarthTheme.colors.primaryText,
                        style = Life4EarthTheme.typography.smallHeading
                    )
                }
            }
        }

        item {
            Row(
                modifier = Modifier.padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(end = 2.dp),
                    text = AuthComposeResStrings.not_member,
                    style = Life4EarthTheme.typography.smallHeading,
                    color = Life4EarthTheme.colors.primaryText
                )

                Text(
                    modifier = Modifier
                        .padding(start = 2.dp)
                        .clickable { eventHandler.invoke(LoginEvent.RegistrationClick) },
                    text = AuthComposeResStrings.sign_up,
                    style = Life4EarthTheme.typography.smallHeading,
                    color = Life4EarthTheme.colors.primaryAction
                )
            }
        }
    }
}
