package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;

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

    private static ArrayList randomLegInts;
    public static final CreatedExercise[] CREATED_EXERCISES = {
            //add 6 of each - maybe more for belly?!
            //make sure special exercises are always included

            //meine idee:
            //leg hat 11 uebungen
            //eine funktion, die 6 zufaellige ints von 0 bis 11 ausspuckt: generateRandomArray (s.u.)

            //und dann hierum eine forschleife, die statt 1 diese 6 werte nutzt
            new CreatedExercise(LegExercise.LEG_EXERCISES[1].getName(),
                    LegExercise.LEG_EXERCISES[1].getIcon(),
                    LegExercise.LEG_EXERCISES[1].getDescription(),
                    LegExercise.LEG_EXERCISES[1].getImageResourceId(),
                    LegExercise.LEG_EXERCISES[1].getSeconds()),

//            also ungefaehr sowas:
//            randomLegInts = generateRandomArray(11, 6, TYPE_LEG);
//            for (int i=0; i<6; i++){
//                new CreatedExercise(LegExercise.LEG_EXERCISES[randomLegInts.get(i)].getName(),
//                        LegExercise.LEG_EXERCISES[randomLegInts.get(i)].getIcon(),
//                        LegExercise.LEG_EXERCISES[randomLegInts.get(i)].getDescription(),
//                        LegExercise.LEG_EXERCISES[randomLegInts.get(i)].getImageResourceId(),
//                        LegExercise.LEG_EXERCISES[randomLegInts.get(i)].getSeconds()),
//             }

            //add BellyExercises =14
            new CreatedExercise(BellyExercise.BELLY_EXERCISES[1].getName(),
                    BellyExercise.BELLY_EXERCISES[1].getIcon(),
                    BellyExercise.BELLY_EXERCISES[1].getDescription(),
                    BellyExercise.BELLY_EXERCISES[1].getImageResourceId(),
                    BellyExercise.BELLY_EXERCISES[1].getSeconds()),

            //add BackExercises =8
            new CreatedExercise(BackExercise.BACK_EXERCISES[1].getName(),
                    BackExercise.BACK_EXERCISES[1].getIcon(),
                    BackExercise.BACK_EXERCISES[1].getDescription(),
                    BackExercise.BACK_EXERCISES[1].getImageResourceId(),
                    BackExercise.BACK_EXERCISES[1].getSeconds())
    };

    private CreatedExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
        this.seconds = seconds;
    }

    //max = maximale Anzahl an vorhandenen Uebungen
    //count = size of generated random array
    private static ArrayList generateRandomArray(int max, int count, int type) {
        ArrayList<Integer> randomInts = new ArrayList<>();
        int randomNumber = 0;
        //todo: add special exercises for each type
        while (randomInts.size() < count) {
            randomNumber = (int) Math.floor(Math.random() * max) + 1;
            if (!randomInts.contains(randomNumber))
                randomInts.add(randomNumber);
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
