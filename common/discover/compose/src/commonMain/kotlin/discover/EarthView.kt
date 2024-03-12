package discover

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import di.LocalScreenSize
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.ImageRes.DISCOVER_EARTH_JPG
import utils.getPercentageOff
import utils.pxToDp

@OptIn(ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
@Composable
fun EarthView() {
    val screenSize = LocalScreenSize.current
    val viewSize = getPercentageOff(screenSize.width, 25f).pxToDp()

    Surface(
        modifier = Modifier.size(viewSize),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Blue.copy(alpha = 0.1f)),
        elevation = 25.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    val gradient = Brush.radialGradient(
                        colors = listOf(Color.Black.copy(alpha = .1f), Color.Black.copy(alpha = .8f)),
                        tileMode = TileMode.Clamp
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                    }
                }
                .basicMarquee(
                    animationMode = MarqueeAnimationMode.Immediately,
                    spacing = MarqueeSpacing.fractionOfContainer(0f),
                    delayMillis = 0,
                    iterations = Int.MAX_VALUE,
                    velocity = 70.dp
                )
        ) {
            Image(
                modifier = Modifier.fillMaxSize().alpha(0.5f),
                contentScale = ContentScale.Crop,
                painter = painterResource(DISCOVER_EARTH_JPG),
                contentDescription = null
            )
        }
    }
}
