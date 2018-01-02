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

public class StretchingExercise {

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;

    public static final StretchingExercise[] STRETCHING_EXERCISES = {
            //01
            new StretchingExercise("Hüfte dehnen",
                    new String[]{},
                    new String[]{},
                    R.drawable.dehnung_huefte,
                    30),
            //02
            new StretchingExercise("Schultern strecken",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\uD83D\uDCAA"},
                    new String[]{"vor die Wand stellen",
                            "Beine durchstrecken",
                            "nach vorne lehnen (90° zwischen Rumpf und Beinen)",
                            "Handflächen so hoch wie möglich an die Wand",
                            "30 Sekunden halten"},
                    R.drawable.schultern_strecken,
                    30),
            //03
            new StretchingExercise("Held",
                    new String[]{},
                    new String[]{},
                    R.drawable.held,
                    30),
            //04
            new StretchingExercise("Heldendreieck sanft",
                    new String[]{},
                    new String[]{},
                    R.drawable.held_dreieck_sanft,
                    30),
            //05
            new StretchingExercise("Heldendreick",
                    new String[]{},
                    new String[]{},
                    R.drawable.held_dreieck,
                    30),
            //06
            new StretchingExercise("Twist",
                    new String[]{},
                    new String[]{},
                    R.drawable.yoga_twist,
                    30),
            //07
            new StretchingExercise("Kobra",
                    new String[]{},
                    new String[]{},
                    R.drawable.kobra,
                    30),
            //08
            new StretchingExercise("herabschauender Hund",
                    new String[]{},
                    new String[]{},
                    R.drawable.herabschauender_hund,
                    30),
            //09
            new StretchingExercise("Kamel",
                    new String[]{"\u25CF", "\u27A1", "\u27A1", "\u261D", "\u261D", "\u261D", "\uD83D\uDCAA"},
                    new String[]{"in den Kniestand gehen",
                            "beim Ausatmen Schultern nach hinten, Becken nach vorne schieben",
                            "weiter in die Rückenbeuge und mit Händen an Fersen greifen",
                            "Arme gestreckt",
                            "Hüfte über den Knien",
                            "Kopf und Nacken entspannt",
                            "30 Sekunden halten"},
                    R.drawable.kamel,
                    30),
            //10
            new StretchingExercise("Kind",
                    new String[]{},
                    new String[]{},
                    R.drawable.kind,
                    30),
    };

    private StretchingExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
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
