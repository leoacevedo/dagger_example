package com.daggersample.lib.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daggersample.lib.Preferences
import com.daggersample.lib.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class OtherActivity : AppCompatActivity() {
    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        if (preferences["theme"] == "dark") {
            setTheme(R.style.ThemeOverlay_AppCompat_Dark)
        } else {
            setTheme(R.style.ThemeOverlay_AppCompat_Light)
        }

        setContentView(R.layout.activity_other)
    }
}
