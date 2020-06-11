package com.daggersample.app.main

interface MainView {
    fun setDarkMode(darkMode: Boolean)
    fun setUrlMessage(url: String)
    fun enableSwitch()
    fun turnSwitchOn(on: Boolean)
    fun draw()
    fun redraw()
}
