package com.ab.melodix.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Immutable
data class CustomTypography(
    val header: TextStyle,
    val title: TextStyle,
    val body: TextStyle,
    val label: TextStyle
)

val AppTypography = CustomTypography(
    header = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Bold),
    title = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
    body = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
    label = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal)
)
