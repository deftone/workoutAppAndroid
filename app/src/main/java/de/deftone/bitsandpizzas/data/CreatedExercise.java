package de.deftone.bitsandpizzas.data;

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

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;

    public static final CreatedExercise[] CREATED_EXERCISES = {

         //todo: diese hier durch die anderen erzeugen, so wie aktuell in ExerciseFragment, damit der onClickListener das richtige object anzeigt
    };

    private CreatedExercise(String name, String[] icon, String[] desc, int imageResourceId) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
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
}
