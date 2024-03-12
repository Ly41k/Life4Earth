package discover

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import compose.theme.Life4EarthTheme
import di.LocalScreenSize
import di.ScreenSize
import discover.models.DiscoverButtonAnimationTypes
import discover.models.DiscoverButtonPanelModel
import discover.models.DiscoverButtonPanelParamsModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.getPercentageOff
import utils.pxToDp

@Composable
fun DiscoverButtonPanelView(
    modifier: Modifier = Modifier,
    buttonQuantity: Int,
    buttonContainerPaddingPercent: Float = 10f,
    paramsModels: List<DiscoverButtonPanelModel.ParamsModel>

) {
    val screenSize = LocalScreenSize.current

    val containerWidth =
        remember { getDiscoverButtonContainerWidth(screenSize, buttonContainerPaddingPercent, buttonQuantity) }

    val items = paramsModels.withIndex().mapNotNull {
        getDiscoverButtonPanelParams(
            containerWidth = containerWidth,
            iconParam = it.value,
            size = paramsModels.size,
            index = it.index
        )
    }
    containerWidth?.let { cWidth ->
        Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier.width(cWidth.pxToDp()).background(Life4EarthTheme.colors.primaryBackground),
                horizontalArrangement = Arrangement.Center
            ) {


                items.forEach {
                    Column {
                        when (it.icon.animation) {
                            DiscoverButtonAnimationTypes.Pulsating -> PulsatingCircles(model = it)
                            DiscoverButtonAnimationTypes.Rotation -> AnimationLife4EarthLogo(model = it)
                        }
                        Text(
                            modifier = Modifier.width(it.itemSize.pxToDp()),
                            textAlign = TextAlign.Center,
                            text = it.icon.title,
                            color = Life4EarthTheme.colors.primaryText,
                            maxLines = 1,
                            fontSize = 12.sp,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AnimationLife4EarthLogo(
    modifier: Modifier = Modifier,
    model: DiscoverButtonPanelParamsModel
) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    Box(
        modifier = modifier.size(model.itemSize.pxToDp()),
        contentAlignment = Alignment.Center
    ) {

        Image(
            modifier = Modifier.size(model.itemSize.pxToDp()).rotate(angle),
            painter = painterResource(model.icon.iconSrc),
            contentDescription = model.icon.title
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PulsatingCircles(
    modifier: Modifier = Modifier,
    model: DiscoverButtonPanelParamsModel
) {
    Column {
        val infiniteTransition = rememberInfiniteTransition()
        val pulsatingCircleSize by infiniteTransition.animateValue(
            initialValue = model.iconSize.pxToDp(),
            targetValue = model.itemSize.pxToDp(),
            Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(model.durationMillis, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        Box(
            modifier = modifier.size(model.itemSize.pxToDp()),
            contentAlignment = Alignment.Center
        ) {
            AnimationPulsatingCircleShapeView(
                size = pulsatingCircleSize,
                color = model.icon.color
            )
            Image(
                modifier = Modifier.size(model.iconSize.pxToDp()),
                painter = painterResource(model.icon.iconSrc),
                contentDescription = model.icon.title
            )
        }
    }
}

@Composable
fun AnimationPulsatingCircleShapeView(size: Dp, color: Color) {
    Column(modifier = Modifier.wrapContentSize(Alignment.Center)) {
        Box(modifier = Modifier.size(size).clip(CircleShape).background(color))
    }
}


private fun getDiscoverButtonPanelParams(
    containerWidth: Int?,
    iconParam: DiscoverButtonPanelModel.ParamsModel,
    size: Int,
    index: Int
): DiscoverButtonPanelParamsModel? {
    if (containerWidth == null) return null
    if (size <= 0) return null
    if (index in size..-1) return null

    val itemSize = (if (containerWidth > 0) containerWidth / size else null) ?: return null
    val itemPadding = (if (itemSize > 0) itemSize / 4 else null) ?: return null

    return DiscoverButtonPanelParamsModel(
        padding = itemPadding,
        itemSize = itemSize,
        icon = iconParam.icon,
        durationMillis = iconParam.durationMillis,
    )
}

private fun getDiscoverButtonContainerWidth(
    screenSize: ScreenSize,
    padding: Float,
    buttonQuantity: Int,
    minButtonSize: Int = 100
): Int? {
    if (buttonQuantity <= 0) return null
    val screenWidth = screenSize.width
    val screenWidthWithPadding = getPercentageOff(screenWidth, padding)
    val minScreenWidth = minButtonSize * buttonQuantity

    return when {
        screenWidthWithPadding > minScreenWidth * 2 -> minScreenWidth * 2
        minScreenWidth < screenWidthWithPadding -> screenWidthWithPadding
        else -> null
    }
}
