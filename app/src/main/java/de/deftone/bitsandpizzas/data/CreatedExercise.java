package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;
import java.util.List;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 * <p>
 * <p>
 * // ● : "\u25CF"
 * // ➡ : "\u27A1"
 * // finger point up  "\u261D"
 * //sparkles "\u2728"
 * //muscle "\uD83D\uDCAA"
 */

public class CreatedExercise {

    public static final int TYPE_LEG = 0;
    private final int TYPE_BELLY = 1;
    private final int TYPE_BACK = 2;

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;

    private static int max = 11;
    private static int count = 6;

    public static List<CreatedExercise> CREATED_EXERCISES_LIST;

    private CreatedExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
        this.seconds = seconds;
    }

    public static final void generateRandomExercises() {
        //LegExercises: random numbers
        List<Integer> randomInts = generateRandomArray(max, count, TYPE_LEG);

        //LegExercises: random exercises
        CREATED_EXERCISES_LIST = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            CREATED_EXERCISES_LIST.add(new CreatedExercise(LegExercise.LEG_EXERCISES[randomInts.get(i)].getName(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getIcon(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getDescription(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getImageResourceId(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getSeconds()));
        }
    }

    /**
     * max = maximale Anzahl an vorhandenen Uebungen
     * count = size of generated random array
     **/
    static List<Integer> generateRandomArray(int max, int count, int type) {
        List<Integer> randomInts = new ArrayList<>();
        int randomNumber = 0;
//        switch () todo: die anderen noch hinzufuegen mit switch
        if (type == TYPE_LEG)
            randomInts.add(0);

        while (randomInts.size() < count) {
            randomNumber = (int) Math.floor(Math.random() * max);
            if (!randomInts.contains(randomNumber)) {
                randomInts.add(randomNumber);
            }
        }
        return randomInts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setIcon(String[] icon) {
        this.icon = icon;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
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
