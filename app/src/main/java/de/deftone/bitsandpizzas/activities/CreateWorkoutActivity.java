package de.deftone.bitsandpizzas.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.fragments.ExerciseFragment;

import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_CREATED_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE;

public class CreateWorkoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        //todo: das hier als naechstes: mit backarrow! da kann ich evtl das von unten gebrauchen...?
        //die toolbar verdeckt den oberen teil der cardvies, deshalb erstmal weglassen
//        Toolbar toolbar = findViewById(R.id.toolbar_create);
//        toolbar.setTitle("Dein Workout");
//        setSupportActionBar(toolbar);

        ExerciseFragment exerciseFragment = new ExerciseFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, TYPE_CREATED_EXERCISES);
        exerciseFragment.setArguments(bundle);

        //falls ich das mal an anderer stelle brauche, fragments neu hinzufuegen und der backStack
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_create_workout, exerciseFragment);
//        //oder:
//        transaction.add(exerciseFragment, "potato");
//        //oder:
//        transaction.add(R.id.activity_create_workout, exerciseFragment, "potato");
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        transaction.addToBackStack(null);
        transaction.commit();
//        getSupportFragmentManager().popBackStack(null, getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
//        //If you want to immediately executing any such pending operations
//        createdWorkoutFragmentManager.executePendingTransactions();
//        //das ist jetzt 1:
//        createdWorkoutFragmentManager.getBackStackEntryCount();
//        //Note that each FragmentManager has its own backstack (so a Fragment's child FragmentManager stack would be different from the containing Activity's fragment backstack), and it is also distinct from the application's Activity back stack.
//        //das funktioniert jetzt auch:
//        if (createdWorkoutFragmentManager.findFragmentByTag("potato") != null) {
//                        getSupportFragmentManager().beginTransaction()
//                                .remove(getSupportFragmentManager().findFragmentByTag("potato"))
//                                .commit();
//        }
    }
}
