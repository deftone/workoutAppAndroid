package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deftone on 10.11.17.
 */

public class CreatedExercise extends Exercise {

    public static final int TYPE_LEG = 0;
    public static final int TYPE_BELLY = 1;
    public static final int TYPE_BACK = 2;


    private static int maxLegs;

    static int mandatoryLegs[] = {0, 3};
    private static int maxBelly;
    static int mandatoryBelly[] = {8, 10};
    private static int maxBack;
    static int mandatoryBack[] = {0, 1};

    public static List<CreatedExercise> CREATED_EXERCISES_LIST;

    protected CreatedExercise(int id, ExerciseTypes type, String name, String[] icon, String[] desc, int imageResourceId, int seconds, int[] weight) {
        super(id, type, name, icon, desc, imageResourceId, seconds, weight);
    }


    public static final void generateRandomExercises(int countLegs, int countBelly, int countBack, boolean mandatory) {
        maxLegs = LegExercise.LEG_EXERCISES.length;
        List<Integer> randomInts = generateRandomArray(maxLegs, countLegs, TYPE_LEG, mandatory);
        CREATED_EXERCISES_LIST = new ArrayList<>();
        for (int i = 0; i < countLegs; i++) {
            CREATED_EXERCISES_LIST.add(new CreatedExercise(LegExercise.LEG_EXERCISES[randomInts.get(i)].getName(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getIcon(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getDescription(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getImageResourceId(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getSeconds(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getWeight()));
        }

        maxBelly = BellyExercise.BELLY_EXERCISES.length;
        randomInts = generateRandomArray(maxBelly, countBelly, TYPE_BELLY, mandatory);
        for (int i = 0; i < countBelly; i++) {
            CREATED_EXERCISES_LIST.add(new CreatedExercise(BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getName(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getIcon(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getDescription(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getImageResourceId(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getSeconds(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getWeight()));
        }

        maxBack = BackExercise.BACK_EXERCISES.length;
        randomInts = generateRandomArray(maxBack, countBack, TYPE_BACK, mandatory);
        for (int i = 0; i < countBack; i++) {
            CREATED_EXERCISES_LIST.add(new CreatedExercise(BackExercise.BACK_EXERCISES[randomInts.get(i)].getName(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getIcon(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getDescription(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getImageResourceId(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getSeconds(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getWeight()));
        }
    }

    /**
     * maxLegs = maximale Anzahl an vorhandenen Uebungen
     * countLegs = size of generated random array
     **/
    static List<Integer> generateRandomArray(int max, int count, int type, boolean mandatory) {
        List<Integer> randomInts = new ArrayList<>();
        int randomNumber;
        if (mandatory)
            switch (type) {
                case TYPE_LEG:
                    for (int i : mandatoryLegs)
                        randomInts.add(i);
                    break;
                case TYPE_BELLY:
                    for (int i : mandatoryBelly)
                        randomInts.add(i);
                    break;
                case TYPE_BACK:
                    for (int i : mandatoryBack)
                        randomInts.add(i);
                    break;
            }
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
