package de.deftone.bitsandpizzas.activities;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
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
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by deftone on 26.12.17.
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    //we need this, so that the app is launched before the tests start - otherwise all will fail
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


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
    public void createButtonIsVisible() {
        onView(withId(R.id.action_create_workout)).check(matches(isDisplayed()));
    }

    @Test
    public void firstCardViewItemLeg() {
        Matcher<View> matcher = allOf(withText("Beine"),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        //check if first card view has the correct title
        String title = "Kniebeuge im Ausfallschritt";
        int position = 0;
        //denn es werden immer 1-3 recyclerviews geladen, der aktuelle und der rechts bzw links davon, deshalb mit allOf und isDisplayed die richtige beutzen
        //achtung: wichtig! ich benutze eine viewgroup, daher muss withText mit hasDescendant gewrappt werden!!
        onView(allOf(withId(R.id.exercise_recycler), isDisplayed())).check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
    }

    @Test
    public void secondCardViewItemLeg() {
        Matcher<View> matcher = allOf(withText("Beine"),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());
        String title = "Kniebeugen";
        int position = 1;
        onView(allOf(withId(R.id.exercise_recycler), isDisplayed())).check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
    }

    @Test
    public void eighthCardViewItemLeg() {
        String title = "Unteres Bein im Liegen heben";
        int position = 7;

        Matcher<View> matcher = allOf(withText("Beine"),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        onView(allOf(withId(R.id.exercise_recycler), isDisplayed())).check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
    }

    @Test
    public void ninthCardViewItemLeg() {
        String title = "Standwaage";
        int position = 8;

        Matcher<View> matcher = allOf(withText("Beine"),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());

        //das funktioniert nicht... muss aber auch gar nicht getestet werden...
//        onView(withText(title)).check(matches(not(isDisplayed())));
        //common pitfall... mind. 90% muss zu sehen sein...
        //deshalb scrollen
        onView(allOf(withId(R.id.exercise_recycler), isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(8));

        onView(allOf(withId(R.id.exercise_recycler), isDisplayed())).check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
    }


    @Test
    public void firstCardViewItemBelly() {
        Matcher<View> matcher = allOf(withText("Bauch"),
                isDescendantOfA(withId(R.id.tabs)));
        onView(matcher).perform(click());
        String title = "Crunch";
        int position = 0;
        onView(allOf(withId(R.id.exercise_recycler), isDisplayed())).check(matches(MatchUtils.eigenerMatcher(position, hasDescendant(withText(title)))));
    }
}