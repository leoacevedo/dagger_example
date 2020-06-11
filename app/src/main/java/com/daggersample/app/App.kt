package com.daggersample.app

import android.app.Application
import com.daggersample.app.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        configureDagger()
    }

    private fun configureDagger() {
        val component = DaggerAppComponent.factory()
            .create(
                context = this,
                baseUrl = "https://localhost.com"
            )
        component.inject(this)
    }

    override fun androidInjector() = injector
}
