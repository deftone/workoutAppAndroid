package de.deftone.bitsandpizzas.data;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 * finger point up ☝: "\u261D"
 * relaxed smilie ☺ "\u263a"
 * ● : "\u25CF"
 * ► : "\u261D"
 * ▶ : "\u25B6"
 * ☀ : "\u2600"
 * ❤ : "\u2764"
 * ➡ : "\u27A1"
 * ghost	"\uD83D\uDC7B"
 * muscle "\uD83D\uDCAA"
 *
 // ● : "\u25CF"
 // ➡ : "\u27A1"
 // finger point up  "\u261D"
 //sparkles "\u2728"
 //muscle "\uD83D\uDCAA"
 */


public class LegExercise {

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;

    public static final LegExercise[] LEG_EXERCISES = {
            new LegExercise("Kniebeuge im Ausfallschritt",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u261D", "\u261D", "\uD83D\uDCAA"},
                    new String[]{"mit leicht gebeugten Knien stehen",
                            "Füsse großen Schrittabstand entfernt ",
                            "Oberkörper gerade, vorgestreckte Brust ",
                            "dann das vordere Knie beugen, bis Oberschenkel waagerecht und wieder aufrichten ",
                            "je größer der Abstand, desto mehr Gesäßmuskel ",
                            "je kleiner der Abstand, desto mehr Oberschenkelmuskel ",
                            "mehrere Wiederholungen (10-20) pro Seite "},
                    R.drawable.ausfallschritt),

            new LegExercise("Kniebeugen",
                    new String[]{"\u25CF", "\u25CF", "\u261D", "\u27A1", "\u27A1", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"mit gestreckten Armen, leicht gegrätschten Füßen stehen",
                            "Kopf gerade, Brust raus, ganz leichtes Hohlkreuz",
                            "die Fersen dürfen sich nicht vom Boden heben, Rücken gerade",
                            "kontrolliert in die Knie gehen, bis die Oberschenkel waagerecht sind",
                            "dann wieder aufrichten in die Ausgangsposition",
                            "Varianten: Beine Schulterbreit oder weit grätscht",
                            "viele Wiederholungen (mind. 30)"},
                    R.drawable.kniebeugen),

            new LegExercise("Bein seitlich im 4-Füßler heben",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"in den Vierfüßlerstand gehen",
                            "Gewicht auf einem Bein, Arme gesreckt",
                            "das Bein zur Seite anheben, 1 Sek halten und dann wieder senken",
                            "wenn das Knie leicht angeboben wird (1cm) statt auf dem Boden aufzusetzen kann die Intensität erhöht werden",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.bein_seitlich_heben_4_fuessler),

            new LegExercise("Knie heben im Vierfüßler",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u261D", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"in den Vierfüßlerstand gehen",
                            "beide Knie leicht (1 cm) vom Boden heben",
                            "langsam ein Bein in der angewinkelten Stellung nach oben heben und wieder zurück ",
                            "kein Knie berührt während der Übung den Boden",
                            "leichte Variante: nicht bewegendes Knie setzt auf",
                            "10 Wiederholungen pro Seite"
                    },
                    R.drawable.vierfuessler_knie_heben),

            new LegExercise("Beckenheben vom Boden",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"auf dem Rücken liegen, Beine sind aufgestellt ",
                            "Arme liegen entlang dem Körper, Handflächen auf dem Boden",
                            "Becken vom Boden heben, oben 2 Sekunden halten",
                            "Becken wieder absinken, ohne ganz abzusetzen",
                            "mehrere Wiederholungen (mind. 30)"},
                    R.drawable.schulterbruecke),

            new LegExercise("Bein heben in Schulterbrücke",
                    new String[]{"\u25CF", "\u261D", "\u27A1", "\u27A1", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"in die Schulterbrücke gehen",
                            "das Becken bleibt die ganze Zeit oben",
                            "ein Bein vom Boden abheben und langsam hoch (senkrecht zum Boden) heben",
                            "und wieder absenken, bis es parallel zum anderen Bein ist",
                            "einfache Variante: ohne Beinheben, nur Halten",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.schulterbruecke_bein_heben),

            new LegExercise("Oberes Bein im Liegen heben",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u27A1", "\u261D", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"seitlich auf dem Boden liegen ",
                            "mit dem Unterarm abstützen, der Kopf ist aufrecht",
                            "das gestreckte Bein seitlich nach oben heben",
                            "das Bein bleibt die ganze Zeit gestreckt ",
                            "den Winkel nicht zu gross werden lassen (max. 70°)",
                            " man kann das Bein im maximal Punkt einige Sekunden halten",
                            " 20 Wiederholungen pro Seite "},
                    R.drawable.bein_seitlich_heben),

            new LegExercise("Unteres Bein im Liegen heben",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"seitlich auf dem Boden liegen, auf unteren Ellebogen stützen",
                            "unteres Bein gestreckt, oberes Bein gebeugt, Fuß for dem liegenden Knie",
                            "liegendes Bein gestreckt so hoch wie möglich heben",
                            "am maximalen Punkt 2-3 Sekunden halten und wieder absenken",
                            "20 Wiederholungen pro Seite"
                    },
                    R.drawable.abduktion_am_boden)
    };

    private LegExercise(String name, String[] icon, String[] desc, int imageResourceId) {
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
