package com.podolian.vamatestapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.podolian.vamatestapp.R

val SfProDisplay = FontFamily(
    Font(R.font.sf_pro_display, FontWeight.Normal),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_bold, FontWeight.Bold)
)

val SfProText = FontFamily(
    Font(R.font.sf_pro_text, FontWeight.Normal),
    Font(R.font.sf_pro_text_medium, FontWeight.Medium),
    Font(R.font.sf_pro_text_semibold, FontWeight.SemiBold)
)

val textStyle = TextStyle(
    fontFamily = SfProText,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    color = Gray100
)

val textStyle2 = TextStyle(
    fontFamily = SfProText,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    letterSpacing = (-0.64).sp,
    color = Color.White
)

val textStyle3 = TextStyle(
    fontFamily = SfProDisplay,
    fontWeight = FontWeight.Bold,
    fontSize = 34.sp,
    letterSpacing = (-1.36).sp,
    color = Dark
)

// Set of Material typography styles to start with
val Typography = Typography(
    h2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = (0.15).sp,
        lineHeight = 4.sp
    ),
    body1 = TextStyle(
        fontFamily = SfProText,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = (-0.72).sp,
        color = Gray200
    ),
    subtitle1 = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = (-0.64).sp,
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp,
        lineHeight = 6.sp,
        color = Dark
    ),
    button = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp,
        lineHeight = 2.sp,
        color = Color.White
    )
)