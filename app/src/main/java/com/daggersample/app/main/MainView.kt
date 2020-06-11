package com.daggersample.app.main

interface MainView {
    fun setDarkMode(darkMode: Boolean)
    fun setUrlMessage(url: String)
    fun enableEvents()
    fun turnSwitchOn(on: Boolean)
    fun draw()
    fun redraw()
    fun navigateAway()
}
