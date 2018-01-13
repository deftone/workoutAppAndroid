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
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
    private Set<String> datesSet;
    private TreeSet<Integer> datesTreeSet = new TreeSet<>();
    private ArrayList<Integer> points = new ArrayList<>();
    //    private TreeMap<Double, Integer> date_point_map = new TreeMap<>();
    private TreeMap<Integer, Integer> date_point_map = new TreeMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);
        statisticGraph = findViewById(R.id.graph);
        calendar = Calendar.getInstance();
        getDataFromSharedPrefs();
//        createLineGraph();
        createBarChartGraph();
    }

    //we need this so that we have a chronological ordered TreeMap with date and points
    private void getDataFromSharedPrefs() {
        SharedPreferences presDates = getSharedPreferences(PREFS_DATES, 0);
        Set<String> default_set = new HashSet<>();
        datesSet = presDates.getStringSet(PREFS_DATES_KEY, default_set);

        SharedPreferences prefsPoints = getSharedPreferences(PREFS_POINTS, 0);
        for (String date : datesSet) {
            int sumPoints = prefsPoints.getInt(date, 0);
            double timeInMilies = Double.parseDouble(date);
            double timeInSec = timeInMilies / 1000;
            int timeInSecInt = (int) timeInSec;
            date_point_map.put(timeInSecInt, sumPoints);
            datesTreeSet.add(timeInSecInt);
        }
        Log.d("", "getDataFromSharedPrefs: ");


    }

    //das hier ist richtig sortiert, allerdings kommt die falsche zeit raus.. 1969 statt 2018... /1000 und *1000 klappt nicht
    //also mit TreeSet und TreeMap und Integer wird alles richtig sortiert, allerdings gehen die daten verloren..

    private void createBarChartGraph() {
        int count = date_point_map.size();
        DataPoint[] dataPoints = new DataPoint[count];
        String dateString = "";
        int i = 0;
        for (int dateInSec : datesTreeSet) {
//        for (int i = 0; i < count; i++) {
//            Integer sumPoints = date_point_map.get(Double.parseDouble(date));
            Integer sumPoints = date_point_map.get(dateInSec);
            dataPoints[i] = new DataPoint(i, sumPoints);

            calendar.setTimeInMillis(dateInSec*1000);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1; //Januar is 0, ...
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            dateString = dateString + i + " : " + year + "." + month + "." + day
                    + ", " + hour + ":" + min + ":" + sec + "\n";

            i++;
        }
        // for LineGraph use this:
        //        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dataPoints);
        statisticGraph.addSeries(series);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });
        series.setSpacing(50);

        statisticGraph.getGridLabelRenderer().setNumHorizontalLabels(count + 1);
        statisticGraph.getViewport().setMinY(0.0);
        statisticGraph.getViewport().setMinX(-0.5);
        statisticGraph.getViewport().setMaxX(count - 0.5);
        statisticGraph.getViewport().setXAxisBoundsManual(true);
        statisticGraph.getViewport().setYAxisBoundsManual(true);
        TextView dateText = findViewById(R.id.i_dates);
        dateText.setText(dateString);
    }

}
