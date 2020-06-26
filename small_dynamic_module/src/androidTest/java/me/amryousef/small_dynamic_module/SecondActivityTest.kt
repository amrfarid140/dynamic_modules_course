package me.amryousef.small_dynamic_module

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class SecondActivityTest {
    @get:Rule
    var activityRule: ActivityTestRule<SecondActivity> =
        ActivityTestRule(SecondActivity::class.java)

    @Test
    fun buttonIsVisible() {
        onView(withId(R.id.finish_activity))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }
}