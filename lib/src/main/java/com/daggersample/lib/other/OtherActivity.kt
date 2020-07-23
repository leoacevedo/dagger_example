package com.daggersample.lib.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daggersample.lib.Preferences
import com.daggersample.lib.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OtherActivity : AppCompatActivity() {
    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (preferences["theme"] == "dark") {
            setTheme(R.style.ThemeOverlay_AppCompat_Dark)
        } else {
            setTheme(R.style.ThemeOverlay_AppCompat_Light)
        }

        setContentView(R.layout.activity_other)
    }
}
