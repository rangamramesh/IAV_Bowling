package com.iav.bowling.view.game

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
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
class BowlingGameActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val testRule = ActivityScenarioRule(BowlingGameActivity::class.java)

    @Test
    fun performExampleGame() {

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 0")))

        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_4)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 5")))

        Espresso.onView(withId(R.id.button_4)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 14")))

        Espresso.onView(withId(R.id.button_6)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_4)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 14")))

        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 29")))

        Espresso.onView(withId(R.id.button_10)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 49")))

        Espresso.onView(withId(R.id.button_0)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 61")))

        Espresso.onView(withId(R.id.button_7)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_3)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 61")))

        Espresso.onView(withId(R.id.button_6)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_4)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 77")))

        Espresso.onView(withId(R.id.button_10)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 97")))

        Espresso.onView(withId(R.id.button_2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_8)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_6)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 133")))

    }

    @Test
    fun performAllStrikeGame() {
        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 0")))

        repeat(12) {
            Espresso.onView(withId(R.id.button_10)).perform(ViewActions.click())
        }

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 300")))

    }

    @Test
    fun performGameRestart() {
        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 0")))

        repeat(12) {
            Espresso.onView(withId(R.id.button_10)).perform(ViewActions.click())
        }

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 300")))

        Espresso.onView(withId(R.id.button_restart)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.text_game_score))
            .check(ViewAssertions.matches(ViewMatchers.withText("Score: 0")))
    }
}

