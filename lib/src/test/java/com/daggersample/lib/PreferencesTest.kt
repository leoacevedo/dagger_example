package com.daggersample.lib

import android.content.SharedPreferences
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PreferencesTest {
    private val KEY = "key"
    private val VALUE = "adsadf"

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var preferences: Preferences

    @Before
    fun setUp() {
        // Make sharedPrefs remember stuff
        val valueSlot = slot<String>()
        sharedPreferences = mockk {
            every { edit().putString(KEY, capture(valueSlot)) } returns mockk(relaxed = true)
            every { getString(KEY, null) } answers {
                valueSlot.captured
            }
        }
        preferences = Preferences(sharedPreferences)
    }

    @Test
    fun `it should not forget stuff`() {
        // Given
        preferences[KEY] = VALUE

        // Then
        assertEquals(VALUE, preferences[KEY])
    }
}
