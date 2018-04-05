package de.deftone.bitsandpizzas.activities;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.fragments.ExerciseFragment;

import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_CREATED_EXERCISES;

public class CreateWorkoutActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        Toolbar toolbar = findViewById(R.id.toolbar_create);
        toolbar.setTitle(getIntent().getExtras().getString(EXTRA_TITLE));
        setSupportActionBar(toolbar);

        //show up arrow
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        DrawerLayout drawer = findViewById(R.id.drawer_created_exercise_layout);
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
