package de.deftone.bitsandpizzas.activities;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.deftone.bitsandpizzas.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by deftone on 25.12.17.
 */
@RunWith(AndroidJUnit4.class)
public class ExerciseDetailActivityIntent {

    private int position = 0;

    //for intents ("intended", s.u.), we need an IntentRule here... but the intent is the mainAcitivity! otherwise it crashes
    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void exerciseDetailIntentIsOpend() {
        //open detail acitivity
        Matcher<View> matcher = allOf(withText(R.string.stretching_tab),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        //click on first card view
        onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));

        //check if detail activity opens
        intended(hasComponent(ExerciseDetailActivity.class.getName()));
        //go back to main activity
        pressBack();
    }
}

