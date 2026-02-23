package com.ab.melodix.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalCustomColors = staticCompositionLocalOf { LightCustomColors }
private val LocalCustomTypography = staticCompositionLocalOf { AppTypography }

@Composable
fun MelodixTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkCustomColors
        else -> LightCustomColors
    }
    val typography = AppTypography

    CompositionLocalProvider(
        LocalCustomColors provides colorScheme,
        LocalCustomTypography provides typography,
        content = content
    )
}

object MelodixThemeValues {
    val colorScheme: CustomColors
        @Composable get() = LocalCustomColors.current

    val typography: CustomTypography
        @Composable get() = LocalCustomTypography.current
}