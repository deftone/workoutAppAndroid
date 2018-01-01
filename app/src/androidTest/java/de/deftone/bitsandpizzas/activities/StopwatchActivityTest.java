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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;
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
    public void start_stop_watch(){
        onView(withId(R.id.start_button)).perform(click());
        //check if toast is popping up
        try {
            //das funktioniert noch nicht... und sleep ist wahrscheinlich auch nicht gut...
            Thread.sleep(seconds*1000);
            onView(withId(R.id.toast_you_made_it)).check(matches(isDisplayed()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}