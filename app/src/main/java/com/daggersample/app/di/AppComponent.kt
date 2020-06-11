package com.daggersample.app.di

import android.content.Context
import com.daggersample.app.main.MainActivity
import com.daggersample.lib.di.LibModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, LibModule::class])
interface AppComponent {
    fun inject(target: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance baseUrl: String
        ): AppComponent
    }
}
