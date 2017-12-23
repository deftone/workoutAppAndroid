package de.deftone.bitsandpizzas.data;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 */

public class HoldExercise {

    private String name;
    private String[] icon;
    private String[] desc;
    private int imageResourceId;
    private int seconds;

    public static final HoldExercise[] HOLD_EXERCISES = {
            new HoldExercise("Unterarmstütz",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"auf den Unterarmen auf den Boden aufstützen",
                            "Fußspitzen sind aufgestützt",
                            "Rücken gerade halten",
                            "einfache Variante: mit den Knien auf dem Boden abstützen",
                            "eine Minute halten, dabei normal atmen"},
                    R.drawable.unterarmstuetz,
                    60),

            new HoldExercise("Unterarmstütz 2",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u2728", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"auf den Unterarmen auf den Boden aufstützen",
                            "Fußspitzen sind aufgestützt",
                            "Rücken gerade halten",
                            "einfache Variante: mit den Knien auf dem Boden abstützen",
                            "ein Bein gestreckt abheben und wieder absinken",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.unterarmstuetz_mit_heben,
                    0),

            new HoldExercise("Seitenstütz",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"seitlich auf einem Unterarm auf den Boden aufstützen",
                            "Körper ist eine Linie",
                            "freien Arm in die Luft strecken oder auf der Hüfte abstützen",
                            "einfache Variante: mit den Knien auf dem Boden abstützen",
                            "jede Seite 30 Sekunden halten, dabei normal atmen"},
                    R.drawable.seitstuetz,
                    30),

            new HoldExercise("Boot",
                    new String[]{"\u25CF", "\u27A1", "\u27A1", "\u261D", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"aufrecht mit angewinkelten Knien hinsetzen",
                            "Oberkörper leicht zurücklehnen",
                            "ein Bein nach dem anderen anheben",
                            "Arme und Beine sind gestreckt",
                            "einfache Variante: die Hände umfassen die Knie",
                            "30 Sekunden halten"},
                    R.drawable.boot,
                    30),

            new HoldExercise("Standwaage",
                    new String[]{"\u25CF", "\u27A1", "\u27A1", "\u27A1", "\u261D", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"aufrecht stehen, Arme nach oben strecken",
                            "Oberkörper nach vorne beugen",
                            "gleichzeitig ein Bein so weit wie möglich heben",
                            "Ferse nach hinten strecken, Zehen zum Körper ziehen",
                            "Arme, Oberkörper und das gestreckte Bein bilden eine Linie",
                            "je höher das Bein, je weicher der Boden, desto schwieriger",
                            "jede Seite 30 Sekunden halten"},
                    R.drawable.standwaage,
                    30),

            new HoldExercise("Einbeinhalteübung",
                    new String[]{"\u25CF", "\u27A1", "\u2728", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"hüftbreiter, gerader Stand",
                            "leicht in die Hocken gehen und ein Bein angewinkelt über das Standbein legen",
                            "für mehr Intenstät stärker in die Hocke gehen",
                            "die Arme nach vorne oder oben strecken",
                            "jede Seite 30 Sekunden halten"},
                    R.drawable.ein_bein_stand,
                    30),

            new HoldExercise("Leg Pull Up",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u261D", "\u261D", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"Hände flach auf dem Boden",
                            "Finger zeigen zu den Füßen",
                            "Arme gestreckt, Hände unter den Schultern",
                            "Gesäßmuskeln anspannen",
                            "Körper von Zehen bis Schultern auf einer schrägen Linie halten",
                            "Blick nach vorne",
                            "ein Bein langsam nach oben heben und wieder absenken",
                            "die Hüften dabei hoch und parallel halten",
                            "das Standbein darf sich nicht nach außen drehen",
                            "einfache Variante: kein Bein heben und nur halten",
                            "maximal 10 Wiederholungen pro Seite"},
                    R.drawable.leg_pull_up,
                    0),

            new HoldExercise("Leg Pull Down",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u27A1", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"mit gestützen Arme auf die Hände stützen",
                            "Schultern über den Handgelenken",
                            "Fersen über den Zehen",
                            "Blick auf den Boden",
                            "Körper bildet eine Linie",
                            "ein Bein heben, dabei den Fuss strecken",
                            "dann das Bein wieder absenken",
                            "einfache Variante: kein Bein heben und nur halten",
                            "maximal 10 Wiederholungen pro Seite"},
                    R.drawable.leg_pull_down,
                    0),

            new HoldExercise("Unterarmstütz 2",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u261D", "\uD83D\uDCAA"},
                    new String[]{"in Rückenlage auf dem Boden",
                            "Ellebogen neben dem Körper aufgestützt",
                            "Oberkörper und Becken anheben",
                            "Körper ist von Kopf bis Fuss ein Brett",
                            "30 Sekunden halten"},
                    R.drawable.unterarm_ruecklings,
                    30),

            new HoldExercise("Side Kick kniend",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"Haltung wie auf Bild einnehmen",
                            "auf linke Hand stützen, rechte Hand an Hinterkopf",
                            "rechtes Bein ausstrecken und auf Hüfthöhe heben",
                            "Bein so weit wie möglich auf einer Ebene nach vorne und wieder nach hinten bewegen",
                            " 10 Wiederholungen pro Seite"},
                    R.drawable.side_kick_knie,
                    0)
    };

    private HoldExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds) {
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
