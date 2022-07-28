package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * The type Ui test.
 */
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest

public class UITest {
    /**
     * The Activity rule.
     */
    @Rule
    public ActivityTestRule<MainActivity> activityRule=
            new ActivityTestRule<>(MainActivity.class);

    /**
     * Tests if opening the app lands on home screen
     */
    @Test
    public void testHome(){
        onView(withId(R.id.Homepage)).check(matches(isDisplayed()));
    }

    /**
     * Tests add button, adding new information, submit button
     */
    @Test
    public void testAdd(){
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.constraintLayout2)).check(matches(isDisplayed()));
        onView(withId(R.id.SP)).perform(ViewActions.typeText("81"));
        onView(withId(R.id.DP)).perform(ViewActions.typeText("71"));
        onView(withId(R.id.HeartRate)).perform(ViewActions.typeText("91"));
        onView(withId(R.id.editDate)).perform(ViewActions.typeText("02-02-2019"));
        Espresso.pressBack();
        onView(withId(R.id.editTime)).perform(ViewActions.typeText("5:40"));
        Espresso.pressBack();
        onView(withId(R.id.Comment)).perform(ViewActions.typeText("After football"));
        Espresso.pressBack();
        onView(withId(R.id.enter_btn)).perform(click());
        onView(withId(R.id.Homepage)).check(matches(isDisplayed()));
    }

}
