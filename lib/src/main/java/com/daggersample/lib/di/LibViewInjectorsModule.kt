package com.daggersample.lib.di

import com.daggersample.lib.other.OtherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LibViewInjectorsModule {
    @ContributesAndroidInjector
    abstract fun contributeOtherActivityInjector(): OtherActivity
}
