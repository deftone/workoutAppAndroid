package de.deftone.bitsandpizzas.activities;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.data.LegExercise;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.LayoutAssertions.noOverlaps;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by deftone on 25.12.17.
 */
@RunWith(AndroidJUnit4.class)
public class ExerciseDetailActivityTest {

    private int position = 0;

    //for intents ("intended", s.u.), we need an IntentRule here... but the intent is the mainAcitivity! otherwise it crashes
    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    //wie in MainAcitivyTest beschrieben: in der Rule befindet sich @Before und @After (nur @Before/AfterClass wuerde ausserhalb stehen)
    @Before
    public void setUp() {
        //open detail acitivity
        //click on tab "Beine"
        Matcher<View> matcher = allOf(withText("Beine"),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        //click on first card view
        onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));
    }

    @Test
    public void exerciseDetailIntentIsOpend() {
        //check if detail activity opens
        intended(hasComponent(ExerciseDetailActivity.class.getName()));
    }

    @Test
    public void titleInToolbar() {
        //das hier ist leider falsch, denn der titel ist nicht in der toolbar,
//        onView(withId(R.id.toolbar_detail)).check(matches(withText(title)));
        //sondern in der AppCompatTextView, hier den selben trick anwenden wie in pluralsight video
        //gucken wer es assignet und welcher parent um eindeutig zu machen
        onView(allOf(withParent(isAssignableFrom(Toolbar.class)),
                isAssignableFrom(AppCompatTextView.class)))
                .check(matches(withText(LegExercise.LEG_EXERCISES[position].getName())));
    }

    @Test
    public void detailImageIsVisible() {
        onView(withId(R.id.image_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void imageAboveDescription() {
        onView(withId(R.id.image_detail)).check(isAbove(withId(R.id.list_detail)));
    }

    @Test
    public void noOverlapsTest() {
        onView(withId(R.id.detail_activity_layout)).check(noOverlaps());
    }

    @Test
    public void fab_notVisible(){
        //this tests assumes that the exercise has no seconds
        onView(withId(R.id.fab)).check(matches(not(isDisplayed())));
    }

    //todo: testen, dass auch die listview mit icons und text richtig befuellt ist, aber das ist wahrscheinlich kompliziert..
}