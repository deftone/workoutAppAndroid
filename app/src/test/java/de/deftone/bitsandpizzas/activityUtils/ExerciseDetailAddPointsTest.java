package de.deftone.bitsandpizzas.activityUtils;

import android.content.Context;
import android.content.SharedPreferences;

import static de.deftone.bitsandpizzas.activityUtils.ExerciseDetailAddPoints.PREFS_DATES;
import static de.deftone.bitsandpizzas.activityUtils.ExerciseDetailAddPoints.PREFS_DATES_KEY;
import static de.deftone.bitsandpizzas.activityUtils.ExerciseDetailAddPoints.PREFS_POINTS;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anySet;
import static org.mockito.Matchers.anySetOf;
import static org.mockito.Matchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.deftone.bitsandpizzas.R;


/**
 * Created by deftone on 29.01.18.
 */
public class ExerciseDetailAddPointsTest {

    private SharedPreferences sharedPreferencesDates;
    private SharedPreferences sharedPreferencesPoints;
    private  SharedPreferences.Editor sharedPreferencesDatesEditor;
    private  SharedPreferences.Editor sharedPreferencesPointsEditor;
    private Context context;

    @Before
    public void before() throws Exception {
        //keine ahnung was man hiervon alles braucht...
        this.sharedPreferencesDates = Mockito.mock(SharedPreferences.class);
        this.sharedPreferencesPoints = Mockito.mock(SharedPreferences.class);
        this.sharedPreferencesDatesEditor = Mockito.mock(SharedPreferences.Editor.class);
        this.sharedPreferencesPointsEditor = Mockito.mock(SharedPreferences.Editor.class);
        this.context = Mockito.mock(Context.class);
        Mockito.when(context.getSharedPreferences(PREFS_POINTS, 0)).thenReturn(sharedPreferencesDates);
        Mockito.when(context.getSharedPreferences(PREFS_DATES, 0)).thenReturn(sharedPreferencesPoints);
        Mockito.when(sharedPreferencesDates.edit()).thenReturn(sharedPreferencesDatesEditor);
        Mockito.when(sharedPreferencesPoints.edit()).thenReturn(sharedPreferencesPointsEditor);
    }

    @Test
    public void xxx() throws Exception {
        Set<String> default_set = new HashSet<>();
        //testdata
        Set<String> datesSet = new HashSet<>();
        datesSet.add("1514761200000"); //1.1.2018
        datesSet.add("1515106800000"); //5.1.2018
        //diese zeile funktioniert nicht, sollte im code die testdaten ausgeben, tut es aber nicht
        Mockito.when(this.sharedPreferencesDates.getStringSet(PREFS_DATES_KEY, default_set))
                .thenReturn(datesSet);
        //diese zeile will auch nicht, da schmiert der test sofort ab:
//        Mockito.doNothing().when(this.sharedPreferencesDatesEditor.clear().putStringSet(PREFS_DATES_KEY, anySet())).apply();

        ExerciseDetailAddPoints.addExercisePointsToDailySum(context, 10);
    }

}