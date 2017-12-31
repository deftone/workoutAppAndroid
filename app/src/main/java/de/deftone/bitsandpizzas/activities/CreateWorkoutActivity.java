package de.deftone.bitsandpizzas.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.fragments.ExerciseFragment;

import static de.deftone.bitsandpizzas.activities.MainActivity.CREATED_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE;

public class CreateWorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        //die toolbar verdeckt den oberen teil der cardvies, deshalb erstmal weglassen
//        Toolbar toolbar = findViewById(R.id.toolbar_create);
//        toolbar.setTitle("Dein Workout");
//        setSupportActionBar(toolbar);

        //todo: ueberlegen, wie ich am besten die versch. zufallsprogramme zusammenstelle...
        //hier oder mehrere CreatedExercise Klassen in data?
        ExerciseFragment exerciseFragment = new ExerciseFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, CREATED_EXERCISES);
        exerciseFragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_create_workout, exerciseFragment);
        transaction.commit();
    }
}
