package de.deftone.bitsandpizzas.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.helper.ExerciseDetailAddPoints;
import de.deftone.bitsandpizzas.data.Exercise;
import de.deftone.bitsandpizzas.helper.ExerciseDetailList;

import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_BACK_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_BELLY_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_COMBI_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_CREATED_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_STRETCHING_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.backExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.bellyExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.ALL_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.combiExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.stretchingExercises;
import static de.deftone.bitsandpizzas.data.CreatedExercise.CREATED_EXERCISES_LIST;
import static de.deftone.bitsandpizzas.data.Exercise.MUSCLE;
import static de.deftone.bitsandpizzas.data.Exercise.SPARKLES;

/**
 * Created by deftone on 28.01.18.
 * this class contains the android/visual part of ExerciseDetails
 * the different methods are tested by espresso tests
 */

public class ExerciseDetailActivity extends AppCompatActivity {

    public static final String EXTRA_EXERCISE_ID = "exercise_id";
    public static final String EXTRA_EXERCISE_TYPE = "exercise_type";
    public static final String EXTRA_VIEWPAGER = "viewpager";
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
    boolean buttonClicked = false;
    ExerciseDetailAddPoints exerciseDetailAddPoints;
    Context context = this;
    private String exerciseType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_detail);

        if (exerciseDetailAddPoints == null) {
            exerciseDetailAddPoints = new ExerciseDetailAddPoints(this);
        }

        //get details of the exercise
        int id = getIntent().getExtras().getInt(EXTRA_EXERCISE_ID);
        exerciseType = getIntent().getExtras().getString(EXTRA_EXERCISE_TYPE);
        getDescriptionDetails(id, exerciseType);

        //scroll to top and adjust/set elements on activity layout
        NestedScrollView scrollView = findViewById(R.id.detail_scrollview);
        scrollView.getParent().requestChildFocus(scrollView, scrollView);
        setToobar();
        setImageAndDescription();
        setWeightButtons(weight);
        buttonClicked = false;
        setFab();
    }

    private void getDescriptionDetails(int id, String type) {
        switch (type) {
            case TYPE_LEG_EXERCISES:
                setExerciseData(ALL_LEG_EXERCISES.get(id));
                break;
            case TYPE_BELLY_EXERCISES:
                setExerciseData(bellyExercises.get(id));
                break;
            case TYPE_BACK_EXERCISES:
                setExerciseData(backExercises.get(id));
                break;
            case TYPE_COMBI_EXERCISES:
                setExerciseData(combiExercises.get(id));
                break;
            case TYPE_STRETCHING_EXERCISES:
                setExerciseData(stretchingExercises.get(id));
                break;
            case TYPE_CREATED_EXERCISES:
                setExerciseData(CREATED_EXERCISES_LIST.get(id));
                break;
        }
    }

    private void setExerciseData(Exercise exercise) {
        title = exercise.getName();
        image = exercise.getImageResourceId();
        desc = exercise.getDescription();
        icon = exercise.getIcon();
        seconds = exercise.getSeconds();
        weight = exercise.getWeight();
    }

    private void setToobar() {
        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        toolbar.setTitle(title);
        //in case i will ever need this:
//        Now If you want to use CollapsingToolbarLayout and Toolbar together then you have to use setTitle() of CollapsingToolbarLayout
//        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.confirm_order_mail_layout);
//        collapsingToolbarLayout.setTitle("My Title");

        //show up arrow
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar,
                R.string.nav_open_drawer,
                R.string.nav_close_drawer);
        //show up arrow (setting it first false and then true is "best practise"...)
        actionBar.setDisplayHomeAsUpEnabled(false);
        toggle.setDrawerIndicatorEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        //and implement up arrow functionality: set correct tab of viewpager
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        actionBar.setDisplayHomeAsUpEnabled(true);
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
        weightButton.setText("1x" + String.valueOf(weight[0]) + MUSCLE);
        weightButton2.setText("2x" + String.valueOf(weight[0]) + MUSCLE);
        weightButton3.setText("3x" + String.valueOf(weight[0]) + MUSCLE);
        if (weight.length < 2) {
            secondRow.setVisibility(View.GONE);
            textView.setText(R.string.points);
        } else {
            textView.setText(R.string.points_alternative);
            secondRow.setVisibility(View.VISIBLE);
            weightAlternButton = findViewById(R.id.weight_button_alternative);
            weightAlternButton2 = findViewById(R.id.weight_button_alternative_2);
            weightAlternButton3 = findViewById(R.id.weight_button_alternative_3);
            weightAlternButton.setText("1x" + String.valueOf(weight[1]) + SPARKLES);
            weightAlternButton2.setText("2x" + String.valueOf(weight[1]) + SPARKLES);
            weightAlternButton3.setText("3x" + String.valueOf(weight[1]) + SPARKLES);
        }
    }

    //these methods must be public otherwise onClick won't work
    public void onClickPoints(View view) {
        handleOnClick(weight[0], weightButton);
    }

    public void onClickPoints2(View view) {
        handleOnClick(2 * weight[0], weightButton2);
    }

    public void onClickPoints3(View view) {
        handleOnClick(3 * weight[0], weightButton3);
    }

    public void onClickPointsAltern(View view) {
        handleOnClick(weight[1], weightAlternButton);
    }

    public void onClickPointsAltern2(View view) {
        handleOnClick(2 * weight[1], weightAlternButton2);
    }

    public void onClickPointsAltern3(View view) {
        handleOnClick(3 * weight[1], weightAlternButton3);
    }

    private void handleOnClick(int buttonPoints, Button button) {
        if (!buttonClicked) {
            int points = exerciseDetailAddPoints.addExercisePointsToDailySum(buttonPoints);
            changeButtonAndShowToast(button, points);
            buttonClicked = true;
        }
    }

    private void changeButtonAndShowToast(Button button, int points) {
        button.setBackground(getResources().getDrawable(R.drawable.style_shape_rounded_corners_orange));
        String toastText = getString(R.string.points_today_1)
                + points + getString(R.string.points_today_2);
        Toast toast = Toast.makeText(this, toastText, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void setFab() {
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