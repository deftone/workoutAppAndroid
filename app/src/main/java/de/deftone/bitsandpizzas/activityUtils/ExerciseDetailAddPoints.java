package de.deftone.bitsandpizzas.activityUtils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by deftone on 28.01.18.
 * this class contains the logic part of ExerciseDetails
 * just one public method: addExercisePointsToDailySum
 */

//todo: unittest mit mock fuer die shared prefs
public class ExerciseDetailAddPoints {

    //eine datei, die als value ein String Set der jeweiligen daten enthaelt (YYYY-MM-DD, YYYY-MM-DD, ..)
    public static final String PREFS_DATES = "exercises_date";
    public static final String PREFS_DATES_KEY = "exercises_date_key";
    //eine datei, die fuer den jeweiligen tag als value die addierten punkte enthaelt, key ist der Tag ("YYYY-MM-DD")
    public static final String PREFS_POINTS = "exercises_date_points";

    private static SharedPreferences sharedPreferencesDates;
    private static SharedPreferences sharedPreferencesPoints;
    private static SharedPreferences.Editor sharedPreferencesDatesEditor;
    private static SharedPreferences.Editor sharedPreferencesPointsEditor;

    static String currentTimeInMilliesStringKey;

    public static int addExercisePointsToDailySum(Context context, int newPoints) {
        initSharedPreferences(context);

        //first, add date to shared prefs
        addDate();

        //now add points
        //wenn ein neuer tag ist, sollte sumPoints der defaultwert 0 sein...
        int sumPoints = sharedPreferencesPoints.getInt(currentTimeInMilliesStringKey, 0);
        //pointsFromPrefs.getInt(String.valueOf(date), 0);
        int newSumPoints = sumPoints + newPoints;
        sharedPreferencesPointsEditor.putInt(currentTimeInMilliesStringKey, newSumPoints).apply();
        return newSumPoints;

    }

    private static void addDate() {
        Date date = new Date();
        long currentTimeInMillies = date.getTime();
        String currentTimeInMilliesString = String.valueOf(currentTimeInMillies);

        Set<String> default_set = new HashSet<>();
        Set<String> datesFromPref = sharedPreferencesDates.getStringSet(PREFS_DATES_KEY, default_set);
        //this is needed when the point button is clicked for the first time
        if (datesFromPref.size() == 0) {
            currentTimeInMilliesStringKey = currentTimeInMilliesString;
            datesFromPref.add(currentTimeInMilliesStringKey);
            sharedPreferencesDatesEditor.clear().putStringSet(PREFS_DATES_KEY, datesFromPref).apply();
            return;
        }
        int fourteenHoursInMillies = 50400000;// 14h*60m*60s*1000
        //check if latest/newest dateitem is > 14h ago
        ArrayList<Long> datesFromPrefLong = new ArrayList<>();
        for (String dateString : datesFromPref) {
            datesFromPrefLong.add(Long.valueOf(dateString));
        }
        long latestDate = Collections.max(datesFromPrefLong);
        long diff = currentTimeInMillies - latestDate;
        //modifiedTimeFromPrefs is older than the new/current time
        if (diff > fourteenHoursInMillies) {
            currentTimeInMilliesStringKey = currentTimeInMilliesString;
            datesFromPref.add(currentTimeInMilliesStringKey);
            sharedPreferencesDatesEditor.clear().putStringSet(PREFS_DATES_KEY, datesFromPref).apply();
        }
    }

    private static void initSharedPreferences(Context context) {
        sharedPreferencesPoints = context.getSharedPreferences(PREFS_POINTS, 0);
        sharedPreferencesPointsEditor = sharedPreferencesPoints.edit();
        sharedPreferencesDates = context.getSharedPreferences(PREFS_DATES, 0);
        sharedPreferencesDatesEditor = sharedPreferencesDates.edit();
    }
}
