package de.deftone.bitsandpizzas.activities;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.testUtils.MatchUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static de.deftone.bitsandpizzas.activities.MainActivity.ALL_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.bellyExercises;
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

    @Test //dieser Test ist auch gruen, wenn der entsprechende code auskommentiert ist und man weder toolbar, noch viewpager sehen kann...
    public void checkToolbarAndViewpager() {
        //toolbarIsDisplayed
        onView(withId(R.id.toolbar)).check(MatchUtils.isVisible()); //egal ob isVisible oder matches.isDisplayed()... verhaelt sich gleich
        //wenn die toolbar ein bild hat, dann kann man auch folgendes testen
        //onView(withId(R.id.toolbar_image)).check(matches(withContentDescription(R.string.toolbar_image_title)));
        //viewPagerIsVisible
        onView(withId(R.id.viewpager)).check(MatchUtils.isVisible());
        //tabsAreVisible
        onView(withId(R.id.tabs)).check(MatchUtils.isVisible());
    }

    @Test //auch gruen, wenn burger icon weg ist, aber auch ohne burger icon, kann man swipen zum oeffnen, daher ok
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
    public void checkTopFragment() {
        //title
        onView(withId(R.id.top_fragment_title)).check(matches(withText(R.string.workout_motherRussia)));
        //image
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
            title = ALL_LEG_EXERCISES.get(position).getName();
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
        for (int position = 8; position < ALL_LEG_EXERCISES.size(); position++) {
            title = ALL_LEG_EXERCISES.get(position).getName();
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
            title = bellyExercises.get(position).getName();
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
        for (int position = 8; position < bellyExercises.size(); position++) {
            title = bellyExercises.get(position).getName();
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
    public void openStatistic(){
        //open nav drawer
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());

        //click on drawer item
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.statistic_4weeks));

        // Check that statistic Activity was opened by checking the graph title is correct
        onView(withId(R.id.graph_title)).check(matches(withText(R.string.graph_points_4)));
    }

    @Test
    public void deletePoints(){
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());

        //delete all points
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.delete_all_points));

        //check if alert dialog pops up
        onView(withText(R.string.delete_points_title)).check(matches(isDisplayed()));

        //click on "nein"
        onView(withText(android.R.string.no)).perform(click());

        //close drawer
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close());
    }
}