package splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import compose.theme.Life4EarthTheme
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.ImageRes

@Composable
fun SplashScreen(navigateToAuth: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(1000L)
        navigateToAuth.invoke()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Life4EarthTheme.colors.primaryBackground)
    ) {
        AnimationLife4EarthLogo()
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AnimationLife4EarthLogo() {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(ImageRes.IC_L4E_SPLASH_SVG),
            modifier = Modifier.rotate(angle),
            contentDescription = null
        )
    }
}
