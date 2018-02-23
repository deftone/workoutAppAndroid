package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;
import java.util.List;

import static de.deftone.bitsandpizzas.activities.MainActivity.backExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.bellyExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.combiExercises;
import static de.deftone.bitsandpizzas.activities.MainActivity.ALL_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.activities.MainActivity.stretchingExercises;

/**
 * Created by deftone on 10.11.17.
 */

public class CreatedExercise extends Exercise {

    public static final int TYPE_LEG = 0;
    public static final int TYPE_BELLY = 1;
    public static final int TYPE_BACK = 2;
    public static final int TYPE_COMBI = 3;
    public static final int TYPE_STRETCH = 4;


    private static int maxLegs = ALL_LEG_EXERCISES.size();
    private static int maxBelly = bellyExercises.size();
    private static int maxBack = backExercises.size();
    private static int maxCombi = combiExercises.size();
    private static int maxStretch = stretchingExercises.size();

    public static List<CreatedExercise> CREATED_EXERCISES_LIST;

    protected CreatedExercise(int id, ExerciseTypes type, String name, String[] icon, String[] desc, int imageResourceId, int seconds, int[] weight) {
        super(id, type, name, icon, desc, imageResourceId, seconds, weight);
    }

    public static final void generateRandomExercises(int countLegs, int countBelly, int countBack,
                                                     int countCombi, int countStretching) {
        List<Integer> randomInts = generateRandomArray(maxLegs, countLegs);
        CREATED_EXERCISES_LIST = new ArrayList<>();
        for (int i = 0; i < countLegs; i++) {
            addExerciseToList(ALL_LEG_EXERCISES.get(randomInts.get(i)));
//            CREATED_EXERCISES_LIST.add(new CreatedExercise(
//                    ALL_LEG_EXERCISES.get(randomInts.get(i)).getId(),
//                    ALL_LEG_EXERCISES.get(randomInts.get(i)).getType(),
//                    ALL_LEG_EXERCISES.get(randomInts.get(i)).getName(),
//                    ALL_LEG_EXERCISES.get(randomInts.get(i)).getIcon(),
//                    ALL_LEG_EXERCISES.get(randomInts.get(i)).getDescription(),
//                    ALL_LEG_EXERCISES.get(randomInts.get(i)).getImageResourceId(),
//                    ALL_LEG_EXERCISES.get(randomInts.get(i)).getSeconds(),
//                    ALL_LEG_EXERCISES.get(randomInts.get(i)).getWeight()));
        }

        randomInts = generateRandomArray(maxBelly, countBelly);
        for (int i = 0; i < countBelly; i++)
            addExerciseToList(bellyExercises.get(randomInts.get(i)));

        randomInts = generateRandomArray(maxBack, countBack);
        for (int i = 0; i < countBack; i++)
            addExerciseToList(backExercises.get(randomInts.get(i)));

        randomInts = generateRandomArray(maxCombi, countCombi);
        for (int i = 0; i < countCombi; i++)
            addExerciseToList(combiExercises.get(randomInts.get(i)));

        randomInts = generateRandomArray(maxStretch, countStretching);
        for (int i = 0; i < countStretching; i++)
            addExerciseToList(stretchingExercises.get(randomInts.get(i)));

    }

    private static void addExerciseToList(Exercise exercise) {
        CREATED_EXERCISES_LIST.add(new CreatedExercise(
                exercise.getId(),
                exercise.getType(),
                exercise.getName(),
                exercise.getIcon(),
                exercise.getDescription(),
                exercise.getImageResourceId(),
                exercise.getSeconds(),
                exercise.getWeight()));
    }

    /**
     * maxLegs = maximale Anzahl an vorhandenen Uebungen
     * countLegs = size of generated random array
     **/
    static List<Integer> generateRandomArray(int max, int count) {
        List<Integer> randomInts = new ArrayList<>();
        int randomNumber;
        if (count > max) {
            //this should not happen
            return randomInts;
        }

        while (randomInts.size() < count) {
            randomNumber = (int) Math.floor(Math.random() * max);
            if (!randomInts.contains(randomNumber)) {
                randomInts.add(randomNumber);
            }
        }
        return randomInts;
    }
}
