package com.diegoferreiracaetano.picpay
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import com.diegoferreiracaetano.contacts.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun whenInitScreen() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.nav_host_fragment)).check(matches(isDisplayed()))
    }
}