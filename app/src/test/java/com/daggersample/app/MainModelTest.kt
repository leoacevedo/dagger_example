package com.daggersample.app

import com.daggersample.app.main.MainModel
import com.daggersample.lib.Preferences
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class MainModelTest {
    private val url = "https://localhost.org"

    @MockK
    private lateinit var preferences: Preferences

    private lateinit var model: MainModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        model = MainModel(preferences, url)
    }

    @Test
    fun `should say darkMode is true if preferences say so`() {
        // Given
        every { preferences[MainModel.PREF_THEME] } returns MainModel.THEME_DARK

        // Then
        assertTrue(model.darkMode)
    }

    @Test
    fun `should say darkMode is false if preferences say so`() {
        // Given
        every { preferences[MainModel.PREF_THEME] } returns MainModel.THEME_LIGHT

        // Then
        assertFalse(model.darkMode)
    }
}
