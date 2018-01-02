package de.deftone.bitsandpizzas.activities;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import de.deftone.bitsandpizzas.R;

import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.CoreMatchers.is;
import static de.deftone.bitsandpizzas.activities.StopwatchActivity.INTENT_SECONDS;

/**
 * Created by deftone on 01.01.18.
 * <p>
 * if there is no extra in the intent, this rule works:
 *
 * @Rule public IntentsTestRule<StopwatchActivity> activityTestRule =
 * new IntentsTestRule<StopwatchActivity>(StopwatchActivity.class);
 *
 * and also this
 *
 * @Rule public ActivityTestRule<StopwatchActivity> mActivityRule =
 * new ActivityTestRule<>(StopwatchActivity.class);
 *
 * apparently it does not matter if one uses an IntentTestRule or ActivityTestRule...
 *
 * however, with extras, this does not work, than it has to be done like coded below
 */
@RunWith(AndroidJUnit4.class)
public class StopwatchActivityTest {
    //don't make seconds longer than 2! otherwise toast test is too long
    private int seconds = 2;

    @Rule
    public ActivityTestRule<StopwatchActivity> mActivityRule =
            new ActivityTestRule<StopwatchActivity>(StopwatchActivity.class) {
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation()
                            .getTargetContext();
                    Intent result = new Intent(targetContext, StopwatchActivity.class);
                    result.putExtra(INTENT_SECONDS, seconds);
                    return result;
                }
            };

    @Test
    public void check_intent_extra_seconds() {
        String time = String.format(Locale.getDefault(), "%02d:%02d", 0, seconds);
        onView(withId(R.id.time_view)).check(matches(withText(time)));
    }

    @Test
    public void check_toast(){
        onView(withId(R.id.start_button)).perform(click());
        //check if toast is popping up
        try {
            //not a good unit test: is not fast and using sleep is probably not good at all...
            Thread.sleep((seconds)*1000);
            onView(withId(R.id.toast_you_made_it))
                    .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                    .check(matches(isDisplayed()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_buttons(){
        onView(withId(R.id.start_button)).perform(click());
        try {
            int runTime = seconds-1;
            //man muss etwas laenger warten als nur die runtime... sonst steht noch die seconds in der texview
            Thread.sleep((runTime)*1000+300);

            //click pause and check time
            onView(withId(R.id.stop_button)).perform(click());
            String time = String.format(Locale.getDefault(), "%02d:%02d", 0, runTime);
            onView(withId(R.id.time_view)).check(matches(withText(time)));
            //wait some more and check time didn't change
            Thread.sleep(1300);
            onView(withId(R.id.time_view)).check(matches(withText(time)));

            //click reset
            onView(withId(R.id.reset_button)).perform(click());
            time = String.format(Locale.getDefault(), "%02d:%02d", 0, seconds);
            Thread.sleep(500); //give the test enough time to update the view
            onView(withId(R.id.time_view)).check(matches(withText(time)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}