package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deftone on 10.11.17.
 */

public class CreatedExercise {

    public static final int TYPE_LEG = 0;
    public static final int TYPE_BELLY = 1;
    public static final int TYPE_BACK = 2;

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;

    private static int maxLegs = 11;
    private static int countLegs = 6;
    private static int maxBelly = 14;
    private static int countBelly = 10;
    private static int maxBack = 8;
    private static int countBack = 6;

    public static List<CreatedExercise> CREATED_EXERCISES_LIST;

    private CreatedExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
        this.seconds = seconds;
    }

    public static final void generateRandomExercises() {
        List<Integer> randomInts = generateRandomArray(maxLegs, countLegs, TYPE_LEG);
        CREATED_EXERCISES_LIST = new ArrayList<>();
        for (int i = 0; i < countLegs; i++) {
            CREATED_EXERCISES_LIST.add(new CreatedExercise(LegExercise.LEG_EXERCISES[randomInts.get(i)].getName(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getIcon(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getDescription(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getImageResourceId(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getSeconds()));
        }
        randomInts = generateRandomArray(maxBelly, countBelly, TYPE_BELLY);
        for (int i = 0; i < countBelly; i++) {
            CREATED_EXERCISES_LIST.add(new CreatedExercise(BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getName(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getIcon(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getDescription(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getImageResourceId(),
                    BellyExercise.BELLY_EXERCISES[randomInts.get(i)].getSeconds()));
        }
        randomInts = generateRandomArray(maxBack, countBack, TYPE_BACK);
        for (int i = 0; i < countBack; i++) {
            CREATED_EXERCISES_LIST.add(new CreatedExercise(BackExercise.BACK_EXERCISES[randomInts.get(i)].getName(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getIcon(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getDescription(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getImageResourceId(),
                    BackExercise.BACK_EXERCISES[randomInts.get(i)].getSeconds()));
        }
    }

    /**
     * maxLegs = maximale Anzahl an vorhandenen Uebungen
     * countLegs = size of generated random array
     **/
    static List<Integer> generateRandomArray(int max, int count, int type) {
        List<Integer> randomInts = new ArrayList<>();
        int randomNumber = 0;
        switch (type) {
            case TYPE_LEG:
                randomInts.add(0);
                randomInts.add(3);
                break;
            case TYPE_BELLY:
                randomInts.add(8);
                randomInts.add(10);
                break;
            case TYPE_BACK:
                randomInts.add(0);
                randomInts.add(1);
                break;
        }

        while (randomInts.size() < count) {
            randomNumber = (int) Math.floor(Math.random() * max);
            if (!randomInts.contains(randomNumber)) {
                randomInts.add(randomNumber);
            }
        }
        return randomInts;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String[] getDescription() {
        return desc;
    }

    public String[] getIcon() {
        return icon;
    }

    public int getSeconds() {
        return seconds;
    }
}
