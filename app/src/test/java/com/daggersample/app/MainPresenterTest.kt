package com.daggersample.app

import com.daggersample.app.main.MainModel
import com.daggersample.app.main.MainPresenter
import com.daggersample.app.main.MainView
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private val view: MainView = mockk(relaxed = true)

    @MockK
    private lateinit var model: MainModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
    }

    @Test
    fun `should set dark mode before inflating`() {
        // Given
        every { model.darkMode } returns true

        // When
        val presenter = MainPresenter(view, model)

        // Then
        verify (exactly = 1) {
            view.setDarkMode(true)
            view.draw()
        }
    }
}
