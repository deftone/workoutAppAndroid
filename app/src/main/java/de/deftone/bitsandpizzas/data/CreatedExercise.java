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

    private static final int TYPE_LEG = 0;
    private final int TYPE_BELLY = 1;
    private final int TYPE_BACK = 2;

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;


//    public static final CreatedExercise[] CREATED_EXERCISES = {
//            //add 6 of each - maybe more for belly?!
//            //make sure special exercises are always included
//
//            //und dann hierum eine forschleife, die statt 1 diese 6 werte nutzt
//            new CreatedExercise(LegExercise.LEG_EXERCISES[1].getName(),
//                    LegExercise.LEG_EXERCISES[1].getIcon(),
//                    LegExercise.LEG_EXERCISES[1].getDescription(),
//                    LegExercise.LEG_EXERCISES[1].getImageResourceId(),
//                    LegExercise.LEG_EXERCISES[1].getSeconds()),
//
//            //add BellyExercises =14
//            new CreatedExercise(BellyExercise.BELLY_EXERCISES[1].getName(),
//                    BellyExercise.BELLY_EXERCISES[1].getIcon(),
//                    BellyExercise.BELLY_EXERCISES[1].getDescription(),
//                    BellyExercise.BELLY_EXERCISES[1].getImageResourceId(),
//                    BellyExercise.BELLY_EXERCISES[1].getSeconds()),
//
//            //add BackExercises =8
//            new CreatedExercise(BackExercise.BACK_EXERCISES[1].getName(),
//                    BackExercise.BACK_EXERCISES[1].getIcon(),
//                    BackExercise.BACK_EXERCISES[1].getDescription(),
//                    BackExercise.BACK_EXERCISES[1].getImageResourceId(),
//                    BackExercise.BACK_EXERCISES[1].getSeconds())
//    };

    private CreatedExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
        this.seconds = seconds;
    }

    //todo: hier ist der kern des uebels: es wird jedesmal ein neues erzeugt, bei jedem aufruf... es sollte immer nur eine neue List erzeugt werden
    //wenn auf das + im menu geclickt wird, aber nicht wenn man die details ansehen moechte
    public static final List<CreatedExercise> generateRandomExercises() {
        //LegExercises: random numbers
        int max = 11;
        int count = 6;
        List<Integer> randomInts = generateRandomArray(max, count, TYPE_LEG);

        //LegExercises: random exercises
        List<CreatedExercise> createdExercises = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            createdExercises.add(new CreatedExercise(LegExercise.LEG_EXERCISES[randomInts.get(i)].getName(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getIcon(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getDescription(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getImageResourceId(),
                    LegExercise.LEG_EXERCISES[randomInts.get(i)].getSeconds()));
        }
        return createdExercises;
    }

    /**
     * max = maximale Anzahl an vorhandenen Uebungen
     * count = size of generated random array
     **/
    private static List<Integer> generateRandomArray(int max, int count, int type) {
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
