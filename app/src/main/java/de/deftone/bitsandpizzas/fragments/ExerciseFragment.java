package de.deftone.bitsandpizzas.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.activities.ExerciseDetailActivity;
import de.deftone.bitsandpizzas.data.BackExercise;
import de.deftone.bitsandpizzas.data.BellyExercise;
import de.deftone.bitsandpizzas.data.LegExercise;
import de.deftone.bitsandpizzas.data.StretchingExercise;
import de.deftone.bitsandpizzas.utils.CaptionedImagesAdapter;

import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_ID;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_TYPE;
import static de.deftone.bitsandpizzas.activities.MainActivity.BACK_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.BELLY_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.CREATED_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.STRETCHING_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE;
import static de.deftone.bitsandpizzas.data.CreatedExercise.CREATED_EXERCISES_LIST;

public class ExerciseFragment extends Fragment {

    public ExerciseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Bundle bundle = this.getArguments();
        String[] exerciseNames = {""};
        int[] exerciseImages = {0};

        if (bundle != null) {
            switch (bundle.getString(TYPE)) {
                case LEG_EXERCISES:
                    exerciseNames = new String[LegExercise.LEG_EXERCISES.length];
                    for (int i = 0; i < exerciseNames.length; i++) {
                        exerciseNames[i] = LegExercise.LEG_EXERCISES[i].getName();
                    }
                    exerciseImages = new int[LegExercise.LEG_EXERCISES.length];
                    for (int i = 0; i < exerciseImages.length; i++) {
                        exerciseImages[i] = LegExercise.LEG_EXERCISES[i].getImageResourceId();
                    }
                    break;
                case BACK_EXERCISES:
                    exerciseNames = new String[BackExercise.BACK_EXERCISES.length];
                    for (int i = 0; i < exerciseNames.length; i++) {
                        exerciseNames[i] = BackExercise.BACK_EXERCISES[i].getName();
                    }
                    exerciseImages = new int[BackExercise.BACK_EXERCISES.length];
                    for (int i = 0; i < exerciseImages.length; i++) {
                        exerciseImages[i] = BackExercise.BACK_EXERCISES[i].getImageResourceId();
                    }
                    break;
                case BELLY_EXERCISES:
                    exerciseNames = new String[BellyExercise.BELLY_EXERCISES.length];
                    for (int i = 0; i < exerciseNames.length; i++) {
                        exerciseNames[i] = BellyExercise.BELLY_EXERCISES[i].getName();
                    }
                    exerciseImages = new int[BellyExercise.BELLY_EXERCISES.length];
                    for (int i = 0; i < exerciseImages.length; i++) {
                        exerciseImages[i] = BellyExercise.BELLY_EXERCISES[i].getImageResourceId();
                    }
                    break;
                case STRETCHING_EXERCISES:
                    exerciseNames = new String[StretchingExercise.STRETCHING_EXERCISES.length];
                    for (int i = 0; i < exerciseNames.length; i++) {
                        exerciseNames[i] = StretchingExercise.STRETCHING_EXERCISES[i].getName();
                    }
                    exerciseImages = new int[StretchingExercise.STRETCHING_EXERCISES.length];
                    for (int i = 0; i < exerciseImages.length; i++) {
                        exerciseImages[i] = StretchingExercise.STRETCHING_EXERCISES[i].getImageResourceId();
                    }
                    break;
                case CREATED_EXERCISES:
                    int max = CREATED_EXERCISES_LIST.size();
                    exerciseNames = new String[max];
                    for (int i = 0; i < max; i++) {
                        exerciseNames[i] = CREATED_EXERCISES_LIST.get(i).getName();
                    }
                    exerciseImages = new int[max];
                    for (int i = 0; i < max; i++) {
                        exerciseImages[i] = CREATED_EXERCISES_LIST.get(i).getImageResourceId();
                    }
                    break;
            }
        }

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view_exercises, container, false);

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(exerciseNames, exerciseImages);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), ExerciseDetailActivity.class);
                intent.putExtra(EXTRA_EXERCISE_ID, position);
                intent.putExtra(EXTRA_EXERCISE_TYPE, bundle.getString(TYPE));
                getActivity().startActivity(intent);
            }
        });
        return recyclerView;
    }
}
