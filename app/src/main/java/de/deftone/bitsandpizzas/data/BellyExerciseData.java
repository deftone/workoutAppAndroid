package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;
import java.util.List;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.data.Exercise.ARROW;
import static de.deftone.bitsandpizzas.data.Exercise.BULLET;
import static de.deftone.bitsandpizzas.data.Exercise.FINGER_POINT_UP;
import static de.deftone.bitsandpizzas.data.Exercise.MUSCLE;
import static de.deftone.bitsandpizzas.data.Exercise.SPARKLES;
import static de.deftone.bitsandpizzas.data.ExerciseTypes.BELLY;

/**
 * Created by deftone on 07.02.18.
 */

public class BellyExerciseData {

    public static List<Exercise> getAllBellyExercises() {
        List<Exercise> exercises = new ArrayList<>();

        exercises.add(new Exercise(0, BELLY, "Crunch", getIconsCrunch(),
                getDescCrunch(), R.drawable.crunch, 0, new int[]{2}));

        exercises.add(new Exercise(1, BELLY, "schräger Crunch", getIconsSchrCrunch(),
                getDescSchrCrunch(), R.drawable.crunch_schraeg, 0, new int[]{2}));

        exercises.add(new Exercise(2, BELLY, "Sit up", getIconsSitUp(),
                getDescSitUp(), R.drawable.sit_up, 0, new int[]{3}));

        exercises.add(new Exercise(3, BELLY, "Pseudo Sit-up", getIconsPseudoSU(),
                getDescPseudoSU(), R.drawable.pseudo_sit_up, 0, new int[]{3, 2}));

        exercises.add(new Exercise(4, BELLY, "Fahrrad fahren", getIconsFahrad(),
                getDescFahrrad(), R.drawable.fahrradfahren, 0, new int[]{3, 2}));

        exercises.add(new Exercise(5, BELLY, "Käfer", getIconsKaefer(),
                getDescKaefer(), R.drawable.kaefer, 0, new int[]{2}));

        exercises.add(new Exercise(6, BELLY, "The Hundret", getIconsHundret(),
                getDescHundret(), R.drawable.hundert, 0, new int[]{2}));

        exercises.add(new Exercise(7, BELLY, "Roll up", getIconsRoll(),
                getDescRoll(), R.drawable.roll_up, 0, new int[]{1}));

        exercises.add(new Exercise(8, BELLY, "Boot", getIconsBoot(),
                getDescBoot(), R.drawable.boot, 30, new int[]{3, 1}));

        return exercises;
    }


