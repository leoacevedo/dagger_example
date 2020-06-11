package com.daggersample.lib

import android.content.SharedPreferences

class Preferences(private val sharedPrefs: SharedPreferences) {

    operator fun get(key: String): String? = sharedPrefs.getString(key, null)

    operator fun set(key: String, value: String?) {
        sharedPrefs.edit().putString(key, value).apply()
    }
}
