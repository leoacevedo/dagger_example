package com.daggersample.app.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daggersample.app.R
import com.daggersample.lib.Preferences
import com.daggersample.lib.other.OtherActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {
    @Inject
    lateinit var baseUrl: String

    @Inject
    lateinit var preferences: Preferences

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this, MainModel(preferences, baseUrl))
    }

    override fun setDarkMode(darkMode: Boolean) {
        val theme = if (darkMode) {
            R.style.ThemeOverlay_AppCompat_Dark
        } else {
            R.style.ThemeOverlay_AppCompat_Light
        }
        setTheme(theme)
    }

    override fun setUrlMessage(url: String) {
        message.text = getString(R.string.this_is_the_base_url, baseUrl)
    }

    override fun enableEvents() {
        darkModeSw.setOnCheckedChangeListener { _, checked ->
            presenter.onDarkModeChanged(checked)
        }
        navigateAwayBtn.setOnClickListener {
            presenter.onNavigateAway()
        }
    }

    override fun turnSwitchOn(on: Boolean) {
        darkModeSw.isChecked = on
    }

    override fun draw() {
        setContentView(R.layout.activity_main)
    }

    override fun redraw() {
        recreate()
    }

    override fun navigateAway() {
        startActivity(Intent(this, OtherActivity::class.java))
    }
}
