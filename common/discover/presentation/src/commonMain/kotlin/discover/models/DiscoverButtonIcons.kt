package discover.models

import androidx.compose.ui.graphics.Color
import compose.theme.ColorRes
import discover.models.DiscoverButtonAnimationTypes.Pulsating
import discover.models.DiscoverButtonAnimationTypes.Rotation
import utils.ImageRes.IC_COMMUNITY_SVG
import utils.ImageRes.IC_ENABLER_SVG
import utils.ImageRes.IC_L4E_SPLASH_SVG
import utils.ImageRes.IC_PROBLEM_SVG
import utils.ImageRes.IC_SOLUTION_SVG

enum class DiscoverButtonIcons(
    val title: String,
    val iconSrc: String,
    val animation: DiscoverButtonAnimationTypes,
    val color: Color,
) {
    Problems(
        "Problems",
        IC_PROBLEM_SVG,
        Pulsating,
        ColorRes.problemColor.copy(alpha = 0.25f)
    ),
    Solutions(
        "Solutions",
        IC_SOLUTION_SVG,
        Pulsating,
        ColorRes.solutionColor.copy(alpha = 0.25f)
    ),
    Projects("Projects", IC_L4E_SPLASH_SVG, Rotation, Color.Transparent),
    Enablers(
        "Enablers",
        IC_ENABLER_SVG,
        Pulsating,
        ColorRes.enablerColor.copy(alpha = 0.25f)
    ),
    Communities(
        "Communities",
        IC_COMMUNITY_SVG,
        Pulsating,
        ColorRes.communityColor.copy(alpha = 0.25f)
    ),
}

enum class DiscoverButtonAnimationTypes {
    Pulsating, Rotation
}
