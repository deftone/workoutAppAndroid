package de.deftone.bitsandpizzas.activities;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;

import de.deftone.bitsandpizzas.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

/**
 * Created by deftone on 25.12.17.
 */
public class ShareActivityTest {

    //for intents, we need an IntentRule here... but the intent is the mainAcitivity! otherwise it crashes
    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);


    //dieser test funktioniert noch nicht so ganz... mit espresso aufgenommen...
    @Test
    public void shareIntentIsOpend() {
        //click on share action button
        ViewInteraction frameLayout = onView(
                Matchers.allOf(withId(R.id.expand_activities_button),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.activity_chooser_view_content),
                                        childAtPosition(
                                                withClassName(is("android.support.v7.widget.ActivityChooserView")),
                                                0)),
                                0),
                        isDisplayed()));
        frameLayout.perform(click());

        //click on "show all" (at position 3) - das ist nicht robust! besser nach titel statt position suchen!
        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withContentDescription("Choose an app"),
                        childAtPosition(
                                withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                                0)))
                .atPosition(3);
        linearLayout.perform(click());

        //click on "Gmail" (at position 3) - das ist nicht robust! besser nach titel statt position suchen!
        DataInteraction linearLayout2 = onData(anything())
                .inAdapterView(allOf(withContentDescription("Choose an app"),
                        childAtPosition(
                                withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                                0)))
                .atPosition(3);
        linearLayout2.perform(click());

        //check shared text
        ViewInteraction view = onView(
                allOf(withContentDescription(R.string.action_share),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.webkit.WebView.class),
                                        0),
                                0),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        //go back - besser close gmail app
    }

    //eigener matcher
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}