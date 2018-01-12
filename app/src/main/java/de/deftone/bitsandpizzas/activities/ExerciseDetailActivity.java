package de.deftone.bitsandpizzas.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.data.BackExercise;
import de.deftone.bitsandpizzas.data.BellyExercise;
import de.deftone.bitsandpizzas.data.Icons;
import de.deftone.bitsandpizzas.data.LegExercise;
import de.deftone.bitsandpizzas.data.StretchingExercise;
import de.deftone.bitsandpizzas.utils.ExerciseDetailList;

import static de.deftone.bitsandpizzas.activities.MainActivity.BACK_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.BELLY_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.CREATED_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.STRETCHING_EXERCISES;
import static de.deftone.bitsandpizzas.data.CreatedExercise.CREATED_EXERCISES_LIST;

public class ExerciseDetailActivity extends AppCompatActivity {

    public static final String EXTRA_EXERCISE_ID = "exercise_id";
    public static final String EXTRA_EXERCISE_TYPE = "exercise_type";
    //eine datei, die als value ein String Set der jeweiligen daten enthaelt (YYYY-MM-DD, YYYY-MM-DD, ..)
    public static final String PREFS_DATES = "exercises_date";
    public static final String PREFS_DATES_KEY = "exercises_date_key";
    //eine datei, die fuer den jeweiligen tag als value die addierten punkte enthaelt, key ist der Tag ("YYYY-MM-DD")
    public static final String PREFS_POINTS = "exercises_date_points";
    ListView listView;
    String title = "";
    int image = 0;
    String[] icon = {};
    String[] desc = {};
    int seconds = 0;
    int[] weight = {};
    Button weightButton;
    Button weightButton2;
    Button weightButton3;
    Button weightAlternButton;
    Button weightAlternButton2;
    Button weightAlternButton3;
    SharedPreferences sharedPreferencesDates;
    SharedPreferences sharedPreferencesPoints;
    SharedPreferences.Editor sharedPreferencesDatesEditor;
    SharedPreferences.Editor sharedPreferencesPointsEditor;
    boolean buttonClicked = false;
    static String today;
    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_detail);

        context = this;

        //get details of the exercise
        int id = getIntent().getExtras().getInt(EXTRA_EXERCISE_ID);
        String type = getIntent().getExtras().getString(EXTRA_EXERCISE_TYPE);
        getDescriptionDetails(id, type);

        //scroll to top and adjust/set elements on activity layout
        NestedScrollView scrollView = findViewById(R.id.detail_scrollview);
        scrollView.getParent().requestChildFocus(scrollView, scrollView);
        setToobar();
        setImageAndDescription();
        setWeightButtons(weight);
        buttonClicked = false;
        setFab();

        //get shared prefs
        initSharedPreferences();
        //for now
