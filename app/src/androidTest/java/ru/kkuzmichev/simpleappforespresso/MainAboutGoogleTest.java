package ru.kkuzmichev.simpleappforespresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

// @LargeTest
@RunWith(AndroidJUnit4.class)
public class MainAboutGoogleTest {

    @Rule
    public IntentsTestRule intentsTestRule =
            new IntentsTestRule(MainActivity.class);


    @Test
    public void mainAboutGoogleTest() {
        ViewInteraction imageView = onView(
                allOf(
                        withParent(withParent(withId(R.id.toolbar)))));
        imageView.check(matches(isDisplayed()));
        imageView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(androidx.recyclerview.R.id.title),
                        // withParent(withParent(withId(androidx.appcompat.R.id.content)))), почему здесь не принимается R.id. ?
                        withText("Settings"),
                                isDisplayed()));
        textView.check(matches(isDisplayed()));

        textView.perform(click());
        intended(hasData("https://www.google.com")); // почему здесь красно "intended(hasData"? требует создать private void intended(Object hasData) {}, я создала и опять красно
        intended(hasAction(Intent.ACTION_VIEW)); // почему здесь красно "intended(hasAction"? требует создать private void intended(Object hasAction) {}, я создала и опять красно


        /*ViewInteraction editText = onView(
                allOf(withId(com.android.chrome.R.id.url_bar), withText("https://www.google.com"),
                        withParent(allOf(withId(com.android.chrome.R.id.location_bar),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        editText.check(matches(withText("https://www.google.com")));*/


    private Object hasAction(String actionView) {
    }

    private void intended(Object hasData);

    private Object hasData(String s) {
    }

    /*private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        /*return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }*/

            /*@Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }/*
        };*/
    }
}
