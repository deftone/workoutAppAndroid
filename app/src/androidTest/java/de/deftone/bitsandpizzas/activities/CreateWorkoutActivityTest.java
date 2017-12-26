package de.deftone.bitsandpizzas.activities;

import android.support.annotation.NonNull;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.testUtils.MatchUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.internal.deps.guava.base.Preconditions.checkNotNull;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by deftone on 26.12.17.
 */
public class CreateWorkoutActivityTest {

    //we need this, so that the app is launched before the tests start - otherwise all will fail
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void createButtonClick() {
        onView(withId(R.id.action_create_workout)).perform(click());

        //check if first card view has the correct title
        String title = "Kniebeuge im Ausfallschritt";
        onView(withId(R.id.exercise_recycler)).check(matches(MatchUtils.eigenerMatcher(0, hasDescendant(withText(title)))));
    }


    @Test
    public void createExerciseAndGoBackAgain() {
        onView(withId(R.id.action_create_workout)).perform(click());
        pressBack();
        //check that we are back in the topfragment
        onView(withId(R.id.top_fragment_title)).check(matches(withText(R.string.workout_motherRussia)));
    }

    @Test
    public void goInDetailAndBackAgain(){
        onView(withId(R.id.action_create_workout)).perform(click());
        onView(withId(R.id.exercise_recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        pressBack();
        //check that the list is visible again, i.e. the first view card has the correct title
        String title = "Kniebeuge im Ausfallschritt";
        onView(withId(R.id.exercise_recycler)).check(matches(MatchUtils.eigenerMatcher(0, hasDescendant(withText(title)))));
    }
}