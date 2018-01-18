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
import de.deftone.bitsandpizzas.data.Icons;
import de.deftone.bitsandpizzas.testUtils.MatchUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.LayoutAssertions.noOverlaps;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_ID;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_TYPE;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_STRETCHING_EXERCISES;
import static de.deftone.bitsandpizzas.data.LegExercise.LEG_EXERCISES;
import static de.deftone.bitsandpizzas.data.StretchingExercise.STRETCHING_EXERCISES;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by deftone on 25.12.17.
 */

//todo: button klicken testen (farbe aendert sich, toast? punkte in den shared prefs)

@RunWith(AndroidJUnit4.class)
public class ExerciseDetailActivityTest {

    //damit wir in jedem test einen anderen intent aufrufen koennen, kommt dieser NICHT in die testrule
    @Rule
    public ActivityTestRule<ExerciseDetailActivity> mActivityRule =
            new ActivityTestRule<>(ExerciseDetailActivity.class, true, false);

    @Test
    public void checkLayout() {
        int position = 0;
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, ExerciseDetailActivity.class);
        intent.putExtra(EXTRA_EXERCISE_TYPE, TYPE_LEG_EXERCISES);
        intent.putExtra(EXTRA_EXERCISE_ID, position);
        mActivityRule.launchActivity(intent);

        /* Your activity is initialized and ready to go. */
        onView(allOf(withParent(isAssignableFrom(Toolbar.class)),
                isAssignableFrom(AppCompatTextView.class)))
                .check(matches(withText(LEG_EXERCISES[position].getName())));

        //detailImageIsVisible
        onView(withId(R.id.image_detail)).check(MatchUtils.isVisible());

        //imageAboveDescription
        onView(withId(R.id.image_detail)).check(isAbove(withId(R.id.list_detail)));

        //fab not visible //hier funktioniert die pruefung
        onView(withId(R.id.fab)).check(MatchUtils.isGone());

        //kann man auf den button klicken, auch wenn er GONE ist?
        //  onView(withId(R.id.fab)).perform(click());
        //nein, kann man nicht: .PerformException: Error performing 'single click' on view 'with id: de.deftone.bitsandpizzas:id/fab'

        //ohne fab funktioniert das: no overlaps
        onView(withId(R.id.detail_activity_layout)).check(noOverlaps());

        //man sieht die buttons nicht, der test sollte fehlschlagen?? nach unten scrollen?
        //check 3 buttons with correct points are visible
        int[] points = LEG_EXERCISES[position].getWeight();
        String point_text = "1x" + points[0] + Icons.getIcon(Icons.MUSCLE);
        onView(withId(R.id.weight_button)).check(matches(withText(point_text)));
        point_text = "2x" + points[0] + Icons.getIcon(Icons.MUSCLE);
        onView(withId(R.id.weight_button_2)).check(matches(withText(point_text)));
        point_text = "3x" + points[0] + Icons.getIcon(Icons.MUSCLE);
        onView(withId(R.id.weight_button_3)).check(matches(withText(point_text)));

        //the alternative buttons are invisible  -because the table row is GONE
        onView(withId(R.id.second_row)).check(MatchUtils.isGone());
    }

    @Test
    public void checkLayout_alternativeButtons() {
        int position = 2;
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, ExerciseDetailActivity.class);
        intent.putExtra(EXTRA_EXERCISE_TYPE, TYPE_LEG_EXERCISES);
        intent.putExtra(EXTRA_EXERCISE_ID, position);
        mActivityRule.launchActivity(intent);

        //man sieht die buttons nicht, der test sollte fehlschlagen?? nach unten scrollen?
        //check 3 buttons with correct points are visible
        int[] points = LEG_EXERCISES[position].getWeight();
        String point_text = "1x" + points[1] + Icons.getIcon(Icons.SPARKLES);
        onView(withId(R.id.weight_button_alternative)).check(matches(withText(point_text)));
        point_text = "2x" + points[1] + Icons.getIcon(Icons.SPARKLES);
        onView(withId(R.id.weight_button_alternative_2)).check(matches(withText(point_text)));
        point_text = "3x" + points[1] + Icons.getIcon(Icons.SPARKLES);
        onView(withId(R.id.weight_button_alternative_3)).check(matches(withText(point_text)));

        //the alternative buttons are invisible  -because the table row is GONE
        onView(withId(R.id.second_row)).check(MatchUtils.isVisible());
    }

    @Test
    public void openTimerActivityAndCheck() {
        int position = 0;
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, ExerciseDetailActivity.class);
        intent.putExtra(EXTRA_EXERCISE_TYPE, TYPE_STRETCHING_EXERCISES);
        intent.putExtra(EXTRA_EXERCISE_ID, position);
        mActivityRule.launchActivity(intent);

        //check fab is displayed
        onView(withId(R.id.fab)).check(MatchUtils.isVisible());

        //click fab
        onView(withId(R.id.fab)).perform(click());

        //check time
        int seconds = STRETCHING_EXERCISES[position].getSeconds();
        String time = String.format(Locale.getDefault(), "%02d:%02d", 0, seconds);
        onView(withId(R.id.time_view)).check(matches(withText(time)));
    }
}