package com.daggersample.app.di

import android.content.Context
import com.daggersample.app.App
import com.daggersample.lib.di.LibModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, LibModule::class, ViewInjectorsModule::class, AndroidInjectionModule::class])
interface AppComponent {
    fun inject(target: App)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance baseUrl: String
        ): AppComponent
    }
}
