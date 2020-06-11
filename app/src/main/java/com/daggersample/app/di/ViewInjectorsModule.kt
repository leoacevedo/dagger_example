package com.daggersample.app.di

import com.daggersample.app.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewInjectorsModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity
}
