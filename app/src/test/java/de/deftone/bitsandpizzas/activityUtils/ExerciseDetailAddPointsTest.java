package de.deftone.bitsandpizzas.activityUtils;

import android.content.Context;
import android.content.SharedPreferences;

import static de.deftone.bitsandpizzas.activityUtils.ExerciseDetailAddPoints.PREFS_DATES;
import static de.deftone.bitsandpizzas.activityUtils.ExerciseDetailAddPoints.PREFS_POINTS;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import de.deftone.bitsandpizzas.R;


/**
 * Created by deftone on 29.01.18.
 */
public class ExerciseDetailAddPointsTest {

    private SharedPreferences sharedPrefsDates;
    private SharedPreferences sharedPrefsPoints;
    private  SharedPreferences.Editor sharedPreferencesDatesEditor;
    private  SharedPreferences.Editor sharedPreferencesPointsEditor;
    private Context context;

    @Before
    public void before() throws Exception {
        this.sharedPrefsDates = Mockito.mock(SharedPreferences.class);
        this.sharedPrefsPoints = Mockito.mock(SharedPreferences.class);
        this.sharedPreferencesDatesEditor = Mockito.mock(SharedPreferences.Editor.class);
        this.sharedPreferencesPointsEditor = Mockito.mock(SharedPreferences.Editor.class);
        this.context = Mockito.mock(Context.class);
        Mockito.when(context.getSharedPreferences(PREFS_POINTS, 0)).thenReturn(sharedPrefsDates);
        Mockito.when(context.getSharedPreferences(PREFS_DATES, 0)).thenReturn(sharedPrefsPoints);
        Mockito.when(sharedPrefsDates.edit()).thenReturn(sharedPreferencesDatesEditor);
        Mockito.when(sharedPrefsPoints.edit()).thenReturn(sharedPreferencesPointsEditor);
    }

    @Test
    public void xxx() throws Exception {
        ExerciseDetailAddPoints.addExercisePointsToDailySum(context, 10);
        //        Mockito.when(sharedPrefs.getString(anyString(), anyString())).thenReturn("foobar");
//        assertEquals("foobar", Auth.getValidToken(context));
        // maybe add some verify();
    }

}