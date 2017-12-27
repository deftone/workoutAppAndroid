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
 * <p>
 * // ● : "\u25CF"
 * // ➡ : "\u27A1"
 * // finger point up  "\u261D"
 * //sparkles "\u2728"
 * //muscle "\uD83D\uDCAA"
 */


public class LegExercise {

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;

    public static final LegExercise[] LEG_EXERCISES = {
            //0
            new LegExercise("Kniebeuge im Ausfallschritt",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\u261D", "\u261D", "\uD83D\uDCAA"},
                    new String[]{"mit leicht gebeugten Knien stehen",
                            "Füsse großen Schrittabstand entfernt ",
                            "Oberkörper gerade, vorgestreckte Brust ",
                            "dann das vordere Knie beugen, bis Oberschenkel waagerecht und wieder aufrichten ",
                            "je größer der Abstand, desto mehr Gesäßmuskel ",
                            "je kleiner der Abstand, desto mehr Oberschenkelmuskel ",
                            "mehrere Wiederholungen (10-20) pro Seite "},
                    R.drawable.ausfallschritt,
                    0),
            //1
            new LegExercise("Kniebeugen",
                    new String[]{"\u25CF", "\u25CF", "\u261D", "\u27A1", "\u27A1", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"mit gestreckten Armen, leicht gegrätschten Füßen stehen",
                            "Kopf gerade, Brust raus, ganz leichtes Hohlkreuz",
                            "die Fersen dürfen sich nicht vom Boden heben, Rücken gerade",
                            "kontrolliert in die Knie gehen, bis die Oberschenkel waagerecht sind",
                            "dann wieder aufrichten in die Ausgangsposition",
                            "Varianten: Beine Schulterbreit oder weit grätscht",
                            "viele Wiederholungen (mind. 30)"},
                    R.drawable.kniebeugen,
                    0),
            //2
            new LegExercise("Bein seitlich im 4-Füßler heben",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"in den Vierfüßlerstand gehen",
                            "Gewicht auf einem Bein, Arme gesreckt",
                            "das Bein zur Seite anheben, 1 Sek halten und dann wieder senken",
                            "wenn das Knie leicht angeboben wird (1cm) statt auf dem Boden aufzusetzen kann die Intensität erhöht werden",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.bein_seitlich_heben_4_fuessler,
                    0),
            //3
            new LegExercise("Knie heben im Vierfüßler",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u261D", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"in den Vierfüßlerstand gehen",
                            "beide Knie leicht (1 cm) vom Boden heben",
                            "langsam ein Bein in der angewinkelten Stellung nach oben heben und wieder zurück ",
                            "kein Knie berührt während der Übung den Boden",
                            "leichte Variante: nicht bewegendes Knie setzt auf",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.vierfuessler_knie_heben,
                    0),
            //4
            new LegExercise("Beckenheben vom Boden",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"auf dem Rücken liegen, Beine sind aufgestellt ",
                            "Arme liegen entlang dem Körper, Handflächen auf dem Boden",
                            "Becken vom Boden heben, oben 2 Sekunden halten",
                            "Becken wieder absinken, ohne ganz abzusetzen",
                            "mehrere Wiederholungen (mind. 30)"},
                    R.drawable.schulterbruecke,
                    0),
            //5
            new LegExercise("Bein heben in Schulterbrücke",
                    new String[]{"\u25CF", "\u261D", "\u27A1", "\u27A1", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"in die Schulterbrücke gehen",
                            "das Becken bleibt die ganze Zeit oben",
                            "ein Bein vom Boden abheben und langsam hoch (senkrecht zum Boden) heben",
                            "und wieder absenken, bis es parallel zum anderen Bein ist",
                            "einfache Variante: ohne Beinheben, nur Halten",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.schulterbruecke_bein_heben,
                    0),
            //6
            new LegExercise("Oberes Bein im Liegen heben",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u27A1", "\u261D", "\u2728", "\uD83D\uDCAA"},
                    new String[]{"seitlich auf dem Boden liegen ",
                            "mit dem Unterarm abstützen, der Kopf ist aufrecht",
                            "das gestreckte Bein seitlich nach oben heben",
                            "das Bein bleibt die ganze Zeit gestreckt ",
                            "den Winkel nicht zu gross werden lassen (max. 70°)",
                            " man kann das Bein im maximal Punkt einige Sekunden halten",
                            " 20 Wiederholungen pro Seite "},
                    R.drawable.bein_seitlich_heben,
                    0),
            //7
            new LegExercise("Unteres Bein im Liegen heben",
                    new String[]{"\u25CF", "\u25CF", "\u27A1", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"seitlich auf dem Boden liegen, auf unteren Ellebogen stützen",
                            "unteres Bein gestreckt, oberes Bein gebeugt, Fuß for dem liegenden Knie",
                            "liegendes Bein gestreckt so hoch wie möglich heben",
                            "am maximalen Punkt 2-3 Sekunden halten und wieder absenken",
                            "20 Wiederholungen pro Seite"},
                    R.drawable.abduktion_am_boden,
                    0),
            //8
            new LegExercise("Standwaage",
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
            //9
            new LegExercise("Einbeinhalteübung",
                    new String[]{"\u25CF", "\u27A1", "\u2728", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"hüftbreiter, gerader Stand",
                            "leicht in die Hocken gehen und ein Bein angewinkelt über das Standbein legen",
                            "für mehr Intenstät stärker in die Hocke gehen",
                            "die Arme nach vorne oder oben strecken",
                            "jede Seite 30 Sekunden halten"},
                    R.drawable.ein_bein_stand,
                    30),
            //10
            new LegExercise("Side Kick kniend",
                    new String[]{"\u25CF", "\u25CF", "\u25CF", "\u27A1", "\uD83D\uDCAA"},
                    new String[]{"Haltung wie auf Bild einnehmen",
                            "auf linke Hand stützen, rechte Hand an Hinterkopf",
                            "rechtes Bein ausstrecken und auf Hüfthöhe heben",
                            "Bein so weit wie möglich auf einer Ebene nach vorne und wieder nach hinten bewegen",
                            " 10 Wiederholungen pro Seite"},
                    R.drawable.side_kick_knie,
                    0)
    };

    public LegExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds) {
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
