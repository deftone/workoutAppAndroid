package de.deftone.bitsandpizzas.data;

import java.util.ArrayList;
import java.util.List;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.data.Exercise.ARROW;
import static de.deftone.bitsandpizzas.data.Exercise.BULLET;
import static de.deftone.bitsandpizzas.data.Exercise.FINGER_POINT_UP;
import static de.deftone.bitsandpizzas.data.Exercise.MUSCLE;
import static de.deftone.bitsandpizzas.data.Exercise.SPARKLES;
import static de.deftone.bitsandpizzas.data.ExerciseTypes.LEG;

/**
 * Created by deftone on 07.02.18.
 */

public class LegExerciseData {

    public static List<Exercise> getAllLegExercises() {
        List<Exercise> exercises = new ArrayList<>();

        exercises.add(new Exercise(0, LEG, "Kniebeuge im Ausfallschritt", getIconsKnieb(),
                getDescKnieb(), R.drawable.ausfallschritt, 0, new int[]{2}));

        exercises.add(new Exercise(1, LEG, "Kniebeugen", getIconsKnieb2(),
                getDescKnieb2(), R.drawable.kniebeugen, 0, new int[]{2}));

        exercises.add(new Exercise(2, LEG, "Fersenheben", getIconsKnieb3(),
                getDescKnieb3(), R.drawable.squad_heels_raised, 0, new int[]{2}));

        exercises.add(new Exercise(3, LEG, "Oberes Bein im Liegen heben", getIconsHeben(),
                getDescHeben(), R.drawable.bein_seitlich_heben, 0, new int[]{2}));

        exercises.add(new Exercise(4, LEG, "Unteres Bein im Liegen heben", getIconsHeben2(),
                getDescHeben2(), R.drawable.abduktion_am_boden, 0, new int[]{1}));

        exercises.add(new Exercise(5, LEG, "Side Kick kniend", getIconsSideKick(),
                getDescSideKick(), R.drawable.side_kick_knie, 0, new int[]{3}));

        return exercises;
    }

    private static String[] getIconsKnieb() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, FINGER_POINT_UP, FINGER_POINT_UP, MUSCLE};
    }

    private static String[] getDescKnieb() {
        return new String[]{"mit leicht gebeugten Knien stehen",
                "Füsse großen Schrittabstand entfernt ",
                "Oberkörper gerade, vorgestreckte Brust ",
                "dann das vordere Knie beugen, bis Oberschenkel waagerecht und wieder aufrichten ",
                "je größer der Abstand, desto mehr Gesäßmuskel ",
                "je kleiner der Abstand, desto mehr Oberschenkelmuskel ",
                "20 Wiederholungen pro Seite "};
    }

    private static String[] getIconsKnieb2() {
        return new String[]{BULLET, BULLET, FINGER_POINT_UP, ARROW, ARROW, SPARKLES, MUSCLE};
    }

    private static String[] getDescKnieb2() {
        return new String[]{"mit gestreckten Armen, leicht gegrätschten Füßen stehen",
                "Kopf gerade, Brust raus, ganz leichtes Hohlkreuz",
                "die Fersen dürfen sich nicht vom Boden heben, Rücken gerade",
                "kontrolliert in die Knie gehen, bis die Oberschenkel waagerecht sind",
                "dann wieder aufrichten in die Ausgangsposition",
                "Varianten: Beine Schulterbreit oder weit grätscht",
                "30 Wiederholungen"};
    }

    private static String[] getIconsKnieb3() {
        return new String[]{BULLET, BULLET, ARROW, FINGER_POINT_UP, MUSCLE, SPARKLES};
    }

    private static String[] getDescKnieb3() {
        return new String[]{"in einen tiefen Jujum Sogi gehen",
                "Arme vorm Körper wie auf dem Bild oder Hände in die Hüfte stemmen",
                "eine Ferse langsam vom Boden abheben und wieder absenken",
                "nicht mit Schwung, nicht fallen lassen, sondern kontrollierte Bewegung",
                "jede Seite 10 mal, abschließend 10 mal mit beiden Fersen gleichzeitig",
                "anspruchsvoller: den Körper absenken, wenn die Fersen hochgehen"};
    }

    private static String[] getIconsHeben() {
        return new String[]{BULLET, BULLET, ARROW, ARROW, FINGER_POINT_UP, SPARKLES, MUSCLE};
    }

    private static String[] getDescHeben() {
        return new String[]{"seitlich auf dem Boden liegen ",
                "mit dem Unterarm abstützen, der Kopf ist aufrecht",
                "das gestreckte Bein seitlich nach oben heben",
                "das Bein bleibt die ganze Zeit gestreckt ",
                "den Winkel nicht zu gross werden lassen (max. 70°)",
                " man kann das Bein im maximal Punkt einige Sekunden halten",
                " 20 Wiederholungen pro Seite"};
    }

    private static String[] getIconsHeben2() {
        return new String[]{BULLET, BULLET, ARROW, ARROW, MUSCLE};
    }

    private static String[] getDescHeben2() {
        return new String[]{"seitlich auf dem Boden liegen, auf unteren Ellebogen stützen",
                "unteres Bein gestreckt, oberes Bein gebeugt, Fuß for dem liegenden Knie",
                "liegendes Bein gestreckt so hoch wie möglich heben",
                "am maximalen Punkt 2-3 Sekunden halten und wieder absenken",
                "20 Wiederholungen pro Seite"};
    }

    private static String[] getIconsSideKick() {
        return new String[]{BULLET, BULLET, BULLET, ARROW, ARROW, MUSCLE};
    }

    private static String[] getDescSideKick() {
        return new String[]{"Haltung wie auf Bild einnehmen",
                "auf linke Hand stützen, rechte Hand an Hinterkopf",
                "rechtes Bein ausstrecken und auf Hüfthöhe heben",
                "Bein so weit wie möglich auf einer Ebene nach vorne und wieder nach hinten bewegen:",
                "dabei zuerst das Knie vorziehen, wenn das Knie vorne ist das Bein strecken und wieder gestreckt nach hinten bewegen",
                "10 Wiederholungen pro Seite"};
    }
}