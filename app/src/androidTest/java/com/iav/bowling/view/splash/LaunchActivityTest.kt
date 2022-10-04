package com.iav.bowling.view.splash

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.iav.bowling.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ramesh on 10/3/22.
 */


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class LaunchActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val testRule = ActivityScenarioRule(LaunchActivity::class.java)


    @Test
    fun testAllViewVisibility() {
        Espresso.onView(ViewMatchers.withId(R.id.launch_screen_icon))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.app_name))
            .check(ViewAssertions.matches(ViewMatchers.withText("Bowling")))
    }

}
