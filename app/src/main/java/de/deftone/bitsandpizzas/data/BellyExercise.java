package de.deftone.bitsandpizzas.data;

import de.deftone.bitsandpizzas.R;

/**
 * Created by deftone on 10.11.17.
 */

public class BellyExercise {

    private String name;
    private int imageResourceId;
    private String[] icon;
    private String[] desc;
    private int seconds;
    private int[] weight;

    public static final BellyExercise[] BELLY_EXERCISES = {
            //0 - Bild ist etwas klein und unscharf
            new BellyExercise("Crunch",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"Rücken liegt auf dem Boden",
                            "Hände hinterm Kopf verschränkt",
                            "Oberschenkel senkrecht, Knie gebeugt, Füße verschränkt",
                            "beim Einatmen Schultern vom Boden lösen",
                            "die Knie durch Einrollen der Wirbelsäule Richtung Kopf bringen",
                            "beim Ausatmen wieder zum Boden absenken",
                            "20 Wiederholungen"},
                    R.drawable.crunch,
                    0,
                    new int[]{2}),
            //1
            new BellyExercise("schräger Crunch",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"Rücken liegt auf dem Boden",
                            "Oberschenkel senkrecht, Knie gebeugt",
                            "Arme gestreckt außen neben gebeugten Beinen",
                            "beim Einatmen Schultern vom Boden lösen",
                            "beim Ausatmen wieder zum Boden absenken",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.crunch_schraeg,
                    0,
                    new int[]{2}),
            //2
            new BellyExercise("Sit up",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"auf dem Boden liegen, Beine aufgestellt, Füße flach aufm Boden",
                            "Einfacher: Füße unter der Heizung (o.ä.) fixieren",
                            "Hände verschränkt hinterm Kopf (schwer), vor der Brust (mittel) oder nach vorn strecken (leicht)",
                            "beim Einatmen den Oberkörper gerundet vom Boden heben",
                            "beim Ausatmen wieder zurück (aber nicht koplett) zum Boden sinken",
                            "10 Wiederholungen"},
                    R.drawable.sit_up,
                    0,
                    new int[]{3}),
            //3 - etwas unscharf
            new BellyExercise("Pseudo Sit-up",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"mit gebeugten Knien sitzen, Füße flach aufm Boden",
                            "Oberkörper nah zu den Oberschenkeln",
                            "Hände nach vorne gestreckt",
                            "Rücken ist die ganze Zeit leicht gerundet",
                            "beim Einatmen den Oberkörper langsam nach hinten neigen (bis 45°) und dort 2-10 Sek halten",
                            "beim Ausatmen wieder aufrichten",
                            "20 - 30 Wiederholungen"},
                    R.drawable.pseudo_sit_up,
                    0,
                    new int[]{2}),
            //4
            new BellyExercise("Fahrrad fahren",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"Oberkörper leicht nach hinten kippen und mit den Unterarmen am Boden abstützen",
                            "Beine ca 45° gestreckt vom Boden abheben und halten",
                            "auf geraden Rücken achten",
                            "beim Ausatmen ein Bein beugen und Knie Richtung Brust ziehen",
                            "beim Einatmen Bein wieder strecken und beide Beine parallel",
                            "beim nächsten Atemzug Beine wechseln",
                            "Alternativ: beugen und strecken direkt im Wechsel",
                            "so oft Wiederholen bis ein Brennen zu spüren ist"},
                    R.drawable.fahrradfahren,
                    0,
                    new int[]{2}),
            //5
            new BellyExercise("Criss-Cross",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"Hände hinterm Kopf, Ellebogen zeigen nach außen",
                            "Beine abwechselnd ausstrecken bzw Knie zum diagonal entgegengesetzen Ellebogen ziehen",
                            "darauf achten, dass oberer Rücken und Schultern nicht den Boden berühren und dass das Becken fest auf dem Boden bleibt",
                            "pro Seite 10 Bewegungen"},
                    R.drawable.kaefer,
                    0,
                    new int[]{2}),
            //6
            new BellyExercise("The Hundret",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"auf den Rücken legen, Kopf und Schultern heben, Kinn zur Brust",
                            "Beine gestreckt auf einer Höhe von ca. 45° halten",
                            "je tiefer desto anspruchsvoller - aber darauf achten, dass der Rücken am Boden bleibt",
                            "Arme gestreckt auf Hüfthöhe heben",
                            "Arme schnell auf und abbewegen (pumpen)",
                            "jeweils über 5 Pumpbewegungen ein- und ausatmen",
                            "insgesamt 100 mal pumpen"},
                    R.drawable.hundert,
                    0,
                    new int[]{2}),
            //7
            new BellyExercise("Roll up",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"auf dem Rücken liegen",
                            "Arme über den Kopf austrecken",
                            "die Arme vom Boden heben",
                            "sobald die Arme senkrecht sind, die Bauchmuskeln anspannen und den Oberkörper Wirbel für Wirbel heben/aufrollen",
                            "soweit aufrollen bis die Fingerspitzen bei den Zehen angekommen sind",
                            "beim Ausatmen den Rücken runden und Nabel zur Wirbelsäule ziehen",
                            "beim Einatmen Wirbel für Wirbel abrollen bis wieder in Startposition",
                            "10 - 20 Wiederholungen"},
                    R.drawable.roll_up,
                    0,
                    new int[]{2}),
            //8
            new BellyExercise("Unterarmstütz",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"auf den Unterarmen auf den Boden aufstützen",
                            "Fußspitzen sind aufgestützt",
                            "Rücken gerade halten",
                            "einfache Variante: mit den Knien auf dem Boden abstützen",
                            "eine Minute halten, dabei normal atmen"},
                    R.drawable.unterarmstuetz,
                    60,
                    new int[]{3}),
            //9
            new BellyExercise("Unterarmstütz 2",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"auf den Unterarmen auf den Boden aufstützen",
                            "Fußspitzen sind aufgestützt",
                            "Rücken gerade halten",
                            "einfache Variante: mit den Knien auf dem Boden abstützen",
                            "ein Bein gestreckt abheben und wieder absinken",
                            "10 Wiederholungen pro Seite"},
                    R.drawable.unterarmstuetz_mit_heben,
                    0,
                    new int[]{3}),
            //10
            new BellyExercise("Seitenstütz",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"seitlich auf einem Unterarm auf den Boden aufstützen",
                            "Körper ist eine Linie",
                            "freien Arm in die Luft strecken oder auf der Hüfte abstützen",
                            "einfache Variante: mit den Knien auf dem Boden abstützen",
                            "jede Seite 30 Sekunden halten, dabei normal atmen"},
                    R.drawable.seitstuetz,
                    30,
                    new int[]{3}),
            //11
            new BellyExercise("Boot",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
                    new String[]{"aufrecht mit angewinkelten Knien hinsetzen",
                            "Oberkörper leicht zurücklehnen",
                            "ein Bein nach dem anderen anheben",
                            "Arme und Beine sind gestreckt",
                            "einfache Variante: die Hände umfassen die Knie",
                            "30 Sekunden halten"},
                    R.drawable.boot,
                    30,
                    new int[]{2}),
            //12
            new BellyExercise("Leg Pull Up",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.FINGER_POINT_UP),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
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
                    0,
                    new int[]{3, 2}),
            //13
            new BellyExercise("Leg Pull Down",
                    new String[]{Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.BULLET),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.ARROW),
                            Icons.getIcon(Icons.SPARKLES),
                            Icons.getIcon(Icons.MUSCLE)},
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
                    0,
                    new int[]{3, 2})
    };

    private BellyExercise(String name, String[] icon, String[] desc, int imageResourceId, int seconds, int[] weight) {
        this.name = name;
        this.desc = desc;
        this.icon = icon;
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
