package compose.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = Life4EarthTypography(
    largeHeading = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        lineHeight = 58.sp
    ),
    mediumHeading = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 34.sp
    ),
    smallHeading = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),
    text = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),
    label = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 22.sp
    )
)