//        resetSharedPrefs();
    }

    private void getDescriptionDetails(int id, String type) {
        switch (type) {
            case LEG_EXERCISES:
                title = LegExercise.LEG_EXERCISES[id].getName();
                image = LegExercise.LEG_EXERCISES[id].getImageResourceId();
                icon = LegExercise.LEG_EXERCISES[id].getIcon();
                desc = LegExercise.LEG_EXERCISES[id].getDescription();
                seconds = LegExercise.LEG_EXERCISES[id].getSeconds();
                weight = LegExercise.LEG_EXERCISES[id].getWeight();
                break;
            case BELLY_EXERCISES:
                title = BellyExercise.BELLY_EXERCISES[id].getName();
                image = BellyExercise.BELLY_EXERCISES[id].getImageResourceId();
                icon = BellyExercise.BELLY_EXERCISES[id].getIcon();
                desc = BellyExercise.BELLY_EXERCISES[id].getDescription();
                seconds = BellyExercise.BELLY_EXERCISES[id].getSeconds();
                weight = BellyExercise.BELLY_EXERCISES[id].getWeight();
                break;
            case BACK_EXERCISES:
                title = BackExercise.BACK_EXERCISES[id].getName();
                image = BackExercise.BACK_EXERCISES[id].getImageResourceId();
                icon = BackExercise.BACK_EXERCISES[id].getIcon();
                desc = BackExercise.BACK_EXERCISES[id].getDescription();
                seconds = BackExercise.BACK_EXERCISES[id].getSeconds();
                weight = BackExercise.BACK_EXERCISES[id].getWeight();
                break;
            case STRETCHING_EXERCISES:
                title = StretchingExercise.STRETCHING_EXERCISES[id].getName();
                image = StretchingExercise.STRETCHING_EXERCISES[id].getImageResourceId();
                icon = StretchingExercise.STRETCHING_EXERCISES[id].getIcon();
                desc = StretchingExercise.STRETCHING_EXERCISES[id].getDescription();
                seconds = StretchingExercise.STRETCHING_EXERCISES[id].getSeconds();
                weight = StretchingExercise.STRETCHING_EXERCISES[id].getWeight();
                break;
            case CREATED_EXERCISES:
                title = CREATED_EXERCISES_LIST.get(id).getName();
                image = CREATED_EXERCISES_LIST.get(id).getImageResourceId();
                desc = CREATED_EXERCISES_LIST.get(id).getDescription();
                icon = CREATED_EXERCISES_LIST.get(id).getIcon();
                seconds = CREATED_EXERCISES_LIST.get(id).getSeconds();
                weight = CREATED_EXERCISES_LIST.get(id).getWeight();
                break;
        }
    }

    private void setToobar() {
        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //todo: das hier soll sich so verhalten wie der back button von android, erst dann auf true setzen
        actionBar.setDisplayHomeAsUpEnabled(false);
//in case i will ever need this:
//        Now If you want to use CollapsingToolbarLayout and Toolbar together then you have to use setTitle() of CollapsingToolbarLayout
//        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.confirm_order_mail_layout);
//        collapsingToolbarLayout.setTitle("My Title");
    }

    private void setImageAndDescription() {
        ImageView imageView = findViewById(R.id.image_detail);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, image));

        ExerciseDetailList adapter = new ExerciseDetailList(ExerciseDetailActivity.this, icon, desc);
        listView = findViewById(R.id.list_detail);
        listView.setAdapter(adapter);

        //adjust the height of the listview
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = getTotalHeightofListView();
        int padding = 65;
        params.height = height + padding;
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    private int getTotalHeightofListView() {
        ListAdapter mAdapter = listView.getAdapter();
        int listviewElementsheight = 0;
        for (int i = 0; i < desc.length; i++) {
            View mView = mAdapter.getView(i, null, listView);
            mView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            listviewElementsheight += mView.getMeasuredHeight();
        }
        return listviewElementsheight;
    }

    private void setWeightButtons(int[] weight) {
        TableRow secondRow = findViewById(R.id.second_row);
        TextView textView = findViewById(R.id.text_points);

        weightButton = findViewById(R.id.weight_button);
        weightButton2 = findViewById(R.id.weight_button_2);
        weightButton3 = findViewById(R.id.weight_button_3);
        weightButton.setText("1x" + String.valueOf(weight[0]) + Icons.getIcon(Icons.MUSCLE));
        weightButton2.setText("2x" + String.valueOf(weight[0]) + Icons.getIcon(Icons.MUSCLE));
        weightButton3.setText("3x" + String.valueOf(weight[0]) + Icons.getIcon(Icons.MUSCLE));
        if (weight.length < 2) {
            secondRow.setVisibility(View.GONE);
            textView.setText(R.string.points);
        } else {
            textView.setText(R.string.points_alternative);
            secondRow.setVisibility(View.VISIBLE);
            weightAlternButton = findViewById(R.id.weight_button_alternative);
            weightAlternButton2 = findViewById(R.id.weight_button_alternative_2);
            weightAlternButton3 = findViewById(R.id.weight_button_alternative_3);
            weightAlternButton.setText("1x" + String.valueOf(weight[1]) + Icons.getIcon(Icons.SPARKLES));
            weightAlternButton2.setText("2x" + String.valueOf(weight[1]) + Icons.getIcon(Icons.SPARKLES));
            weightAlternButton3.setText("3x" + String.valueOf(weight[1]) + Icons.getIcon(Icons.SPARKLES));
        }
    }

    public void onClickPoints(View view) {
        addPoints(weightButton, weight[0]);
    }

    public void onClickPoints2(View view) {
        addPoints(weightButton2, 2 * weight[0]);
    }

    public void onClickPoints3(View view) {
        addPoints(weightButton3, 3 * weight[0]);
    }

    public void onClickPointsAltern(View view) {
        addPoints(weightAlternButton, weight[1]);
    }

    public void onClickPointsAltern2(View view) {
        addPoints(weightAlternButton2, 2 * weight[1]);
    }

    public void onClickPointsAltern3(View view) {
        addPoints(weightAlternButton3, 3 * weight[1]);
    }

    private void addPoints(Button button, int newPoints) {
        if (!buttonClicked) {
            //first, add date to shared prefs
            addDate();

            //change button color
            //leider muss man das style doppeln und als Drawable benuzen...
            button.setBackground(getResources().getDrawable(R.drawable.style_shape_rounded_corners_orange));
            //now add points
            int sumPoints = sharedPreferencesPoints.getInt(today, 0);
            int newSumPoints = sumPoints + newPoints;
            sharedPreferencesPointsEditor.putInt(today, newSumPoints).apply();

//            String toastText = "Du hast heute bisher " + newSumPoints + " Punkte erreicht!";
//            Toast toast = Toast.makeText(this, toastText, Toast.LENGTH_SHORT);
//            toast.show();
            printPoints(context);
            buttonClicked = true;
        }
    }

    private void addDate() {
        Date date = new Date();
        today = new SimpleDateFormat("yyyy-MM-dd").format(date);
        getCurrentDate();

        //empty Set as default
        Set<String> tmp = new HashSet<>();
        //get Set of ignored calls add all checked items to this Set
        Set<String> dates = sharedPreferencesDates.getStringSet(PREFS_DATES_KEY, tmp);
        if (!dates.contains(today)) {
            Log.d("test", "addDate: today: " + today);
            dates.add(today);
        }
        //save new Set in editor
        sharedPreferencesDatesEditor.clear().putStringSet(PREFS_DATES_KEY, dates).apply();
    }

    //for debugging
    public static void getCurrentDate() {
        //getting current date and time using Date class
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        Log.d("test", "getCurrentDate: " + df.format(dateobj));
        System.out.println(df.format(dateobj));

       /*getting current date time using calendar class
        * An Alternative of above*/
        Calendar calobj = Calendar.getInstance();
        Log.d("test", "getCurrentDate: " + df.format(calobj.getTime()));
        System.out.println(df.format(calobj.getTime()));

        String toastText = "currentDate 1 " + df.format(calobj.getTime())
                + " currentDate 2 " + df.format(calobj.getTime())
                + "\ntoday: " + today;
        Toast toast = Toast.makeText(context, toastText, Toast.LENGTH_LONG);
        toast.show();
    }

    //todo: was noch fehlt:
    //einstellungen, wo man die punkte zuruecksetzen kann?
    //anzeige, an welchem tag wieviele punkte
    public static void printPoints(Context context) {

        SharedPreferences sharedPreferencesPoints = context.getSharedPreferences(PREFS_POINTS, 0);

        //alle tage
        Set<String> tmp = new HashSet<>();
        SharedPreferences sharedPreferencesDates = context.getSharedPreferences(PREFS_DATES, 0);
        Set<String> dates = sharedPreferencesDates.getStringSet(PREFS_DATES, tmp);
        int defaultValue = 0;
        for (String date : dates) {

            Log.d("test", "printPoints: date: " + date);

            int sumPoints = sharedPreferencesPoints.getInt(date, defaultValue);
            Log.d("test", "printPoints: sumPoints = " + sumPoints);
        }
    }

    private void resetSharedPrefs() {
        sharedPreferencesDatesEditor.clear().apply();
        sharedPreferencesPointsEditor.clear().apply();
    }

    private void initSharedPreferences() {
        sharedPreferencesPoints = getSharedPreferences(PREFS_POINTS, 0);
        sharedPreferencesPointsEditor = sharedPreferencesPoints.edit();
        sharedPreferencesDates = getSharedPreferences(PREFS_DATES, 0);
        sharedPreferencesDatesEditor = sharedPreferencesDates.edit();
    }

    public void setFab() {
        FloatingActionButton fab = findViewById(R.id.fab);
        if (seconds > 0) {
            fab.setVisibility(View.VISIBLE);
            final int finalSeconds = seconds;
            fab.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showTimer(finalSeconds);
                }
            });
        } else
            fab.setVisibility(View.GONE);
    }

    private void showTimer(int sec) {
        Intent intentStopwatch = new Intent(this, StopwatchActivity.class);
        intentStopwatch.putExtra(StopwatchActivity.INTENT_SECONDS, sec);
        startActivity(intentStopwatch);
    }
}
