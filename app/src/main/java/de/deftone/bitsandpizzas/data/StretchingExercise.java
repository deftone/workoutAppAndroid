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
            new StretchingExercise("Dreick",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u2728", "\u27A1", "\u25CF", "\u261D", "\uD83D\uDCAA"},
                    new String[]{"Beine grätschen, rechten (vorderen) Fuß nach außen drehen",
                            "gestreckte Arme auf Schulterhöhe heben, Handflächen nach unten",
                            "beim Ausatmen rechten Arm nach unten, bis Hand neben Fuß aufsetzt",
                            "einfacher: Hand auf Unterschenkel aufsetzen",
                            "gleichzeitig linken Arm senkrecht nach oben strecken",
                            "Blick zur oberen Hand",
                            "beide Beine die ganze Zeit gestreckt",
                            "jede Seite 20 Sekunden halten"},
                    R.drawable.dreieck,
                    20),
            //02
            new StretchingExercise("Schultern strecken",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\uD83D\uDCAA"},
                    new String[]{"vor die Wand stellen",
                            "Beine durchstrecken",
                            "nach vorne lehnen (90° zwischen Rumpf und Beinen)",
                            "Handflächen so hoch wie möglich an die Wand",
                            "20 Sekunden halten"},
                    R.drawable.schultern_strecken,
                    20),
            //03
            new StretchingExercise("Held II",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u25CF", "\u261D", "\uD83D\uDCAA", "\u2728"},
                    new String[]{"weiter Ausfallschritt, vorderes Bein stark gebeugt, hinteres gestreckt",
                            "vorderer Fuß gerade, hinterer ca. 90° nach außen gedreht",
                            "Arme in einer Linie nach vorne bzw. hinten gestreckt",
                            "stabiler, aber lockerer Stand",
                            "Kiefer und Schultern sind entspannt",
                            "jede Seite 20 Sekunden halten",
                            "am besten von hier weiter zum Heldendreieck"},
                    R.drawable.held,
                    20),
            //04
            new StretchingExercise("Heldendreieck",
                    new String[]{"\u25CF", "\u27A1", "\u2728", "\u27A1", "\u25CF", "\uD83D\uDCAA", "\u2728"},
                    new String[]{"Held II Stellung einnehmen",
                            "vorderen Arm nach unten bringen: " +
                                    "Ellebogen auf Oberschenkel aufstützen (Bild)",
                            "anspruchsvoller: vordere Hand innen neben dem Fuß aufsetzen, " +
                                    "Arm ist gestreckt",
                            "hinteren Arm senkrecht nach oben strecken",
                            "Blick nach oben zu Fingern",
                            "jede Seite 20 Sekunden halten",
                            "am besten von hier weiter zum Heldentwist"},
                    R.drawable.held_dreieck_sanft,
                    20),
            //05
            new StretchingExercise("Heldentwist",
                    new String[]{"\u25CF", "\u27A1", "\u27A1", "\u27A1", "\u25CF", "\uD83D\uDCAA"},
                    new String[]{"Heldendreieck einnehmen",
                            "den oberen Arm hinter dem Rücken nach unten führen",
                            "mit dem unteren Arm das gebeugte Bein von unten umarmen",
                            "die Hände umfassen sich hinterm Rücken/Oberschenkel",
                            "Blick immer noch nach oben",
                            "jede Seite 20 Sekunden halten"},
                    R.drawable.yoga_twist,
                    20),
            //06
            new StretchingExercise("Ballerina",
                    new String[]{"\u25CF", "\u27A1", "\u27A1", "\u27A1", "\u25CF", "\uD83D\uDCAA"},
                    new String[]{"Grätschsitz rechtes Bein gestreckt, linkes angewinkelt oder auch gestreckt",
                            "den linken Arm nach oben führen und gemeinsam mit dem Oberkörper " +
                                    "zum rechten Bein sinken",
                            "versuchen mit der linken Hand den rechten Fuß zu fassen",
                            "den rechten Arm unten zum linken Bein führen",
                            "Blick nach oben",
                            "jede Seite 20 Sekunden halten"},
                    R.drawable.dehnung_huefte,
                    20),
            //07
            new StretchingExercise("Kobra",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u27A1", "\u25CF", "\uD83D\uDCAA"},
                    new String[]{"flach auf den Bauch liegen, Füße hüftbreit auseinander",
                            "Kopf und Fußspann liegen auf",
                            "Handflächen liegen neben dem Kopf auf, Unterarmee entspannt zum Boden",
                            "Hände in den Boden drücken, den Kopf heben und Wirbel für Wirbel den Oberkörper aufrichten",
                            "Schultern, Brust, Bauch nach oben heben, bis Arme gestreckt sind",
                            "Blick nach vorne oder oben richten",
                            "20 Sekunden halten"
                    },
                    R.drawable.kobra,
                    20),
            //08
            new StretchingExercise("herabschauender Hund",
                    new String[]{"\u25CF", "\u27A1", "\u25CF", "\u25CF", "\u261D", "\uD83D\uDCAA"},
                    new String[]{"Vierfüsslerstand, Hände etwas nach vorne setzen",
                            "die Hüfte heben, bis die Beine und Arme gestreckt sind",
                            "Finger sind gespreizt und drücken in den Boden",
                            "Fersen ziehen nach unten (setzen im Idealfall auf)",
                            "Nachen ist entspannt, Rücken ist gerade, macht dich lang",
                            "30 Sekunden halten"},
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
                    new String[]{"\u25CF", "\u27A1", "\u25CF", "\u25CF", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"Fersensitz, Hände auf den Oberschenkeln",
                            "Arme nach vorne ausstrecken und dabei den Oberkörper auf " +
                                    "den Oberschenkeln ablegen",
                            "die Stirn liegt auf dem Boden",
                            "der Po so nach wie möglich zu den Fersen bringen",
                            "Variante: die Arme neben dem Körper ablegen",
                            "Schultern, Nacken und Oberkörper 30 Sekunden entspannen"},
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
