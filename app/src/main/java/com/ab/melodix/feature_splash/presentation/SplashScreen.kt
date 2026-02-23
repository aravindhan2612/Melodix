package com.ab.melodix.feature_splash.presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Headset
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ab.melodix.BuildConfig
import com.ab.melodix.core.ui.theme.MelodixTheme
import com.ab.melodix.core.ui.theme.MelodixThemeValues
import com.ab.melodix.feature_splash.presentation.components.Initializer

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToMain: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val effect by viewModel.effect.collectAsStateWithLifecycle(initialValue = null)

    LaunchedEffect(effect) {
        if (effect is SplashEffect.NavigateToMain) {
            onNavigateToMain()
        }
    }

    SplashScreenContent(state)
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SplashScreenContent(state: SplashState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MelodixThemeValues.colorScheme.background) // Dark background matching screenshot
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo Card
            Surface(
                modifier = Modifier.size(140.dp),
                shape = RoundedCornerShape(28.dp),
                color = MelodixThemeValues.colorScheme.secondary // Teal/Green background for logo
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "melodix",
                        color = Color.White,
                        style = MelodixThemeValues.typography.title
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Title
            Text(
                text = "Melodix",
                color = MelodixThemeValues.colorScheme.inverseSurface,
                style = MelodixThemeValues.typography.header,
                letterSpacing = 2.sp
            )

            // Tagline
            Text(
                text = "YOUR LOCAL SOUND",
                color = MelodixThemeValues.colorScheme.secondary, // Blueish tagline
                style = MelodixThemeValues.typography.body,
                letterSpacing = 4.sp
            )
        }

        // Bottom Section (Progress and Version)
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Access your music",
                color = MelodixThemeValues.colorScheme.inverseSurface,
                style = MelodixThemeValues.typography.title,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Melodix needs permission to access your\n" +
                        "device's internal storage to find and play\n" +
                        "your music files.",
                color = MelodixThemeValues.colorScheme.bodyText,
                style = MelodixThemeValues.typography.body,
                textAlign = TextAlign.Center
            )

//            Initializer(state.progress)

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "VERSION ${BuildConfig.VERSION_NAME}",
                color = MelodixThemeValues.colorScheme.onSurface,
                fontSize = 10.sp,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom Icons
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Headset,
                    contentDescription = null,
                    tint = MelodixThemeValues.colorScheme.inverseSurface,
                    modifier = Modifier.size(20.dp)
                )
                Icon(
                    imageVector = Icons.Default.BarChart,
                    contentDescription = null,
                    tint =MelodixThemeValues.colorScheme.inverseSurface,
                    modifier = Modifier.size(20.dp)
                )
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = MelodixThemeValues.colorScheme.inverseSurface,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Preview(
 showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SplashScreenPreview() {
    MelodixTheme {
        SplashScreenContent(
            state = SplashState(
                progress = 0.5f,
                version = "1.0.0"
            )
        )
    }
}
