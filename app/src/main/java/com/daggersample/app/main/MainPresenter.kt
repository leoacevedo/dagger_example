package com.daggersample.app.main

class MainPresenter(private val view: MainView, private val model: MainModel) {
    init {
        with(view) {
            setDarkMode(model.darkMode)
            draw()
            turnSwitchOn(model.darkMode)
            enableSwitch()
            setUrlMessage(model.baseUrl)
        }
    }

    fun onDarkModeChanged(darkMode: Boolean) {
        model.darkMode = darkMode
        view.setDarkMode(darkMode)
        view.redraw()
    }
}
