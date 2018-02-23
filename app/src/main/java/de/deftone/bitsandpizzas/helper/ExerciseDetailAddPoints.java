package de.deftone.bitsandpizzas.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by deftone on 28.01.18.
 * this class contains the logic part of ExerciseDetails
 */
public class ExerciseDetailAddPoints {

    //eine datei, die als value ein String Set der jeweiligen daten enthaelt (YYYY-MM-DD, YYYY-MM-DD, ..)
    public static final String PREFS_DATES = "exercises_date";
    public static final String PREFS_DATES_KEY = "exercises_date_key";
    //eine datei, die fuer den jeweiligen tag als value die addierten punkte enthaelt, key ist der Tag ("YYYY-MM-DD")
    public static final String PREFS_POINTS = "exercises_date_points";

    private SharedPreferences sharedPreferencesDates;
    private SharedPreferences sharedPreferencesPoints;

    public ExerciseDetailAddPoints(Context context) {
        sharedPreferencesPoints = context.getSharedPreferences(PREFS_POINTS, 0);
        sharedPreferencesDates = context.getSharedPreferences(PREFS_DATES, 0);
    }

    @VisibleForTesting
    ExerciseDetailAddPoints(SharedPreferences sharedPreferencesDates,
                            SharedPreferences sharedPreferencesPoints) {
        this.sharedPreferencesDates = sharedPreferencesDates;
        this.sharedPreferencesPoints = sharedPreferencesPoints;
    }

    public int addExercisePointsToDailySum(int newPoints) {
        //first, add date to shared prefs if necessary
        String currentTimeInMilliesStringKey = updateKeyDate();

        //now add points
        //wenn ein neuer tag ist, sollte sumPoints der defaultwert 0 sein...
        int sumPoints = sharedPreferencesPoints.getInt(currentTimeInMilliesStringKey, 0);
        int newSumPoints = sumPoints + newPoints;
        sharedPreferencesPoints.edit().putInt(currentTimeInMilliesStringKey, newSumPoints).apply();
        return newSumPoints;
    }

    protected String updateKeyDate() {
        Date date = new Date();
        long currentTimeInMillies = date.getTime();

        Set<String> default_set = new HashSet<>();
        Set<String> datesFromPref = sharedPreferencesDates.getStringSet(PREFS_DATES_KEY, default_set);

        String currentTimeInMilliesStringKey = getDateKey(currentTimeInMillies, datesFromPref);
        //only update the sharedPrefs if the date key is not yet contained
        if (!datesFromPref.contains(currentTimeInMilliesStringKey)) {
            datesFromPref.add(currentTimeInMilliesStringKey);
            sharedPreferencesDates.edit().clear().putStringSet(PREFS_DATES_KEY, datesFromPref).apply();
        }
        return currentTimeInMilliesStringKey;
    }

    protected String getDateKey(long currentTimeInMillies, Set<String> datesFromPref) {
        String currentTimeInMilliesString = String.valueOf(currentTimeInMillies);
        //this is needed when the point button is clicked for the first time (or after deleting the shared prefs)
        if (datesFromPref.size() == 0) {
            return currentTimeInMilliesString;
        }

        //if there are already dates in the shared prefs, only add the date if it is a new day (>14h have passed)
        int fourteenHoursInMillies = 50400000;// 14h*60m*60s*1000
        ArrayList<Long> datesFromPrefLong = new ArrayList<>();
        for (String dateString : datesFromPref) {
            datesFromPrefLong.add(Long.valueOf(dateString));
        }
        long latestDate = Collections.max(datesFromPrefLong);
        long diff = currentTimeInMillies - latestDate;
        //modifiedTimeFromPrefs is older than the new/current time
        if (diff > fourteenHoursInMillies) {
            return currentTimeInMilliesString;
        }
        return String.valueOf(latestDate);
    }
}