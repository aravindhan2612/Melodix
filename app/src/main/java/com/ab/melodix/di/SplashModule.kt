package com.ab.melodix.di

import android.content.Context
import com.ab.melodix.feature_splash.data.SplashDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SplashModule {

    @Provides
    @Singleton
    fun provideSplashDataStore(@ApplicationContext context: Context): SplashDataStore {
        return SplashDataStore(context)
    }
}
