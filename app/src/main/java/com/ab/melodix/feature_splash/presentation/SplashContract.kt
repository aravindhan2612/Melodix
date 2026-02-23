package com.ab.melodix.feature_splash.presentation

data class SplashState(
    val isLoading: Boolean = true,
    val progress: Float = 0f,
    val statusMessage: String = "SYNCING LIBRARY",
    val version: String = "VERSION 2.0.4-BUILD",
    val isSyncCompleted: Boolean = false
)

sealed class SplashIntent {
    object StartSync : SplashIntent()
}

sealed class SplashEffect {
    object NavigateToMain : SplashEffect()
}
