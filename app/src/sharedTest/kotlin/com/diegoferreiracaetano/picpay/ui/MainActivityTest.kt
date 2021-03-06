package com.diegoferreiracaetano.picpay.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.diegoferreiracaetano.picpay.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Test
    fun useAppContext() {
        runBlocking(Dispatchers.Main) {
            scenario = launch(MainActivity::class.java)

            scenario.recreate()

            onView(withId(R.id.nav_host_fragment)).check(matches(isDisplayed()))
        }
    }
}
