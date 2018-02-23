package de.deftone.bitsandpizzas.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.data.BackExerciseData;
import de.deftone.bitsandpizzas.data.BellyExerciseData;
import de.deftone.bitsandpizzas.data.CombiExerciseData;
import de.deftone.bitsandpizzas.data.CreatedExercise;
import de.deftone.bitsandpizzas.data.Exercise;
import de.deftone.bitsandpizzas.data.LegExerciseData;
import de.deftone.bitsandpizzas.data.StretchingExerciseData;
import de.deftone.bitsandpizzas.fragments.ExerciseFragment;
import de.deftone.bitsandpizzas.fragments.TopFragment;

import static de.deftone.bitsandpizzas.activities.StatisticActivity.ALL;
import static de.deftone.bitsandpizzas.activities.StatisticActivity.EXTRA;
import static de.deftone.bitsandpizzas.activities.StatisticActivity.FOUR_WEEKS;
import static de.deftone.bitsandpizzas.activities.StatisticActivity.LAST_TEN;
import static de.deftone.bitsandpizzas.activities.StatisticActivity.TWELVE_WEEKS;
import static de.deftone.bitsandpizzas.helper.ExerciseDetailAddPoints.PREFS_DATES;
import static de.deftone.bitsandpizzas.helper.ExerciseDetailAddPoints.PREFS_POINTS;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final List<Exercise> ALL_LEG_EXERCISES = LegExerciseData.getAllLegExercises();
    public static final List<Exercise> bellyExercises = BellyExerciseData.getAllBellyExercises();
    public static final List<Exercise> backExercises = BackExerciseData.getAllBackExercises();
    public static final List<Exercise> combiExercises = CombiExerciseData.getAllCombiExercises();
    public static final List<Exercise> stretchingExercises = StretchingExerciseData.getAllStretchinExercises();

    private static final String SAVED_LAYOUT_MANAGER = "classname.recycler.layout";//????
    public final static String TYPE = "type";
    public final static String TYPE_LEG_EXERCISES = "leg exercieses";
    public final static String TYPE_BELLY_EXERCISES = "belly exercieses";
    public final static String TYPE_BACK_EXERCISES = "back exercieses";
    public final static String TYPE_COMBI_EXERCISES = "combi_exercises";
    public final static String TYPE_STRETCHING_EXERCISES = "stretching exercieses";
    public final static String TYPE_CREATED_EXERCISES = "created exercieses";

    private ShareActionProvider shareActionProvider;
    private Parcelable layoutManagerSavedState;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViewPager();

        recyclerView = findViewById(R.id.exercise_recycler);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //add burger icon for drawer to toolbar
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.nav_open_drawer,
                R.string.nav_close_drawer);
        //add drawer toggle to drawer layout
        drawer.addDrawerListener(toggle);
        //sync state of burger icon on toolbar with state of the drawer
        toggle.syncState();

        //set listener to drawer
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //share intent in options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent(getString(R.string.share_text));

        return super.onCreateOptionsMenu(menu);
    }

    public void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    private void setUpViewPager(){
        //Attach the SectionsPagerAdapter to the Viewpager
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(sectionsPagerAdapter);

        //Attach the ViewPager to the TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //put icons to tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.legs_running);
        tabLayout.getTabAt(2).setIcon(R.drawable.belly);
        tabLayout.getTabAt(3).setIcon(R.drawable.back_lying);
        tabLayout.getTabAt(4).setIcon(R.drawable.combi);
        tabLayout.getTabAt(5).setIcon(R.drawable.stretching);

        //todo das hier macht einen nullpointer wenn die app ohne AS gestartet wird... :(
//        //set correct tab - wozu brauche ich das ueberhaupt?!
//        if (getIntent().getExtras() != null) {
//            String viewPagerTitle = getIntent().getExtras().getString(EXTRA_VIEWPAGER);
//            int viewPagerItem;
//            switch (viewPagerTitle) {
//                case TYPE_LEG_EXERCISES:
//                    viewPagerItem = 1;
//                    break;
//                case TYPE_BELLY_EXERCISES:
//                    viewPagerItem = 2;
//                    break;
//                case TYPE_BACK_EXERCISES:
//                    viewPagerItem = 3;
//                    break;
//                case TYPE_COMBI_EXERCISES:
//                    viewPagerItem = 4;
//                    break;
//                case TYPE_STRETCHING_EXERCISES:
//                    viewPagerItem = 5;
//                    break;
//                default:
//                    viewPagerItem = 0;
//
//            }
//            viewPager.setCurrentItem(viewPagerItem);
//        }

    }

    //viewpager
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
                    bundle.putString(TYPE, TYPE_LEG_EXERCISES);
                    legExerciseFragment.setArguments(bundle);
                    return legExerciseFragment;
                case 2:
                    ExerciseFragment bellyExerciseFragment = new ExerciseFragment();
                    bundle.putString(TYPE, TYPE_BELLY_EXERCISES);
                    bellyExerciseFragment.setArguments(bundle);
                    return bellyExerciseFragment;
                case 3:
                    ExerciseFragment backExercisesFragment = new ExerciseFragment();
                    bundle.putString(TYPE, TYPE_BACK_EXERCISES);
                    backExercisesFragment.setArguments(bundle);
                    return backExercisesFragment;
                case 4:
                    ExerciseFragment combiExerciseFragment = new ExerciseFragment();
                    bundle.putString(TYPE, TYPE_COMBI_EXERCISES);
                    combiExerciseFragment.setArguments(bundle);
                    return combiExerciseFragment;
                case 5:
                    ExerciseFragment stretchingFragment = new ExerciseFragment();
                    bundle.putString(TYPE, TYPE_STRETCHING_EXERCISES);
                    stretchingFragment.setArguments(bundle);
                    return stretchingFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 6;
        }



