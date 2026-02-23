package com.ab.melodix.feature_splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.melodix.feature_splash.data.SplashDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dataStore: SplashDataStore
) : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<SplashEffect>()
    val effect = _effect.asSharedFlow()

    init {
        handleIntent(SplashIntent.StartSync)
    }

    fun handleIntent(intent: SplashIntent) {
        when (intent) {
            is SplashIntent.StartSync -> startSyncProgress()
        }
    }

    private fun startSyncProgress() {
        viewModelScope.launch {
            // Mocking sync progress
            for (i in 1..100) {
                delay(30)
                _state.update { it.copy(progress = i / 100f) }
            }
            
            _state.update { it.copy(isSyncCompleted = true) }
            dataStore.saveAppVersion(_state.value.version)
            
            _effect.emit(SplashEffect.NavigateToMain)
        }
    }
}
