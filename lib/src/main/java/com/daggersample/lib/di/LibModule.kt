package com.daggersample.lib.di

import android.content.SharedPreferences
import com.daggersample.lib.Preferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LibModule {
    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return Preferences(sharedPreferences)
    }
}
