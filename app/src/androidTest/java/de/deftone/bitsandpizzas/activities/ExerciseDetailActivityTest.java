package de.deftone.bitsandpizzas.activities;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import de.deftone.bitsandpizzas.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_ID;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_TYPE;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_STRETCHING_EXERCISES;

import static de.deftone.bitsandpizzas.data.StretchingExercise.STRETCHING_EXERCISES;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by deftone on 25.12.17.
 */
@RunWith(AndroidJUnit4.class)
public class ExerciseDetailActivityTest {

    private int position = 0;

    @Rule
    public ActivityTestRule<ExerciseDetailActivity> mActivityRule =
            new ActivityTestRule<ExerciseDetailActivity>(ExerciseDetailActivity.class) {
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation()
                            .getTargetContext();
                    Intent result = new Intent(targetContext, ExerciseDetailActivity.class);
                    result.putExtra(EXTRA_EXERCISE_TYPE, TYPE_STRETCHING_EXERCISES);
                    result.putExtra(EXTRA_EXERCISE_ID, position);
                    return result;
                }
            };


    @Test
    public void checkLayout() {
        //titleInToolbar
        //das hier ist leider falsch, denn der titel ist nicht in der toolbar,
//        onView(withId(R.id.toolbar_detail)).check(matches(withText(title)));
        //sondern in der AppCompatTextView, hier den selben trick anwenden wie in pluralsight video
        //gucken wer es assignet und welcher parent um eindeutig zu machen
        onView(allOf(withParent(isAssignableFrom(Toolbar.class)),
                isAssignableFrom(AppCompatTextView.class)))
                .check(matches(withText(STRETCHING_EXERCISES[position].getName())));

        //detailImageIsVisible
        onView(withId(R.id.image_detail)).check(matches(isDisplayed()));

        //imageAboveDescription
        onView(withId(R.id.image_detail)).check(isAbove(withId(R.id.list_detail)));

        //das hier schlaegt jetzt fehl, da der FAB ueber der listview
//        onView(withId(R.id.detail_activity_layout)).check(noOverlaps());
    }

    @Test
    public void startTimer() {
        //check fab is displayed
        onView(withId(R.id.fab)).check(matches(isDisplayed()));
        //in case it is not: onView(withId(R.id.fab)).check(matches(not(isDisplayed())));

        //click fab
        onView(withId(R.id.fab)).perform(click());

        //check
        int seconds = STRETCHING_EXERCISES[position].getSeconds();
        String time = String.format(Locale.getDefault(), "%02d:%02d", 0, seconds);
        onView(withId(R.id.time_view)).check(matches(withText(time)));
    }
}