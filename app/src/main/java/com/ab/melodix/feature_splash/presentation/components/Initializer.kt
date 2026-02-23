package com.ab.melodix.feature_splash.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ab.melodix.core.ui.theme.MelodixThemeValues


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun Initializer(
    progress: Float,
) {
    Row(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "SYNCING LIBRARY",
            color = MelodixThemeValues.colorScheme.secondary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "PLEASE WAIT",
            color = MelodixThemeValues.colorScheme.onSurface,
            fontSize = 10.sp
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    LinearWavyProgressIndicator(
        progress = { progress},
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(6.dp),
        color = MelodixThemeValues.colorScheme.secondary,
        trackColor = MelodixThemeValues.colorScheme.background,
        wavelength = 16.dp
    )
}