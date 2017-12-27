package de.deftone.bitsandpizzas.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import de.deftone.bitsandpizzas.data.CreatedExercise;
import de.deftone.bitsandpizzas.fragments.ExerciseFragment;
import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.fragments.TopFragment;


public class MainActivity extends AppCompatActivity {

    public final static String TYPE = "type";
    public final static String LEG_EXERCISES = "leg exercieses";
    public final static String BELLY_EXERCISES = "belly exercieses";
    public final static String BACK_EXERCISES = "back exercieses";
    public final static String CREATED_EXERCISES = "created exercieses";

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Attach the SectionsPagerAdapter to the Viewpager
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(sectionsPagerAdapter);

        //Attach the ViewPager to the TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to join me for working out?");

        return super.onCreateOptionsMenu(menu);
    }

    public void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_workout:
                //hier jedesmal die CREATED_EXERCISES_LIST neu befuellen
                CreatedExercise.generateRandomExercises();
                Intent intent = new Intent(this, CreateWorkoutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    ExerciseFragment legExerciseFragment = new ExerciseFragment();
                    bundle.putString(TYPE, LEG_EXERCISES);
                    legExerciseFragment.setArguments(bundle);
                    return legExerciseFragment;
                case 2:
                    ExerciseFragment bellyExerciseFragment = new ExerciseFragment();
                    bundle.putString(TYPE, BELLY_EXERCISES);
                    bellyExerciseFragment.setArguments(bundle);
                    return bellyExerciseFragment;
                case 3:
                    ExerciseFragment backExercisesFragment = new ExerciseFragment();
                    bundle.putString(TYPE, BACK_EXERCISES);
                    backExercisesFragment.setArguments(bundle);
                    return backExercisesFragment;
                    //todo: ein paar dehnuebungen bei 4
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.beine_tab);
                case 2:
                    return getResources().getText(R.string.bauch_tab);
                case 3:
                    return getResources().getText(R.string.ruecken_tab);
            }
            return null;
        }
    }
}