//        @Override
//        public CharSequence getPageTitle(int position) {
//            Drawable myDrawable;
//            switch (position) {
//                case 0:
//                    return getResources().getText(R.string.home_tab);
//                case 1:
////                    myDrawable = getResources().getDrawable(R.mipmap.ic_launcher);
//                    return getResources().getText(R.string.beine_tab);
//                case 2:
//                    return getResources().getText(R.string.bauch_tab);
//                case 3:
//                    return getResources().getText(R.string.ruecken_tab);
//                case 4:
//                    return getString(R.string.combi_tab);
//                case 5:
//                    return getResources().getText(R.string.stretching_tab);
//            }
//            return null;
//        }
    }

    //navigation drawer
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        //warum muss ich diese methode ueberschreiben? was macht die? war bei catChat nicht noetig...
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        switch (id) {
            //hier jedesmal die CREATED_EXERCISES_LIST neu befuellen
            case R.id.nav_random_mix_long:
                CreatedExercise.generateRandomExercises(4, 5,
                        5, 7, 5);
                intent = new Intent(this, CreateWorkoutActivity.class);
                break;
            case R.id.nav_random_mix_medium:
                intent = new Intent(this, CreateWorkoutActivity.class);
                CreatedExercise.generateRandomExercises(3, 4,
                        3, 5, 3);
                break;
            case R.id.nav_random_mix_short:
                intent = new Intent(this, CreateWorkoutActivity.class);
                CreatedExercise.generateRandomExercises(2, 2,
                        2, 2, 2);
                break;
            case R.id.nav_radom_legs:
                intent = new Intent(this, CreateWorkoutActivity.class);
                CreatedExercise.generateRandomExercises(6, 0,
                        0, 0, 0);
                break;
            case R.id.nav_radom_belly:
                intent = new Intent(this, CreateWorkoutActivity.class);
                CreatedExercise.generateRandomExercises(0, 6,
                        0, 0, 0);
                break;
            case R.id.nav_radom_back:
                CreatedExercise.generateRandomExercises(0, 0,
                        6, 0, 0);
                intent = new Intent(this, CreateWorkoutActivity.class);
                break;
            case R.id.nav_radom_combi:
                CreatedExercise.generateRandomExercises(0, 0,
                        0, 6, 0);
                intent = new Intent(this, CreateWorkoutActivity.class);
                break;
            case R.id.statistic_last10:
                intent = new Intent(this, StatisticActivity.class);
                intent.putExtra(EXTRA, LAST_TEN);
                break;
            case R.id.statistic_4weeks:
                intent = new Intent(this, StatisticActivity.class);
                intent.putExtra(EXTRA, FOUR_WEEKS);
                break;
            case R.id.statistic_12weeks:
                intent = new Intent(this, StatisticActivity.class);
                intent.putExtra(EXTRA, TWELVE_WEEKS);
                break;
            case R.id.statistic_all:
                intent = new Intent(this, StatisticActivity.class);
                intent.putExtra(EXTRA, ALL);
                break;
            case R.id.delete_all_points:
                deletePoints();
                break;
        }
        if (intent != null)
            startActivity(intent);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    private void deletePoints() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(R.string.delete_points_title)
                .setMessage(R.string.delete_points_message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        resetPreferences();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void resetPreferences() {
        SharedPreferences sharedPreferencesDates = getSharedPreferences(PREFS_DATES, 0);
        SharedPreferences.Editor sharedPreferencesDatesEditor = sharedPreferencesDates.edit();
        sharedPreferencesDatesEditor.clear().apply();

        SharedPreferences sharedPreferencesPoints = getSharedPreferences(PREFS_POINTS, 0);
        SharedPreferences.Editor sharedPreferencesPointsEditor = sharedPreferencesPoints.edit();
        sharedPreferencesPointsEditor.clear().apply();
    }

    //todo: merken wo die liste war und nicht immer wieder von oben!
//    @Override
//    protected Parcelable onSaveInstanceState() {
//        Bundle bundle = new Bundle();
//
//        bundle.putParcelable(SAVED_LAYOUT_MANAGER, recyclerView.getLayoutManager().onSaveInstanceState());
//        return bundle;
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Parcelable state) {
//        if (state instanceof Bundle) {
//            layoutManagerSavedState = ((Bundle) state).getParcelable(SAVED_LAYOUT_MANAGER);
//        }
//        super.onRestoreInstanceState(state);
//    }
//
//    private void restoreLayoutManagerPosition() {
//        if (layoutManagerSavedState != null) {
//            recyclerView.getLayoutManager().onRestoreInstanceState(layoutManagerSavedState);
//        }
//    }

}
