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
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.data.BackExercise;
import de.deftone.bitsandpizzas.data.BellyExercise;
import de.deftone.bitsandpizzas.data.CreatedExercise;
import de.deftone.bitsandpizzas.data.LegExercise;
import de.deftone.bitsandpizzas.utils.ExerciseDetailList;

import static de.deftone.bitsandpizzas.activities.MainActivity.BACK_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.BELLY_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.CREATED_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.LEG_EXERCISES;

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

        switch (type) {
            case LEG_EXERCISES:
                title = LegExercise.LEG_EXERCISES[id].getName();
                image = LegExercise.LEG_EXERCISES[id].getImageResourceId();
                icon = LegExercise.LEG_EXERCISES[id].getIcon();
                desc = LegExercise.LEG_EXERCISES[id].getDescription();
                seconds = LegExercise.LEG_EXERCISES[id].getSeconds();
                break;
            case BELLY_EXERCISES:
                title = BellyExercise.BELLY_EXERCISES[id].getName();
                image = BellyExercise.BELLY_EXERCISES[id].getImageResourceId();
                icon = BellyExercise.BELLY_EXERCISES[id].getIcon();
                desc = BellyExercise.BELLY_EXERCISES[id].getDescription();
                seconds = BellyExercise.BELLY_EXERCISES[id].getSeconds();
                break;
            case BACK_EXERCISES:
                title = BackExercise.BACK_EXERCISES[id].getName();
                image = BackExercise.BACK_EXERCISES[id].getImageResourceId();
                icon = BackExercise.BACK_EXERCISES[id].getIcon();
                desc = BackExercise.BACK_EXERCISES[id].getDescription();
                seconds = BackExercise.BACK_EXERCISES[id].getSeconds();
                break;
            case CREATED_EXERCISES:
                //todo und hier ist das problem, es wird wieer ein neuer erzeugt, genau wie im ExerciseFragment
                List<CreatedExercise> createdExercises = CreatedExercise.generateRandomExercises();
                title = createdExercises.get(id).getName();
                image = createdExercises.get(id).getImageResourceId();
                desc = createdExercises.get(id).getDescription();
                icon = createdExercises.get(id).getIcon();
                break;
        }

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //todo: das hier soll sich so verhalten wie der back button von android
        actionBar.setDisplayHomeAsUpEnabled(true);

//        Now If you want to use CollapsingToolbarLayout and Toolbar together then you have to use setTitle() of CollapsingToolbarLayout
//        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.confirm_order_mail_layout);
//        collapsingToolbarLayout.setTitle("My Title");


        ImageView imageView = findViewById(R.id.image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, image));

        ExerciseDetailList adapter = new ExerciseDetailList(ExerciseDetailActivity.this, icon, desc);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

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
