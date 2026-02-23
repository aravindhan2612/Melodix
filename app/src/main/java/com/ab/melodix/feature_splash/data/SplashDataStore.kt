package com.ab.melodix.feature_splash.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "temp_data")

@Singleton
class SplashDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val VERSION_KEY = stringPreferencesKey("app_version")

    val appVersion: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[VERSION_KEY]
        }

    suspend fun saveAppVersion(version: String) {
        context.dataStore.edit { preferences ->
            preferences[VERSION_KEY] = version
        }
    }
}
