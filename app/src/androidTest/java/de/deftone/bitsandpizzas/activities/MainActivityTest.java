package de.deftone.bitsandpizzas.activities;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.data.BellyExercise;
import de.deftone.bitsandpizzas.data.LegExercise;
import de.deftone.bitsandpizzas.data.StretchingExercise;
import de.deftone.bitsandpizzas.testUtils.MatchUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.not;

/**
 * Created by deftone on 26.12.17.
 */
@RunWith(AndroidJUnit4.class) //diese zeile sollte bei allen UI tests stehen
public class MainActivityTest {

    //ActivityTestRule -> starts Activity under test (not the app!), but the lifetime of the activity,
    //i.e. starts activity before (each) test and terminates activity after (each) test.
    //wenn zusaetzliche methoden nach dem starten bzw. vor beenden bei jedem test ausgefuehrt werden sollen,
    //so stehen diese auch mit @Before und @After in der ActivityTestRule.
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    //im test kann natuerlich dann eine andere activity gelaunched werden, aber mit dieser wird gestartet

    //es muss alles public sein, die testrule und auch alle testmethoden, sonst bumm!
    @Test
    public void toolbarIsDisplayed() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));

        //wenn die toolbar ein bild hat, dann kann man auch folgendes testen
//        onView(withId(R.id.toolbar_image)).check(matches(withContentDescription(R.string.toolbar_image_title)));
    }

    @Test
    public void viewPagerIsVisible() {
        onView(withId(R.id.viewpager)).check(matches(isDisplayed()));
    }

    //dieser test ist auch gruen, wenn die tab zeilen in mainactivity auskommentiert sind und man die tabs nicht sieht :(
    @Test
    public void tabsAreVisible() {
        onView(withId(R.id.tabs)).check(matches(isDisplayed()));
    }

    @Test
    public void titleInBanner() {
        onView(withId(R.id.top_fragment_title)).check(matches(withText(R.string.workout_motherRussia)));
    }

    @Test
    public void imageIsVisible() {
        onView(withId(R.id.main_image)).check(matches(isDisplayed()));
    }

    @Test
    public void check_visible_CardViewItems_leg() {
        Matcher<View> matcher = allOf(withText(R.string.beine_tab),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        //check if first 8 card view have the correct title
        //only 8 are visible without scrolling - this test will fail for position == 8
        String title;
        for (int position = 0; position < 8; position++) {
            title = LegExercise.LEG_EXERCISES[position].getName();
            //denn es werden immer 1-3 recyclerviews geladen, der aktuelle und der rechts bzw links davon, deshalb mit allOf und isDisplayed die richtige beutzen
            //achtung: wichtig! ich benutze eine viewgroup, daher muss withText mit hasDescendant gewrappt werden!!
            onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                    .check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
        }
    }


    @Test
    public void check_invisible_CardViewItems_leg() {
        Matcher<View> matcher = allOf(withText(R.string.beine_tab),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        String title;
        for (int position = 8; position < LegExercise.LEG_EXERCISES.length; position++) {
            title = LegExercise.LEG_EXERCISES[position].getName();
            //common pitfall... mind. 90% muss zu sehen sein...
            //deshalb scrollen
            onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                    .perform(RecyclerViewActions.scrollToPosition(position));
            //jetzt checken
            onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                    .check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
        }
    }

    @Test
    public void check_visible_CardViewItems_belly() {
        Matcher<View> matcher = allOf(withText(R.string.bauch_tab),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        //check if first 8 card view have the correct title
        //only 8 are visible without scrolling - this test will fail for position == 8
        String title;
        for (int position = 0; position < 8; position++) {
            title = BellyExercise.BELLY_EXERCISES[position].getName();
            //denn es werden immer 1-3 recyclerviews geladen, der aktuelle und der rechts bzw links davon, deshalb mit allOf und isDisplayed die richtige beutzen
            //achtung: wichtig! ich benutze eine viewgroup, daher muss withText mit hasDescendant gewrappt werden!!
            onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                    .check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
        }
    }


    @Test
    public void check_invisible_CardViewItems_belly() {
        Matcher<View> matcher = allOf(withText(R.string.bauch_tab),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        String title;
        for (int position = 8; position < BellyExercise.BELLY_EXERCISES.length; position++) {
            title = BellyExercise.BELLY_EXERCISES[position].getName();
            //common pitfall... mind. 90% muss zu sehen sein...
            //deshalb scrollen
            onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                    .perform(RecyclerViewActions.scrollToPosition(position));
            //jetzt checken
            onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                    .check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
        }
    }


    @Test
    public void openAndCloseNavigationDrawer() {
        //drawer content is not visible
        onView(withId(R.id.nav_view)).check(matches(not(isDisplayed())));
        //open nav drawer
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        //drawer content is visible
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()));
        //close nav drawer
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close());
        //drawer content is not visible
        onView(withId(R.id.nav_view)).check(matches(not(isDisplayed())));
    }

    @Test
    public void startTimer() {
        //click on tabs stretching
        Matcher<View> matcher = allOf(withText(R.string.stretching_tab),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        //click on first card view
        int position = 0;
        onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));

        //click fab
        onView(withId(R.id.fab)).perform(click());

        //check
        int seconds = StretchingExercise.STRETCHING_EXERCISES[position].getSeconds();
        String time = String.format(Locale.getDefault(), "%02d:%02d", 0, seconds);
        onView(withId(R.id.time_view)).check(matches(withText(time)));

    }
}