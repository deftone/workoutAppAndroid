package de.deftone.bitsandpizzas.data;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 * alle bilder sind auf (512 x 332) px^2 skaliert (wenige sind etwas kleiner und manchmal leider etwas unscharf)
 */


public class LegExercise {

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;
    private int[] weight;

    public static final LegExercise[] LEG_EXERCISES = {
            //0
            new LegExercise("Kniebeuge im Ausfallschritt",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"mit leicht gebeugten Knien stehen",
                            "Füsse großen Schrittabstand entfernt ",
                            "Oberkörper gerade, vorgestreckte Brust ",
                            "dann das vordere Knie beugen, bis Oberschenkel waagerecht und wieder aufrichten ",
                            "je größer der Abstand, desto mehr Gesäßmuskel ",
                            "je kleiner der Abstand, desto mehr Oberschenkelmuskel ",
                            "20 Wiederholungen pro Seite "},
                    R.drawable.ausfallschritt,
                    0,
                    new int[]{2}),
            //1
            new LegExercise("Kniebeugen",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"mit gestreckten Armen, leicht gegrätschten Füßen stehen",
                            "Kopf gerade, Brust raus, ganz leichtes Hohlkreuz",
                            "die Fersen dürfen sich nicht vom Boden heben, Rücken gerade",
                            "kontrolliert in die Knie gehen, bis die Oberschenkel waagerecht sind",
                            "dann wieder aufrichten in die Ausgangsposition",
                            "Varianten: Beine Schulterbreit oder weit grätscht",
                            "30 Wiederholungen"},
                    R.drawable.kniebeugen,
                    0,
                    new int[]{2}),
            //2
            new LegExercise("Bein seitlich im 4-Füßler heben",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"in den Vierfüßlerstand gehen",
                            "Handflächen unten den Schultern, Füße auf den Zehenballen",
                            "beide Knie leicht (1 cm) vom Boden heben",
                            "langsam ein Bein zur Seite anheben und wieder senken",
                            "kein Knie berührt während der Übung den Boden",
                            "leichte Variante: nicht bewegendes Knie setzt auf",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.bein_seitlich_heben_4_fuessler,
                    0,
                    new int[]{3, 2}),
            //3 ganzkoerper/rumof?
            new LegExercise("Knie heben im Vierfüßler",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"in den Vierfüßlerstand gehen",
                            "Handflächen unten den Schultern, Fußspann auf den Boden ablegen, oder auf den Zehenballen stehen",
                            "beide Knie leicht (1 cm) vom Boden heben",
                            "langsam ein Bein in der angewinkelten Stellung nach oben heben und wieder zurück",
                            "kein Knie berührt während der Übung den Boden",
                            "leichte Variante: nicht bewegendes Knie setzt auf",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.knieheben,
                    0,
                    new int[]{3, 1}),
            //4 ganzkoerper? rumpf
            new LegExercise("Beckenheben vom Boden",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"auf dem Rücken liegen, Beine sind aufgestellt ",
                            "Arme liegen entlang dem Körper, Handflächen auf dem Boden",
                            "Becken vom Boden heben, oben 2 Sekunden halten",
                            "Becken wieder absinken, ohne ganz abzusetzen",
                            "10 Wiederholungen"},
                    R.drawable.schulterbruecke,
                    0,
                    new int[]{1}),
            //5
            new LegExercise("Bein heben in Schulterbrücke",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"in die Schulterbrücke gehen",
                            "das Becken bleibt die ganze Zeit oben",
                            "ein Bein vom Boden abheben und langsam hoch (senkrecht zum Boden) heben",
                            "und wieder absenken, bis es parallel zum anderen Bein ist",
                            "einfache Variante: ohne Beinheben, nur Halten",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.schulterbruecke_bein_heben,
                    0,
                    new int[]{3, 1}),
            //6
            new LegExercise("Oberes Bein im Liegen heben",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"seitlich auf dem Boden liegen ",
                            "mit dem Unterarm abstützen, der Kopf ist aufrecht",
                            "das gestreckte Bein seitlich nach oben heben",
                            "das Bein bleibt die ganze Zeit gestreckt ",
                            "den Winkel nicht zu gross werden lassen (max. 70°)",
                            " man kann das Bein im maximal Punkt einige Sekunden halten",
                            " 20 Wiederholungen pro Seite "},
                    R.drawable.bein_seitlich_heben,
                    0,
                    new int[]{1}),
            //7 - dieses bild ist recht klein und unscharf, koennte ausgetauscht werden
            new LegExercise("Unteres Bein im Liegen heben",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"seitlich auf dem Boden liegen, auf unteren Ellebogen stützen",
                            "unteres Bein gestreckt, oberes Bein gebeugt, Fuß for dem liegenden Knie",
                            "liegendes Bein gestreckt so hoch wie möglich heben",
                            "am maximalen Punkt 2-3 Sekunden halten und wieder absenken",
                            "20 Wiederholungen pro Seite"},
                    R.drawable.abduktion_am_boden,
                    0,
                    new int[]{1}),
            //8 oberkoerper/ruecken/arme
            new LegExercise("Standwaage",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"aufrecht stehen, Arme nach oben strecken",
                            "Oberkörper nach vorne beugen",
                            "gleichzeitig ein Bein so weit wie möglich heben",
                            "Ferse nach hinten strecken, Zehen zum Körper ziehen",
                            "Arme, Oberkörper und das gestreckte Bein bilden eine Linie",
                            "je höher das Bein, je weicher der Boden, desto schwieriger",
                            "jede Seite 30 Sekunden halten"},
                    R.drawable.standwaage,
                    30,
                    new int[]{2}),
            //9 - auch eher ober/ganzkoerper Haende und Fuss sind abgeschnitten - koennte versuchen das bild nochmal im netz zu finden
            new LegExercise("Knie im Schoss",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"hüftbreiter, gerader Stand",
                            "leicht in die Hocken gehen und ein Bein angewinkelt über das Standbein legen",
                            "für mehr Intenstät stärker in die Hocke gehen",
                            "die Arme nach vorne oder oben strecken",
                            "größere Herausforderung: Augen schliessen",
                            "jede Seite 30 Sekunden halten"},
                    R.drawable.ein_bein_stand,
                    30,
                    new int[]{2}),
            //10 - dieses bild ist recht klein und unscharf, koennte ausgetauscht werden
            //beinbewegung wie bei froschschwimmen (brustschw. erst knie vor, dann bein strecken
//            /und gestreckt nach hinten bewegen
            new LegExercise("Side Kick kniend",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"Haltung wie auf Bild einnehmen",
                            "auf linke Hand stützen, rechte Hand an Hinterkopf",
                            "rechtes Bein ausstrecken und auf Hüfthöhe heben",
                            "Bein so weit wie möglich auf einer Ebene nach vorne und wieder nach hinten bewegen:",
                            "dabei zuerst das Knie vorziehen, wenn das Knie vorne ist das Bein strecken und wieder gestreckt nach hinten bewegen",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.side_kick_knie,
                    0,
                    new int[]{3})
    };

    public LegExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds, int[] weight) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
        this.seconds = seconds;
        this.weight = weight;
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

    public int[] getWeight() {
        return weight;
    }
}