    private static String[] getIconsCrunch() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, ARROW, ARROW, MUSCLE};
    }

    private static String[] getDescCrunch() {
        return new String[]{"Rücken liegt auf dem Boden",
                "Hände hinterm Kopf verschränkt",
                "Oberschenkel senkrecht, Knie gebeugt, Füße verschränkt",
                "beim Einatmen Schultern vom Boden lösen",
                "die Knie durch Einrollen der Wirbelsäule Richtung Kopf bringen",
                "beim Ausatmen wieder zum Boden absenken",
                "20 Wiederholungen"
        };
    }

    private static String[] getIconsSchrCrunch() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, ARROW, MUSCLE};
    }

    private static String[] getDescSchrCrunch() {
        return new String[]{"Rücken liegt auf dem Boden",
                "Oberschenkel senkrecht, Knie gebeugt",
                "Arme gestreckt außen neben gebeugten Beinen",
                "beim Einatmen Schultern vom Boden lösen",
                "beim Ausatmen wieder zum Boden absenken",
                "10 Wiederholungen pro Seite"};
    }

    private static String[] getIconsSitUp() {
        return new String[]{BULLET, SPARKLES, BULLET, ARROW, ARROW, MUSCLE};
    }

    private static String[] getDescSitUp() {
        return new String[]{"auf dem Boden liegen, Beine aufgestellt, Füße flach aufm Boden",
                "Einfacher: Füße unter der Heizung (o.ä.) fixieren",
                "Hände verschränkt hinterm Kopf (schwer), vor der Brust (mittel) oder nach vorn strecken (leicht)",
                "beim Einatmen den Oberkörper gerundet vom Boden heben",
                "beim Ausatmen wieder zurück (aber nicht koplett) zum Boden sinken",
                "10 Wiederholungen"};
    }

    private static String[] getIconsPseudoSU() {
        return new String[]{BULLET, BULLET, BULLET, FINGER_POINT_UP, ARROW, ARROW, SPARKLES, MUSCLE};
    }

    private static String[] getDescPseudoSU() {
        return new String[]{"mit gebeugten Knien sitzen, Füße flach aufm Boden",
                "Oberkörper nah zu den Oberschenkeln",
                "Hände nach vorne gestreckt",
                "Rücken ist die ganze Zeit leicht gerundet",
                "beim Einatmen den Oberkörper langsam nach hinten neigen (bis 45°), die Arme nach oben strecken und dort 3 Sek halten",
                "beim Ausatmen wieder aufrichten und die Arme senken",
                "leichte Variante: die Arme bleiben nach vorne gestreckt",
                "10 Wiederholungen"};
    }

    private static String[] getIconsFahrad() {
        return new String[]{BULLET, BULLET, FINGER_POINT_UP, ARROW, ARROW, ARROW, SPARKLES, MUSCLE};
    }

    private static String[] getDescFahrrad() {
        return new String[]{"Oberkörper leicht nach hinten kippen und mit den Unterarmen am Boden abstützen",
                "Beine ca 45° gestreckt vom Boden abheben und halten",
                "auf geraden Rücken achten",
                "beim Ausatmen ein Bein beugen und Knie Richtung Brust ziehen",
                "beim Einatmen Bein wieder strecken und beide Beine parallel",
                "beim nächsten Atemzug Beine wechseln",
                "leichtere Alternative: beugen und strecken direkt im Wechsel",
                "jedes Bein 10 mal beugen und strecken"};
    }

    private static String[] getIconsKaefer() {
        return new String[]{BULLET, ARROW, FINGER_POINT_UP, MUSCLE};
    }

    private static String[] getDescKaefer() {
        return new String[]{"Hände hinterm Kopf, Ellebogen zeigen nach außen",
                "Beine abwechselnd ausstrecken bzw Knie zum diagonal entgegengesetzen Ellebogen ziehen",
                "darauf achten, dass oberer Rücken und Schultern nicht den Boden berühren und dass das Becken fest auf dem Boden bleibt",
                "pro Seite 10 Bewegungen"};
    }

    private static String[] getIconsHundret() {
        return new String[]{BULLET, BULLET, SPARKLES, BULLET, ARROW, ARROW, MUSCLE};
    }

    private static String[] getDescHundret() {
        return new String[]{"auf den Rücken legen, Kopf und Schultern heben, Kinn zur Brust",
                "Beine gestreckt auf einer Höhe von ca. 45° halten",
                "je tiefer desto anspruchsvoller - aber darauf achten, dass der Rücken am Boden bleibt",
                "Arme gestreckt auf Hüfthöhe heben",
                "Arme schnell auf und abbewegen (pumpen)",
                "jeweils über 5 Pumpbewegungen ein- und ausatmen",
                "insgesamt 100 mal pumpen"};
    }

    private static String[] getIconsRoll() {
        return new String[]{BULLET, BULLET, ARROW, ARROW, ARROW, ARROW, ARROW, MUSCLE};
    }

    private static String[] getDescRoll() {
        return new String[]{"auf dem Rücken liegen",
                "Arme über den Kopf austrecken",
                "die Arme vom Boden heben",
                "sobald die Arme senkrecht sind, die Bauchmuskeln anspannen und den Oberkörper Wirbel für Wirbel heben/aufrollen",
                "soweit aufrollen bis die Fingerspitzen bei den Zehen angekommen sind",
                "beim Ausatmen den Rücken runden und Nabel zur Wirbelsäule ziehen",
                "beim Einatmen Wirbel für Wirbel abrollen bis wieder in Startposition",
                "10 Wiederholungen"};
    }

    private static String[] getIconsBoot() {
        return new String[]{BULLET, ARROW, ARROW, FINGER_POINT_UP, SPARKLES, MUSCLE};
    }

    private static String[] getDescBoot() {
        return new String[]{"aufrecht mit angewinkelten Knien hinsetzen",
                "Oberkörper leicht zurücklehnen",
                "ein Bein nach dem anderen anheben",
                "Arme und Beine sind gestreckt",
                "einfache Variante: die Hände umfassen die Knie",
                "30 Sekunden halten"};
    }
}