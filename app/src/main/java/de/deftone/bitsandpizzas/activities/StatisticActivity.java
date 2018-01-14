package de.deftone.bitsandpizzas.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.PREFS_DATES;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.PREFS_DATES_KEY;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.PREFS_POINTS;

/**
 * Created by deftone on 12.01.18.
 * <p>
 * todo: statistik ansicht fuer monat, jahr, die letzten 10? auch menue items in drawer anpassen
 */

public class StatisticActivity extends AppCompatActivity {
    private GraphView statisticGraph;
    private Calendar calendar;
    private Set<String> stringDatesFromPrefs;
    private ArrayList<Long> dates_list = new ArrayList<>();
    private Map<Long, Integer> date_point_map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);
        statisticGraph = findViewById(R.id.graph);
        calendar = Calendar.getInstance();
        getDataFromSharedPrefs();
        createBarChartGraph();
    }

    //we need this so that we have a chronological ordered TreeMap with date and points
    private void getDataFromSharedPrefs() {
        SharedPreferences presDates = getSharedPreferences(PREFS_DATES, 0);
        Set<String> default_set = new HashSet<>();
        stringDatesFromPrefs = presDates.getStringSet(PREFS_DATES_KEY, default_set);

        SharedPreferences pointsFromPrefs = getSharedPreferences(PREFS_POINTS, 0);
        for (String date : stringDatesFromPrefs) {
            Long timeInMillies = Long.parseLong(date);
            dates_list.add(timeInMillies);
        }

        Collections.sort(dates_list);
        for (Long date : dates_list) {
            int sumPoints = pointsFromPrefs.getInt(String.valueOf(date), 0);
            date_point_map.put(date, sumPoints);
        }
    }

    private void createBarChartGraph() {
        TextView dateText = findViewById(R.id.i_dates);
        int count = date_point_map.size();
        if (count > 0) {
            DataPoint[] dataPoints = new DataPoint[count];
            String dateString = "";
            int i = 0;
            for (long date : dates_list) {
                Integer sumPoints = date_point_map.get(date);
                dataPoints[i] = new DataPoint(i, sumPoints);
                dateString = getDateString(i, dateString, date);
                i++;
            }
            // for LineGraph use this:
            //        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
            BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dataPoints);
            statisticGraph.addSeries(series);
            series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                @Override
                public int get(DataPoint data) {
//                    Log.d("test", "get: green: " + (int) data.getY() * 10);
                    int green = (int) data.getY() * 10;
                    if (green > 255)
                        green = 255;
                    return Color.rgb(0, green, 0);
                }
            });
            series.setSpacing(50);

            statisticGraph.getGridLabelRenderer().setNumHorizontalLabels(count + 1);
            statisticGraph.getViewport().setMinY(0.0);
            statisticGraph.getViewport().setMinX(-0.5);
            statisticGraph.getViewport().setMaxX(count - 0.5);
            statisticGraph.getViewport().setXAxisBoundsManual(true);
            statisticGraph.getViewport().setYAxisBoundsManual(true);
            dateText.setText(dateString);
        } else {
            dateText.setText(R.string.nothing_to_show);
        }
    }

    private String getDateString(int i, String dateString, long date) {
        calendar.setTimeInMillis(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; //Januar is 0, ...
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        dateString = dateString + i + " : " + formatTimeDigit(day) + "." + formatTimeDigit(month)
                + "." + formatTimeDigit(year)
                + ", " + formatTimeDigit(hour) + ":" + formatTimeDigit(min)
                + ":" + formatTimeDigit(sec) + "\n";

        return dateString;
    }

    private String formatTimeDigit(int number) {
        if (number < 10)
            return "0" + number;
        else
            return "" + number;
    }
}
