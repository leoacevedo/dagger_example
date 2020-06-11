package com.daggersample.app.di

import com.daggersample.app.main.MainActivity
import com.daggersample.lib.di.LibViewInjectorsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [LibViewInjectorsModule::class])
abstract class ViewInjectorsModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity
}
    
