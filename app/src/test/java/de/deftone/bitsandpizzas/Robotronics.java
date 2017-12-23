package de.deftone.bitsandpizzas;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import de.deftone.bitsandpizzas.activities.MainActivity;
import de.deftone.bitsandpizzas.activities.CreateWorkoutActivity;

import static junit.framework.Assert.assertEquals;

/**
 * Created by deftone on 31.10.17.
 */


@RunWith(RobolectricTestRunner.class)
public class Robotronics {

    @Test
    public void clickingButton_shouldStartOrderActivity() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.action_create_workout).performClick();

        Intent expectedIntent = new Intent(activity, CreateWorkoutActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

}