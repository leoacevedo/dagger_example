package com.daggersample.app

import android.app.Application
import com.daggersample.app.di.AppComponent
import com.daggersample.app.di.DaggerAppComponent

class App : Application() {

    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        configureDagger()
    }

    private fun configureDagger() {
        component = DaggerAppComponent.factory()
            .create(
                context = this,
                baseUrl = "https://localhost.com"
            )
    }
}
