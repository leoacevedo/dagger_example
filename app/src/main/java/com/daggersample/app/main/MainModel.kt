package com.daggersample.app.main

import com.daggersample.lib.Preferences

class MainModel(private val preferences: Preferences, val baseUrl: String) {
    var darkMode: Boolean
        get() = preferences[PREF_THEME] == THEME_DARK
        set(value) {
            preferences[PREF_THEME] = if (value) {
                THEME_DARK
            } else {
                THEME_LIGHT
            }
        }

    private companion object {
        const val PREF_THEME = "theme"
        const val THEME_DARK = "dark"
        const val THEME_LIGHT = "light"
    }
}
