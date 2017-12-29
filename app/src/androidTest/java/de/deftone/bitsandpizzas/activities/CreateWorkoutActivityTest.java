package de.deftone.bitsandpizzas.activities;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.testUtils.MatchUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by deftone on 26.12.17.
 */
@RunWith(AndroidJUnit4.class)
public class CreateWorkoutActivityTest {

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