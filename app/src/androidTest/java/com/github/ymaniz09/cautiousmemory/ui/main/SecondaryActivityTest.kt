package com.github.ymaniz09.cautiousmemory.ui.main

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.github.ymaniz09.cautiousmemory.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest {

    /**
     * ActivityScenarioRule:
     * https://developer.android.com/reference/androidx/test/ext/junit/rules/ActivityScenarioRule.html
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun testActivity_inView() {
        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))

        // Notice this does not effect the next test
        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    @Test
    fun test_visibility_title_and_backButton() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(isDisplayed()))

        onView(withId(R.id.button_back))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTitleTextDisplayed() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(ViewMatchers.withText(R.string.text_secondary_activity)))
    }
}