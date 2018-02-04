package de.deftone.bitsandpizzas.activityUtils;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static de.deftone.bitsandpizzas.activityUtils.ExerciseDetailAddPoints.PREFS_DATES_KEY;
import static de.deftone.bitsandpizzas.activityUtils.ExerciseDetailAddPoints.PREFS_POINTS;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anySet;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

/**
 * Created by deftone on 29.01.18.
 */
public class ExerciseDetailAddPointsTest {

    private SharedPreferences sharedPreferencesDates;
    private SharedPreferences sharedPreferencesPoints;
    private SharedPreferences.Editor sharedPreferencesDatesEditor;
    private SharedPreferences.Editor sharedPreferencesPointsEditor;

    private ExerciseDetailAddPoints sut;

    @Before
    public void setUp() throws Exception {
        this.sharedPreferencesDates = mock(SharedPreferences.class);
        this.sharedPreferencesPoints = mock(SharedPreferences.class);
        this.sharedPreferencesDatesEditor = mock(SharedPreferences.Editor.class);
        this.sharedPreferencesPointsEditor = mock(SharedPreferences.Editor.class);
        this.sut = new ExerciseDetailAddPoints(sharedPreferencesDates, sharedPreferencesPoints);

        when(sharedPreferencesDates.edit()).thenReturn(sharedPreferencesDatesEditor);
        when(sharedPreferencesPoints.edit()).thenReturn(sharedPreferencesPointsEditor);

        when(sharedPreferencesDatesEditor.clear()).thenReturn(sharedPreferencesDatesEditor);
        when(sharedPreferencesDatesEditor.putStringSet(eq(PREFS_DATES_KEY), anySet())).thenReturn(sharedPreferencesDatesEditor);
    }

    /** pure java unit tests for getDateKey (AAA)**/
    @Test
    public void noDatesInSharedPrefs() {
        //arrage
        Set<String> sharedPrefsTestData = new HashSet<>();
        long currentTime = 1514761200000l; //1.1.2018

        //act
        String key = sut.getDateKey(currentTime, sharedPrefsTestData);

        //assert
        assertEquals(String.valueOf(currentTime), key);
    }

    @Test
    public void differentDatesInSharedPrefs() {
        Set<String> sharedPrefsTestData = new HashSet<>();
        sharedPrefsTestData.add("1514761200000"); //1.1.2018
        sharedPrefsTestData.add("1515106800000"); //5.1.2018
        long currentTime = 1515366000000l; //8.1.2018

        String key = sut.getDateKey(currentTime, sharedPrefsTestData);

        assertEquals(String.valueOf(currentTime), key);
    }

    @Test
    public void sameDatesInSharedPrefs() {
        Set<String> sharedPrefsTestData = new HashSet<>();
        sharedPrefsTestData.add("1514761200000"); //1.1.2018
        sharedPrefsTestData.add("1515106800000"); //5.1.2018
        long currentTime = 1515114000000l; //5.1.2018 - but only 2 hours later

        String key = sut.getDateKey(currentTime, sharedPrefsTestData);

        assertEquals("1515106800000", key);
    }

    /** mocked unit tests for updateKeyDate (not much logic, not that necessarry, just for fun) **/
    @Test
    public void noDatesInSharedPrefsMock(){
        //shared prefs dates has no content yet
        Set<String> datesSet = new HashSet<>();
        when(this.sharedPreferencesDates.getStringSet(eq(PREFS_DATES_KEY), anySet())).thenReturn(datesSet);

        sut.updateKeyDate();

        verify(sharedPreferencesDatesEditor, times(1)).putStringSet(eq(PREFS_DATES_KEY), anySet());
    }

    @Test
    public void differentDatesInSharedPrefsMock() {
        Set<String> sharedPrefsTestData = new HashSet<>();
        sharedPrefsTestData.add("1514761200000"); //1.1.2018
        sharedPrefsTestData.add("1515106800000"); //5.1.2018
        when(this.sharedPreferencesDates.getStringSet(eq(PREFS_DATES_KEY), anySet())).thenReturn(sharedPrefsTestData);

        sut.updateKeyDate();

        verify(sharedPreferencesDatesEditor, times(1)).putStringSet(eq(PREFS_DATES_KEY), anySet());
    }

    @Test
    public void sameDatesInSharedPrefsMock() {
        Set<String> sharedPrefsTestData = new HashSet<>();
        sharedPrefsTestData.add("1514761200000"); //1.1.2018
        sharedPrefsTestData.add("1515106800000"); //5.1.2018
        sharedPrefsTestData.add(String.valueOf(new Date().getTime())); //current date
        when(this.sharedPreferencesDates.getStringSet(eq(PREFS_DATES_KEY), anySet())).thenReturn(sharedPrefsTestData);

        sut.updateKeyDate();

        verify(sharedPreferencesDatesEditor, times(0))
                .putStringSet(eq(PREFS_DATES_KEY), anySet());
    }

    @Test
    public void addPoints(){
        Set<String> sharedPrefsTestData = new HashSet<>();
        sharedPrefsTestData.add("1514761200000"); //1.1.2018
        sharedPrefsTestData.add("1515106800000"); //5.1.2018
        when(sharedPreferencesDates.getStringSet(eq(PREFS_DATES_KEY), anySet())).thenReturn(sharedPrefsTestData);

        int oldSum = 10;
        when(sharedPreferencesPoints.getInt(anyString(), anyInt())).thenReturn(oldSum);

        int sharedPrefsTestPoints = oldSum;
        when(sharedPreferencesPointsEditor.putInt(anyString(), anyInt())).thenReturn(sharedPreferencesPointsEditor);

        int newPoints = 5;
        int newSum = sut.addExercisePointsToDailySum(newPoints);

        assertEquals(oldSum+newPoints, newSum);
    }
}