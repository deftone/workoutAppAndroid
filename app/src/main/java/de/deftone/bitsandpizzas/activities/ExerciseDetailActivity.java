package de.deftone.bitsandpizzas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;


import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.data.BackExercise;
import de.deftone.bitsandpizzas.data.BellyExercise;
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
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_detail);

        //scroll to top
        NestedScrollView scrollView = findViewById(R.id.detail_scrollview);
        scrollView.getParent().requestChildFocus(scrollView, scrollView);


        //Display details of the exercise
        int id = getIntent().getExtras().getInt(EXTRA_EXERCISE_ID);
        String type = getIntent().getExtras().getString(EXTRA_EXERCISE_TYPE);

        String title = "";
        int image = 0;
        String[] icon = {};
        String[] desc = {};
        int seconds = 0;
        int[] weight = {};

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

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //todo: das hier soll sich so verhalten wie der back button von android, erst dann auf true setzen
        actionBar.setDisplayHomeAsUpEnabled(false);

//        Now If you want to use CollapsingToolbarLayout and Toolbar together then you have to use setTitle() of CollapsingToolbarLayout
//        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.confirm_order_mail_layout);
//        collapsingToolbarLayout.setTitle("My Title");


        ImageView imageView = findViewById(R.id.image_detail);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, image));

        ExerciseDetailList adapter = new ExerciseDetailList(ExerciseDetailActivity.this, icon, desc);
        list = findViewById(R.id.list_detail);
        list.setAdapter(adapter);

        TableRow secondRow = findViewById(R.id.second_row);
        TextView text_points = findViewById(R.id.text_points);
        Button weightButton = findViewById(R.id.weight_button);
        if (weight.length < 2) {
            secondRow.setVisibility(View.GONE);
            text_points.setText(R.string.points);
            weightButton.setText(String.valueOf(weight[0]) + "\u263a");
        } else {
            //todo: hier stimmt noch etwas nicht...
            secondRow.setVisibility(View.VISIBLE);
            text_points.setText(R.string.points_alternative);
            weightButton.setVisibility(View.GONE);
            Button button_1 = findViewById(R.id.weight_button_1);
            button_1.setText(String.valueOf(weight[0]));
            Button button_2 = findViewById(R.id.weight_button_2);
            button_2.setText(String.valueOf(weight[1]));
        }

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

    public void onClickPoints(View view) {
        //add sharedPreferences
        Button weightButton = findViewById(R.id.weight_button);
        //leider muss man das style doppeln und als Drawable benuzen...
        weightButton.setBackground(getResources().getDrawable(R.drawable.style_shape_rounded_corners_orange));
    }
}
