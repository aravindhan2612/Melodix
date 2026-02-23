package com.ab.melodix.core.ui.theme

import android.view.Surface
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val primary: Color,
    val secondary: Color,
    val background: Color,
    val surface: Color,
    val onSurface: Color,
    val inverseSurface: Color,
    val bodyText: Color
)

val LightCustomColors = CustomColors(
    primary = Color(0xFF313D96),
    secondary = Color(0xFF5A61A4),
    background = Color(0xFFF3F4F9),
    surface = Color(0xFFFEFBFF),
    onSurface = Color.Gray,
    inverseSurface =Color(0xFF121212),
    bodyText = Color(0xFF121212)
)

val DarkCustomColors = CustomColors(
    primary = Color(0xFF313F9B),
    secondary = Color(0xFF4B57AD),
    surface = Color(0xFF1E1E2E),
    background = Color(0xFF121212),
    onSurface = Color.Gray,
    inverseSurface = Color(0xFFFEFBFF),
    bodyText = Color(0xFF94A3B8)

)
val TertiaryDark = Color(0xFF2D8C7D)

val TertiaryLight = Color(0xFF2D8C7D)