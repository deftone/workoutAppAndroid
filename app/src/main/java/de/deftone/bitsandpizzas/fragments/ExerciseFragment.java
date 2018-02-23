package de.deftone.bitsandpizzas.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.deftone.bitsandpizzas.R;
import de.deftone.bitsandpizzas.activities.ExerciseDetailActivity;
import de.deftone.bitsandpizzas.data.CreatedExercise;
import de.deftone.bitsandpizzas.data.Exercise;
import de.deftone.bitsandpizzas.helper.CaptionedImagesAdapter;

import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_ID;
import static de.deftone.bitsandpizzas.activities.ExerciseDetailActivity.EXTRA_EXERCISE_TYPE;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_BACK_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_BELLY_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_COMBI_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_CREATED_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE_STRETCHING_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.TYPE;
import static de.deftone.bitsandpizzas.activities.MainActivity.backExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.bellyExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.combiExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.ALL_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.stretchingExercises;
import static de.deftone.bitsandpizzas.data.CreatedExercise.CREATED_EXERCISES_LIST;

public class ExerciseFragment extends Fragment {

    private static final String SAVED_LAYOUT_MANAGER = "classname.recycler.layout";//????
    private RecyclerView recyclerView;
    private Parcelable layoutManagerSavedState;

    public ExerciseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Bundle bundle = this.getArguments();
        List<String> exerciseNames = new ArrayList<>();
        List<Integer> exerciseImages = new ArrayList<>();

        if (bundle != null) {
            switch (bundle.getString(TYPE)) {
                case TYPE_LEG_EXERCISES:
                    for (Exercise exercise : ALL_LEG_EXERCISES) {
                        exerciseNames.add(exercise.getName());
                        exerciseImages.add(exercise.getImageResourceId());
                    }
                    break;
                case TYPE_BACK_EXERCISES:
                    for (Exercise exercise : backExercises) {
                        exerciseNames.add(exercise.getName());
                        exerciseImages.add(exercise.getImageResourceId());
                    }
                    break;
                case TYPE_BELLY_EXERCISES:
                    for (Exercise exercise : bellyExercises) {
                        exerciseNames.add(exercise.getName());
                        exerciseImages.add(exercise.getImageResourceId());
                    }
                    break;
                case TYPE_COMBI_EXERCISES:
                    for (Exercise exercise : combiExercises) {
                        exerciseNames.add(exercise.getName());
                        exerciseImages.add(exercise.getImageResourceId());
                    }
                    break;
                case TYPE_STRETCHING_EXERCISES:
                    for (Exercise exercise : stretchingExercises) {
                        exerciseNames.add(exercise.getName());
                        exerciseImages.add(exercise.getImageResourceId());
                    }
                    break;
                case TYPE_CREATED_EXERCISES:
                    for (CreatedExercise exercise : CREATED_EXERCISES_LIST) {
                        exerciseNames.add(exercise.getName());
                        exerciseImages.add(exercise.getImageResourceId());
                    }
                    break;
            }
        }

        recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view_exercises, container, false);

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

//    //todo: it would be great if the correct position would be shown too, i.e. scrolled where it was before
//    //http://panavtec.me/retain-restore-recycler-view-scroll-position
//    //oder das hier:
//    //https://stackoverflow.com/questions/27816217/how-to-save-recyclerviews-scroll-position-using-recyclerview-state
//    //ich glaube das muss alles in das fragment rein.... oder doch in die activity? keine ahnung, funktioniert in beiden nicht
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
