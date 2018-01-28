package de.deftone.bitsandpizzas.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.test.espresso.action.ViewActions;
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

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.LayoutAssertions.noOverlaps;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_ID;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_TYPE;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.PREFS_DATES;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.PREFS_POINTS;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_STRETCHING_EXERCISES;
import static de.deftone.bitsandpizzas.data.LegExercise.LEG_EXERCISES;
import static de.deftone.bitsandpizzas.data.StretchingExercise.STRETCHING_EXERCISES;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by deftone on 25.12.17.
 */

@RunWith(AndroidJUnit4.class)
public class ExerciseDetailActivityTest {

    private ExerciseDetailActivity exerciseDetailActivity;

    //damit wir in jedem test einen anderen intent aufrufen koennen, kommt dieser NICHT in die testrule
    @Rule
    public ActivityTestRule<ExerciseDetailActivity> mActivityRule =
            new ActivityTestRule<>(ExerciseDetailActivity.class, true, false);


    @Test
    public void checkLayout() {
        int position = 0;
        startIntent(position, TYPE_LEG_EXERCISES);

        //check title
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
        startIntent(position, TYPE_LEG_EXERCISES);

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
        startIntent(position, TYPE_STRETCHING_EXERCISES);

        //check fab is displayed
        onView(withId(R.id.fab)).check(MatchUtils.isVisible());

        //click fab
        onView(withId(R.id.fab)).perform(click());

        //check time
        int seconds = STRETCHING_EXERCISES[position].getSeconds();
        String time = String.format(Locale.getDefault(), "%02d:%02d", 0, seconds);
        onView(withId(R.id.time_view)).check(matches(withText(time)));
    }


    @Test
    public void clickButtonCheckPoints() throws InterruptedException {
//        //so koennte man auf die shared preferences zugreifen, wenn man sie vorm (!) intent starten aufruft
//        //aber nur die default, nicht die speziellen mit namen...
//        Context context = getInstrumentation().getTargetContext();
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        int position = 0;
        startIntent(position, TYPE_LEG_EXERCISES);

        //reset shared preferences -das hier so erst, nachdem der intent gestartet wurde
        SharedPreferences sharedPreferencesDates = mActivityRule.getActivity().getSharedPreferences(PREFS_DATES, 0);
        SharedPreferences.Editor sharedPreferencesDatesEditor = sharedPreferencesDates.edit();
        sharedPreferencesDatesEditor.clear().apply();

        SharedPreferences sharedPreferencesPoints = mActivityRule.getActivity().getSharedPreferences(PREFS_POINTS, 0);
        SharedPreferences.Editor sharedPreferencesPointsEditor = sharedPreferencesPoints.edit();
        sharedPreferencesPointsEditor.clear().apply();


        //klicken funktioniert nicht wenn der button nicht zu sehen ist
        //auf scrollview funktioniert onView(withText("xx")).perform(ViewActions.scrollTo())
        //-aber nicht wenn xx in einer nested scrollview im coordin. layout ist, hier swipen (das funktioniert auch bei recyclerview)
        onView(withId(R.id.detail_scrollview)).perform(ViewActions.swipeUp());
        onView(withId(R.id.weight_button)).perform(click());
        //check toast is visible
        int[] points = LEG_EXERCISES[position].getWeight();
        String toastText = mActivityRule.getActivity().getString(R.string.points_today_1) + points[0]
                + mActivityRule.getActivity().getString(R.string.points_today_2);
        onView(withText(toastText))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    private void startIntent(int position, String Type) {
        Context targetContext = getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, ExerciseDetailActivity.class);
        intent.putExtra(EXTRA_EXERCISE_TYPE, Type);
        intent.putExtra(EXTRA_EXERCISE_ID, position);
        mActivityRule.launchActivity(intent);
    }
}